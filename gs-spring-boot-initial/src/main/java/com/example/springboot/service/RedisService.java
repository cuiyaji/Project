package com.example.springboot.service;

import java.util.Set;

import org.json.JSONObject;

import com.fasterxml.jackson.databind.JsonNode;

public interface RedisService {
	
	public void indexQueue(JSONObject jsonObject, String id);

	public String getValue(final String key);

	public void postValue(final String key, final String value);
	
	public void traverseInput(JsonNode inputData);
	
	public void populateNestedData(JsonNode parent, Set<String> childIdSet);

	public boolean deleteValue(final String key);

	public String getHash(String internalID);
	
}
