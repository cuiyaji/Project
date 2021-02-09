package com.example.springboot;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.json.JSONObject;

import redis.clients.jedis.Jedis;

public class MessagQueue {
	private static Jedis jedis;
	private static RestHighLevelClient client = new RestHighLevelClient(
			RestClient.builder(new HttpHost("localhost", 9200, "http")));
	private static final String IndexName="plan";

	public static void messageQueue() throws IOException {
		jedis = new Jedis();
		System.out.println("Consumer MQ started");
		while (true) {
			String message = jedis.rpoplpush("messageQueue", "WorkingMQ");
			if (message == null) {
				continue;
			}
			JSONObject result = new JSONObject(message);
			
			// Get action
			Object obj = result.get("isDelete");
			System.out.println("isDelete: " + obj.toString());
						
			boolean isDelete = Boolean.parseBoolean(obj.toString());
			if(!isDelete) {
				JSONObject plan= new JSONObject(result.get("message").toString());
				System.out.println(plan.toString());
				postDocument(plan);
			}else {
				deleteDocument(result.get("message").toString());
			}
		}
	}
	
	private static boolean indexExists() throws IOException {
		GetIndexRequest request = new GetIndexRequest(IndexName); 
		boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
		return exists;
	}
	
	private static String postDocument(JSONObject plan) throws IOException {
		if(!indexExists()) {
			createElasticIndex();
		}			
		IndexRequest request = new IndexRequest(IndexName);
		request.id(plan.get("objectId").toString());
		request.source(plan.toString(), XContentType.JSON);
		if (plan.has("parent_id")) {
			request.routing(plan.get("parent_id").toString());
		}
		IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
		System.out.println("response id: "+indexResponse.getId());
		return indexResponse.getResult().name();
	}
	
	private static void createElasticIndex() throws IOException {
		CreateIndexRequest request = new CreateIndexRequest(IndexName);
		request.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2));
		String mapping = getMapping();
		request.mapping(mapping, XContentType.JSON);

		client.indices().create(request, RequestOptions.DEFAULT); 
	}
	
	private static void deleteDocument(String documentId) throws IOException {
		DeleteRequest request = new DeleteRequest(IndexName, documentId);
		try {
			client.delete(request, RequestOptions.DEFAULT);
		} catch (Exception e) {
			System.out.println("Error: check if mapping already deleted.");
		}
	}
	
	private static String getMapping() {
		String mapping = "{\r\n" +
				"    \"properties\": {\r\n" +
				"      \"objectId\": {\r\n" +
				"        \"type\": \"keyword\"\r\n" +
				"      },\r\n" +
				"      \"plan_service\":{\r\n" +
				"        \"type\": \"join\",\r\n" +
				"        \"relations\":{\r\n" +
				"          \"plan\": [\"membercostshare\", \"planservice\"],\r\n" +
				"          \"planservice\": [\"service\", \"planservice_membercostshare\"]\r\n" +
				"        }\r\n" +
				"      }\r\n" +
				"    }\r\n" +
				"  }\r\n" +
				"}";

		
		return mapping;
	}
}
