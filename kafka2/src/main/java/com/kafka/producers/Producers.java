package com.kafka.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Producers {

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplatete;
	
	
	public void produceMessage(String msg) {
		log.info(" produceMessage ::: " + msg);
		kafkaTemplatete.send("topic-project", msg);
	}
	
}
