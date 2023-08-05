package com.kafka.topics;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicsConfig {

	@Bean
	public NewTopic topic_project() {
		return TopicBuilder.name("topic-project")
				    .partitions(3)
				    .replicas(2)
				    .build();
	}
	
}
