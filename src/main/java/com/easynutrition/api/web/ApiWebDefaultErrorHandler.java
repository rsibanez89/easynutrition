package com.easynutrition.api.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ApiWebDefaultErrorHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiWebDefaultErrorHandler.class);
	
	
	@ExceptionHandler(Throwable.class)
	public ModelAndView handleException(Exception ex) {
		LOGGER.warn("There was an error with message {}", ex.getMessage());
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("error");
		mav.addObject("exc", ex.getMessage());
		return mav;
	}
	
}