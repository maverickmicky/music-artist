package com.abhinav.service.external.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.abhinav.service.ServiceConfiguration;

public class AbstractService {

	@Autowired
	RestTemplate template;
	
	@Autowired
	ServiceConfiguration config;
}
