package com.consumer.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WikiConsumer {
	
	@Autowired
	private WikiRepo repo;
	
	
	@KafkaListener(topics = "wikimedia-producer",groupId = "myGroup")
	public void consume(String msg) {
		log.info(" Data received :: " + msg);
		
		WikiModel model = new WikiModel();
		model.setMsg(msg);
		repo.save(model);
		
	}

}
