package com.yaji.project.service;

import com.yaji.project.model.SmsRequest;

public interface SmsSender {
	
	void sendSms(SmsRequest smsRequest);

}
