package com.example.springboot.service;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.dao.MessageQueueDao;


@Service
public class MessageQueueService {
	
	@Autowired
	private MessageQueueDao messageQueueDao;

	public boolean addToMessageQueue(String message, boolean isDelete) {
		JSONObject object = new JSONObject();
		object.put("message", message);
		object.put("isDelete", isDelete);
		
		try {
			messageQueueDao.addToQueue("messageQueue", object.toString());
			System.out.println("Message saved successfully: " + object.toString());
			return true;
		} catch (Exception s) {
			return false;
		}
	}
}
