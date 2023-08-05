package com.kafka;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Appconfig {
	
	@Value("${applicationId}")
	private String applicationId;
	
	@Value("${bootstrapServers}")
	private String bootstrapServers;
	
	@Value("${topicName}")
	private String topicName;
	 	
	@Value("${numEvents}")
	private int numEvents;

	public String getApplicationId() {
		return applicationId;
	}

	public String getBootstrapServers() {
		return bootstrapServers;
	}

	public String getTopicName() {
		return topicName;
	}

	public int getNumEvents() {
		return numEvents;
	}
	
	
	
	

}
