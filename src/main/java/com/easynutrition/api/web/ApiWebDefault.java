package com.easynutrition.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiWebDefault {

	@RequestMapping(value = "/{path:^index$|^chart$|^form$|^table$|^table-panel$|^ui$}", method = RequestMethod.GET)
	public String action(@PathVariable String path) {
		return path;
	}
	
}