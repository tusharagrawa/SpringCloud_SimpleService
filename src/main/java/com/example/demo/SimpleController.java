package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SimpleController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/")
	public String info() {
		String msg = restTemplate.getForObject("http://DiscoveryService/", String.class);
		return "Simple Controller is calling : " + msg;
	}
}
