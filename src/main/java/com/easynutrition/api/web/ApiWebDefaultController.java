package com.easynutrition.api.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiWebDefaultController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiWebDefaultController.class);
	
	
	@RequestMapping(value = "/{path:^home$|^login$|^error$}", method = RequestMethod.GET)
	public String action(@PathVariable String path) {
		LOGGER.info("Probando: " + path);
		return path;
	}

	@RequestMapping(value = "/error-redirect", method = RequestMethod.GET)
	public String errorPage(HttpServletRequest req, HttpServletResponse resp) {
		LOGGER.info("HTTP ERROR STATUS: " + resp.getStatus());
		return "redirect:/error";
	}
	
}