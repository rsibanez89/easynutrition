package com.easynutrition.api.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiWebDefault {
	private static final Logger logger = LoggerFactory.getLogger(ApiWebDefault.class);
	
	
	@RequestMapping(value = "/{path:^index$|^chart$|^form$|^table$|^tab-panel$|^ui$|^login$}", method = RequestMethod.GET)
	public String action(@PathVariable String path) {
		logger.info("Probando: " + path);
		return path;
	}
	
}