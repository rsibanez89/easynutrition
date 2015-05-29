package com.easynutrition.api.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easynutrition.data.dao.DataDaoPatient;
import com.easynutrition.data.entity.DataEntityPatient;

@Controller
public class ApiWebDefaultController {
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiWebDefaultController.class);
	@Autowired
	private DataDaoPatient daoPatient;
	
	
	@RequestMapping(value = "/{path:^login$|^error$}", method = RequestMethod.GET)
	public String action(@PathVariable String path) {
		LOGGER.info("Probando: " + path);
		return path;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		Object patientId = req.getSession().getAttribute("patientId");

		if (patientId == null && req.isUserInRole("USER")) {
			String email = req.getUserPrincipal().getName();
			DataEntityPatient patient = daoPatient.findByEmail(email);
			req.getSession().setAttribute("patientId", patient.getId());
		}
		
		return "home";
	}

	@RequestMapping(value = "/error-redirect", method = RequestMethod.GET)
	public String errorPage(HttpServletRequest req, HttpServletResponse resp) {
		LOGGER.info("HTTP ERROR STATUS: " + resp.getStatus());
		return "redirect:/error";
	}
	
}