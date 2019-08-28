package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
public class SimpleController {

	@Value("${msg: Unable to connect to Config Server}")
	private String msg;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/")
	public String info() {
		String info = restTemplate.getForObject("http://DiscoveryService/", String.class);
		return "Simple Controller is calling : " + info + " Using Properties from  : " + this.msg;
	}
}
