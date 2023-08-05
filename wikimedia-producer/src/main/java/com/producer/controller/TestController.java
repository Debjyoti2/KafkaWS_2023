package com.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.producer.producers.WikimediaProducer;

@RestController
@RequestMapping("/producer")
public class TestController {
	
	@Autowired
	WikimediaProducer wikimediaProducer;
	
	@GetMapping("/test")
	public void Test() throws InterruptedException {
		wikimediaProducer.sendMessage();
	}

}
