package com.example.springboot.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.constant.CommonConstants;
import com.example.springboot.dao.RedisDao;
import com.example.springboot.util.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;

import redis.clients.jedis.exceptions.JedisException;

@Service
public class RedisServiceImpl implements RedisService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	RedisDao<String> redisDao;
	
	@Autowired
    MessageQueueService messageQueueService;
	

	
	private Map<String,String> relationMap = new HashMap<>();
	
	public void indexQueue(JSONObject jsonObject, String uuid) {

        try {

            Map<String,String> simpleMap = new HashMap<>();


            for(Object key : jsonObject.keySet()) {
                String attributeKey = String.valueOf(key);
                Object attributeVal = jsonObject.get(String.valueOf(key));
                String edge = attributeKey;

                if(attributeVal instanceof JSONObject) {
                    JSONObject embdObject = (JSONObject) attributeVal;

                    JSONObject joinObj = new JSONObject();
                    if(edge.equals("planserviceCostShares") && embdObject.getString("objectType").equals("membercostshare")){
                        joinObj.put("name", "planservice_membercostshare");
                    } else {
                        joinObj.put("name", embdObject.getString("objectType"));
                    }

                    joinObj.put("parent", uuid);
                    embdObject.put("plan_service", joinObj);
                    embdObject.put("parent_id", uuid);
                    System.out.println(embdObject.toString());
                    messageQueueService.addToMessageQueue(embdObject.toString(), false);

                } else if (attributeVal instanceof JSONArray) {

                    JSONArray jsonArray = (JSONArray) attributeVal;
                    Iterator<Object> jsonIterator = jsonArray.iterator();

                    while(jsonIterator.hasNext()) {
                        JSONObject embdObject = (JSONObject) jsonIterator.next();
                        embdObject.put("parent_id", uuid);
                        System.out.println(embdObject.toString());

                        String embd_uuid = embdObject.getString("objectId");
                        relationMap.put(embd_uuid, uuid);

                        indexQueue(embdObject, embd_uuid);
                    }

                } else {
                    simpleMap.put(attributeKey, String.valueOf(attributeVal));
                }
            }

            JSONObject joinObj = new JSONObject();
            joinObj.put("name", simpleMap.get("objectType"));

            if(!simpleMap.containsKey("planType")){
                joinObj.put("parent", relationMap.get(uuid));
            }

            JSONObject obj1 = new JSONObject(simpleMap);
            obj1.put("plan_service", joinObj);
            obj1.put("parent_id", relationMap.get(uuid));
            System.out.println(obj1.toString());
            messageQueueService.addToMessageQueue(obj1.toString(), false);


        }
        catch(JedisException e) {
            e.printStackTrace();
        }
    }


	public String getValue(final String key) {
		logger.info("getValue ( key : " + key + " - Start");
		return redisDao.getValue(key);
	}

	public void postValue(final String key, final String value) {
		logger.info("postValue ( key : " + key + " value : " + value + " - Start");
		redisDao.putValue(key, value);
		logger.info("postValue ( key : " + key + " value : " + value + " - End");
	}

	public boolean deleteValue(final String key) {
		logger.info("deleteValue ( key : " + key + " - Start");
		return redisDao.deleteValue(key);
	}

	@Override
	public String getHash(String internalID) {
		return redisDao.getHash(internalID);
	}

	/**
	 * Added to traverse every object and array in the inputed jsonNode
	 */
	public void traverseInput(JsonNode inputData) {
		inputData.fields().forEachRemaining(entry -> {

			// Check if the field is an array
			if (entry.getValue().isArray()) {
				ArrayList<JsonNode> innerValues = new ArrayList<JsonNode>();
				Iterator<JsonNode> iterator = entry.getValue().iterator();

				// Iterate over each element in the array
				while (iterator.hasNext()) {
					JsonNode en = (JsonNode) iterator.next();

					// Check if the objects present in this array
					if (en.isContainerNode())
						traverseInput(en);

					// Add the array object to the temporary array list
					innerValues.add(replace(en));
					traverseInput(en);
				}

				// Update the array with references created
				if (!innerValues.isEmpty()) {
					// Remove the individual array objects from the array node
					((ArrayNode) entry.getValue()).removeAll();

					// Replace the existing array objects with the references of each array element
					// created on a whole
					innerValues.forEach(s -> {
						if (s != null)
							((ArrayNode) entry.getValue()).add(s);
					});
				}
			}
			// Check if the field is an object
			else if (entry.getValue().isContainerNode()) {
				// Check if there are child objects
				traverseInput(entry.getValue());
				replaceWithId(entry);
			}
		});
	}

	/**
	 * Added to populate the nested json data by using the child node references
	 */
	public void populateNestedData(JsonNode parent, Set<String> childIdSet) {
		if (parent == null)
			return;

		// Iterate over only those elements that contain an object Id
		while (parent.toString().contains(CommonConstants.ID)) {
			parent.fields().forEachRemaining(s -> {

				// Check if the element is an array
				if (s.getValue().isArray()) {
					ArrayList<JsonNode> innerValues = new ArrayList<>();
					s.getValue().iterator().forEachRemaining(node -> {
						if (node.asText().startsWith((CommonConstants.ID)))
							innerValues.add(node);
						if (node.isContainerNode())
							populateNestedData(node, childIdSet);

						node.iterator().forEachRemaining(innerNode -> {
							if (innerNode.isContainerNode())
								populateNestedData(node, childIdSet);
						});
					});

					if (!innerValues.isEmpty()) {
						((ArrayNode) s.getValue()).removeAll();

						// Iterate through every inner value in the temp array list
						innerValues.forEach(innerValue -> {

							if (childIdSet != null)
								childIdSet.add(innerValue.asText());

							String value = redisDao.getValue(innerValue.asText());

							if (value != null)
								((ArrayNode) s.getValue()).add(JsonUtil.nodeFromString(value));
						});
					}
				}

				String value = s.getValue().asText();

				if (value.startsWith(CommonConstants.ID)) {
					if (childIdSet != null)
						childIdSet.add(value);

					String val = redisDao.getValue(value);
					val = val == null ? "" : val;
					JsonNode node = JsonUtil.nodeFromString(val);
					s.setValue(node);
				}
			});
		}
	}

	/**
	 * Added to replace the node value with reference id generated
	 * 
	 * @param entry
	 */
	private void replaceWithId(Map.Entry<String, JsonNode> entry) {
		JsonNode node = replace(entry.getValue());
		entry.setValue(node);
	}

	/**
	 * Added to persist the child value in redis before replacing the node value
	 * with reference id generated
	 * 
	 * @param entry
	 * @return
	 */
	private JsonNode replace(JsonNode entry) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		String value = entry.toString();
		String id = CommonConstants.ID + entry.get("objectType").asText() + "_" + entry.get("objectId").asText();
		JsonNode node = mapper.valueToTree(id);
		redisDao.putValue(id, value);
		return node;
	}

}
