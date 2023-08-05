package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Runner {
	
	private static Logger logger = LoggerFactory.getLogger(Runner.class);
	
	@Autowired
	private Appconfig appconfig;
	
	
    @GetMapping("/action")
	public void action() {

		logger.info(" Creating Kafka Producer");
		
		logger.info(" Appconfig.applicationId   "  + appconfig.getApplicationId());
		
		Properties prop = new Properties();
		prop.put(ProducerConfig.CLIENT_ID_CONFIG,appconfig.getApplicationId());
		prop.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,appconfig.getBootstrapServers());
		prop.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,IntegerSerializer.class.getName());
		prop.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
		
		
		KafkaProducer<Integer,String> producer = new KafkaProducer<>(prop);
		
		logger.info(" Start Sending Message .... ");
		logger.info(" applicationId ....   " + appconfig.getApplicationId() );
		logger.info(" bootstrapServers ....   " + appconfig.getBootstrapServers() );
		logger.info(" topicName ....   " + appconfig.getTopicName());
		logger.info(" numEvents ....   " + appconfig.getNumEvents() );
		
		for(int i=0;i<appconfig.getNumEvents();i++) {
			producer.send(new ProducerRecord<Integer, String>(appconfig.getTopicName(),i, "Simple Message 2 -- " + i));
		}
		producer.close();

		logger.info("Finished Sending Message. Closing Producer ....");
		

	}

}
