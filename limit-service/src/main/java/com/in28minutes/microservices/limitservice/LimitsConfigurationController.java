package com.in28minutes.microservices.limitservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.microservices.limitservice.bean.Configuration;
import com.in28minutes.microservices.limitservice.bean.LimitConfiguration;

@RestController
public class LimitsConfigurationController {
	 

	@GetMapping("/limits/getconfighardcoded")
	public LimitConfiguration retrieveLimitsHardcoded() {
		LimitConfiguration limitConfiguration = new LimitConfiguration(1,9999);
		return limitConfiguration;
	}

	
	/*Example of service to get configuration from application.properties */
	@Autowired
	Configuration configuration=new Configuration();
	
	@GetMapping("/limits")
	public LimitConfiguration retrieveLimitsFromApplProperties() {
		LimitConfiguration limitConfiguration = new LimitConfiguration(configuration.getMinimum(),configuration.getMaximum());
		return limitConfiguration;
	}
}
