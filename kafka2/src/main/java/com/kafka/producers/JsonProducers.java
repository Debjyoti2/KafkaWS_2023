package com.kafka.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.model.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonProducers {
	
	@Autowired 
	private KafkaTemplate<String,User> kafkaTemplate;
	
	public void publishMessage(User user) {
		
		log.info("User Data : "  + user.toString());
		
		Message<User> message = MessageBuilder
				               .withPayload(user)
				               .setHeader(KafkaHeaders.TOPIC,"topic-project")
				               .build();
		kafkaTemplate.send(message);
		
	}

}
