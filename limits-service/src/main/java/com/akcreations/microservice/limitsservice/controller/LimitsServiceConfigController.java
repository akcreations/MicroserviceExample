package com.akcreations.microservice.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akcreations.microservice.limitsservice.Configuration;
import com.akcreations.microservice.limitsservice.bean.LimitsServiceConfig;

@RestController
public class LimitsServiceConfigController {
     @Autowired
     private Configuration serviceConfig;
	
     @GetMapping("/limits")
	public LimitsServiceConfig getLimitsServiceConfig()
	{
		return new LimitsServiceConfig(serviceConfig.getMinimum(), serviceConfig.getMaximum());
	}
	
}
