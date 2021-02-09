package com.example.springboot.controller;

import java.text.ParseException;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.example.springboot.constant.CommonConstants;
import com.example.springboot.service.MessageQueueService;
import com.example.springboot.service.RedisService;
import com.example.springboot.util.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.JWSSigner;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;


@RestController
public class RestApiController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RedisService redisService;
	
	
	 @Autowired
    private MessageQueueService messageQueueService;
	
	private RSAKey rsaPublicJWK;

	@GetMapping(value = "/")
	public String getValue() {
		return "Welcome to my INFO7255 Demo";
	}

	@GetMapping(value = "/{object}/{key}")
	public ResponseEntity<String> getValue(@PathVariable String object, @PathVariable String key, @RequestHeader HttpHeaders requestHeaders) {
		logger.info("getValue(String object : " + object + " key : " + key + " - Start");

		String internalID = CommonConstants.ID + object + "_" + key;
		String value = redisService.getValue(internalID);
		try {
			if (!ifAuthorized(requestHeaders)) {
				return ResponseEntity.badRequest().body(" {\"message\": \"Unauthorized\" }");
			}
			if (value == null) {
				return new ResponseEntity<String>("{\"message\": \"No Data Found\" }", HttpStatus.NOT_FOUND);
			}	
			JsonNode node = JsonUtil.nodeFromString(value);
			redisService.populateNestedData(node, null);
			value = node.toString();
			return ResponseEntity.ok().body(value);
		} catch (Exception e) {
			logger.error(e.getMessage());
			return ResponseEntity.badRequest().body(" {\"message\": \"Unauthorized\" }");
		}
	}

	@PostMapping(value = "/{object}")
	public ResponseEntity<String> postValue(@PathVariable String object, HttpEntity<String> input, @RequestHeader HttpHeaders requestHeaders) {

		logger.info("postValue(String object : " + object + " input : " + input.getBody() + " - Start");

		String planId = "";
		try {
			if (!ifAuthorized(requestHeaders)) {
				return ResponseEntity.badRequest().body(" {\"message\": \"Unauthorized\" }");
			}
			JsonNode rootNode = JsonUtil.validateAgainstSchema(input.getBody());
			if (null != rootNode) {
				String objectId = rootNode.get("objectId").textValue();
				planId = CommonConstants.ID + rootNode.get("objectType").textValue() + "_" + objectId;
	
				if (redisService.getValue(planId) != null) {
					return ResponseEntity.status(HttpStatus.CONFLICT)
							.body(" {\"message\": \"A resource already exisits with the id: " + objectId + "\" }");
				}
	
				redisService.traverseInput(rootNode);
				redisService.postValue(planId, rootNode.toString());
				redisService.indexQueue(new JSONObject(input.getBody()), objectId);
			} else {
				return ResponseEntity.badRequest().body(" {\"message\": \"Error validating the input data\" }");
			}
	
			logger.info("postValue(String object : " + object + " input : " + input.getBody() + " - End");
	
			return ResponseEntity.ok().body(" {\"message\": \"Succcessed!!" + "\" }");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(" {\"message\": \"Unauthorized\" }");	
		}
	}

	@PutMapping(value = "/{object}/{key}")
	public ResponseEntity<String> putValue(@PathVariable String object, HttpEntity<String> input,
			@PathVariable String key,  @RequestHeader HttpHeaders requestHeaders) {

		logger.info("postValue(String object : " + object + " input : " + input.getBody() + " - Start");

		String internalID = CommonConstants.ID + object + "_" + key;
		String masterObject = redisService.getValue(internalID);
		
		
		try {
			if (!ifAuthorized(requestHeaders)) {
				return ResponseEntity.badRequest().body(" {\"message\": \"Unauthorized\" }");
			} 
			
		} catch (Exception e) {
				return ResponseEntity.badRequest().body(" {\"message\": \"Unauthorized\" }");	
		
		}
		String actualEtag = null;
		try {
			String eTag = requestHeaders.getFirst("If-Match");
	        if (eTag == null) {
	        	return new ResponseEntity<>(" {\"message\": \"if-match must exist\" }", HttpStatus.BAD_REQUEST);
	        }
	       
	    
	       
	        
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(" {\"message\": \"Etag exception \" }", HttpStatus.BAD_REQUEST);
		}
		try {
			if (masterObject == null) {
				return new ResponseEntity<String>("{\"message\": \"No Data Found\" }", HttpStatus.NOT_FOUND);
			}
	
			Set<String> childIdSet = new HashSet<String>();
			childIdSet.add(internalID);
			redisService.populateNestedData(JsonUtil.nodeFromString(masterObject), childIdSet);
			boolean deleteSuccess = false;
	
			for (String id : childIdSet) {
				deleteSuccess = redisService.deleteValue(id);
			}
	
			if (deleteSuccess) {
				String planId = "";
				JsonNode rootNode = JsonUtil.validateAgainstSchema(input.getBody());
				if (null != rootNode) {
					String objectId = rootNode.get("objectId").textValue();
					planId = CommonConstants.ID + rootNode.get("objectType").textValue() + "_" + objectId;
	
					if (redisService.getValue(planId) != null) {
						return ResponseEntity.status(HttpStatus.CONFLICT)
								.body(" {\"message\": \"A resource already exisits with the id: " + planId + "\" }");
					}
	
					redisService.traverseInput(rootNode);
					redisService.postValue(planId, rootNode.toString());
					redisService.indexQueue(new JSONObject(input.getBody()), objectId);
				} else {
					return ResponseEntity.ok().body(" {\"message\": \"Error validating the input data\" }");
				}
//				 String url = "http://localhost:8080/plan/" + key;
//		        RestTemplate restTemplate = new RestTemplate(); 
//		        String token_temp = requestHeaders.getFirst("Authorization");
//		        logger.info("token :" + token_temp );
//		        HttpHeaders temp_header = new HttpHeaders();
//		        temp_header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//		        temp_header.add("Authorization", token_temp );
//		        logger.info("temp_header :" + temp_header );
//		        HttpEntity<String> entity = new HttpEntity<String>("parameters", temp_header);   
//		        System.out.println("rest start ");
//		        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//		        HttpHeaders newHeaders = result.getHeaders();
//		        System.out.println("rest end ");
//		        logger.info("rest get templet result :" + newHeaders + " end");
//				 actualEtag = newHeaders.getFirst("ETag");
//				 String eTag = requestHeaders.getFirst("If-Match");
//		        if (eTag != null && !eTag.equals(actualEtag)) {
//		        	return new ResponseEntity<>(" {\"message\": \"Etag match, but no modified \" }", HttpStatus.NOT_MODIFIED);
//		        }
				logger.info("postValue(String object : " + object + " input : " + input.getBody() + " - End");
				
				return ResponseEntity.ok().body(" {\"message\": \"Updated data with key: " + planId + "\" }");
			}
	
			return ResponseEntity.ok().body(" {\"message\": \"Error updating the object }");
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(" {\"message\": \"Error updating the object }");	
		}
	}

	@PatchMapping(value = "/{object}/{key}")
	public ResponseEntity<String> patchValue(@PathVariable String object, @PathVariable String key,
			HttpEntity<String> input,  @RequestHeader HttpHeaders requestHeaders) {

		logger.info("patchValue(String object : " + object + "String objectId : " + key + " input : " + input.getBody()
				+ " - Start");

		String internalID = CommonConstants.ID + object + "_" + key;
		String value = redisService.getValue(internalID);
		
		try {
			if (!ifAuthorized(requestHeaders)) {
				return ResponseEntity.badRequest().body(" {\"message\": \"Unauthorized\" }");
			} 
			
		} catch (Exception e) {
				return ResponseEntity.badRequest().body(" {\"message\": \"Unauthorized\" }");	
		
		}
		
		if (value == null) {
			return new ResponseEntity<String>("{\"message\": \"No Data Found\" }", HttpStatus.NOT_FOUND);
		}
		String eTag = null;
		try {
			eTag = requestHeaders.getFirst("If-Match");
	        if (eTag == null) {
	        	return new ResponseEntity<>(" {\"message\": \"if-match must exist\" }", HttpStatus.BAD_REQUEST);
	        }
	       
	        
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(" {\"message\": \"Etag exception \" }", HttpStatus.BAD_REQUEST);
		}
	        
		try {
	        
			// Get the old node from redis using the object Id
			JsonNode oldNode = JsonUtil.nodeFromString(value);
			redisService.populateNestedData(oldNode, null);
			value = oldNode.toString();

			// Construct the new node from the input body
			String inputData = input.getBody();
			JsonNode newNode = JsonUtil.nodeFromString(inputData);

			ArrayNode planServicesNew = (ArrayNode) newNode.get("linkedPlanServices");
			Set<JsonNode> planServicesSet = new HashSet<>();
			Set<String> objectIds = new HashSet<String>();

			planServicesNew.addAll((ArrayNode) oldNode.get("linkedPlanServices"));

			for (JsonNode node : planServicesNew) {
				Iterator<Entry<String, JsonNode>> sitr = node.fields();
				while (sitr.hasNext()) {
					Entry<String, JsonNode> val = sitr.next();
					if (val.getKey().equals("objectId")) {
						if (!objectIds.contains(val.getValue().toString())) {
							planServicesSet.add(node);
							objectIds.add(val.getValue().toString());
						}
					}
				}
			}

			planServicesNew.removeAll();

			if (!planServicesSet.isEmpty())
				planServicesSet.forEach(s -> {
					planServicesNew.add(s);
				});

			redisService.traverseInput(newNode);
			redisService.postValue(internalID, newNode.toString());
			redisService.indexQueue(new JSONObject(input.getBody()), newNode.get("objectId").textValue());
//			 String url = "http://localhost:8080/plan/" + key;
//	        RestTemplate restTemplate = new RestTemplate(); 
//	        String token_temp = requestHeaders.getFirst("Authorization");
//	        logger.info("token :" + token_temp );
//	        HttpHeaders temp_header = new HttpHeaders();
//	        temp_header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
//	        temp_header.add("Authorization", token_temp );
//	        logger.info("temp_header :" + temp_header );
//	        HttpEntity<String> entity = new HttpEntity<String>("parameters", temp_header);   
//	        System.out.println("rest start ");
//	        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//	        HttpHeaders newHeaders = result.getHeaders();
//	        System.out.println("rest end ");
//	        logger.info("rest get templet result :" + newHeaders + " end");
//	    
//	        String actualEtag = newHeaders.getFirst("ETag");
//	        if (eTag != null && !eTag.equals(actualEtag)) {
//	        	
//	        	return new ResponseEntity<>(" {\"message\": \"Etag match, but no modified \" }", HttpStatus.NOT_MODIFIED);
//	        }
			
			return ResponseEntity.ok().body(" {\"message\": \"Updated data  successfully! \" }");
		} catch (Exception e) {
			logger.error(e.getMessage());
			return new ResponseEntity<>(" {\"message\": \"Invalid Data\" }", HttpStatus.BAD_REQUEST);
		}

		
		
		
		
	}

	@DeleteMapping(value = "/{object}/{objectId}")
	public ResponseEntity<String> deleteValue(@PathVariable("object") String object,
			@PathVariable("objectId") String objectId,  @RequestHeader HttpHeaders requestHeaders) {

		logger.info("deleteValue(String object : " + object + " objectId : " + objectId + " - Start");
		
		try {
			if (!ifAuthorized(requestHeaders)) {
				return ResponseEntity.badRequest().body(" {\"message\": \"Unauthorized\" }");
				}
			String internalID = CommonConstants.ID + object + "_" + objectId;
			String masterObject = redisService.getValue(internalID);
			Set<String> childIdSet = new HashSet<String>();
			childIdSet.add(internalID);
			redisService.populateNestedData(JsonUtil.nodeFromString(masterObject), childIdSet);
			boolean deleteSuccess = false;
	
			for (String id : childIdSet) {
				deleteSuccess = redisService.deleteValue(id);
			}
	
			logger.info("deleteValue(String object : " + object + " objectId : " + objectId + " - End");
			
			if (deleteSuccess && messageQueueService.addToMessageQueue(objectId, true))
				return new ResponseEntity<>(" {\"message\": \"Deleted\" }", HttpStatus.OK);
	
			return new ResponseEntity<>(" {\"message\": \"There is nothing to delete\" }", HttpStatus.NOT_FOUND);
		}  catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().body(" {\"message\": \"Unauthorized\" }");	
		}
	}
	
	
	

	
	
	@GetMapping("/token")
	public ResponseEntity<String> getToken() throws JOSEException, ParseException {
		RSAKey rsaJWK = new RSAKeyGenerator(2048).keyID("123").generate();
		rsaPublicJWK = rsaJWK.toPublicJWK();
		
		JWSSigner signer = new RSASSASigner(rsaJWK);

		// Prepare JWT with claims set
		int expireTime = 30000; // seconds
		
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
		    .expirationTime(new Date(new Date().getTime() + expireTime * 1000)) // milliseconds
		    .build();

		SignedJWT signedJWT = new SignedJWT(
		    new JWSHeader.Builder(JWSAlgorithm.RS256).keyID(rsaJWK.getKeyID()).build(),
		    claimsSet);
		signedJWT.sign(signer);	
		
		String token = signedJWT.serialize();	
		String res = "{\"status\": \"Successful\",\"token\": \"" + token + "\"}";
		return new ResponseEntity<String>(res, HttpStatus.OK);
	
	}
	
	
	private boolean ifAuthorized(HttpHeaders requestHeaders) throws ParseException, JOSEException {
		String token = requestHeaders.getFirst("Authorization").substring(7);
		// On the consumer side, parse the JWS and verify its RSA signature
		SignedJWT signedJWT = SignedJWT.parse(token);

		JWSVerifier verifier = new RSASSAVerifier(rsaPublicJWK);
		// Retrieve / verify the JWT claims according to the app requirements
		if (!signedJWT.verify(verifier)) {
			return false;
		}
		JWTClaimsSet claimset = signedJWT.getJWTClaimsSet();
		Date exp = 	claimset.getExpirationTime();
		
		// System.out.println(exp);		
		// System.out.println(new Date());
		
		return new Date().before(exp);
	}
	
	
	

}
