package com.example.springboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.springboot.util.JsonUtil;
import com.example.springboot.MessagQueue;;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.example.springboot")
public class Application {

public static void main(String[] args) {
		
		JsonUtil.loadSchema();
		
		
		SpringApplication.run(Application.class, args);
		try {
			MessagQueue.messageQueue();
		} catch (Exception e) {
			System.out.println("Consumer MQ FAILED");
		}
	}
}
