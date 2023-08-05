package com.producer.kafkatopics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig {

	@Bean
	public NewTopic topic_wikimedia() {
		return TopicBuilder.name("wikimedia-producer")
				.partitions(3)
				.replicas(2)
				.build();
	}
	
}
