package com.kafka.consumers;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Consumers {
	
//	@KafkaListener(topics = "topic-project",groupId = "myGroup")
//	public void consume(String message) {
//		
//		log.info("msg received :: " + message);
//		
//	}
	
	@KafkaListener(topics = "topic-project",groupId = "myGroup")
	public void consume(User user) {
		
		log.info("msg received :: " + user);
		
	}
  
	
}
