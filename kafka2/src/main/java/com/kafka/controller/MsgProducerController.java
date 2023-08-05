package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.User;
import com.kafka.producers.JsonProducers;
import com.kafka.producers.Producers;

@RestController
@RequestMapping("/api/v1/kafka")
public class MsgProducerController {

	@Autowired
	private Producers producers;
	
	@Autowired
	private JsonProducers jsonProducers;
	
	@GetMapping("/getmessage")
	public ResponseEntity<String> publishMsg( @RequestParam("message") String message){
	
		producers.produceMessage(message);
		return new ResponseEntity<String>("Msg Sent",HttpStatus.OK);
	}
	
	@PostMapping("/sendjsonmessage")
	public ResponseEntity<String> publishMsg(@RequestBody User user){
	
		jsonProducers.publishMessage(user);
		return new ResponseEntity<String>("JSON Msg Sent",HttpStatus.OK);
	}
	
}
