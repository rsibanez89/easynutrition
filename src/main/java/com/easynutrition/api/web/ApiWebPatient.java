package com.easynutrition.api.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easynutrition.dao.DaoPatient;
import com.easynutrition.entity.Patient;

@Controller
public class ApiWebPatient {
	@Autowired
	private DaoPatient daoPatient;

	
	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public String displaySortedPeople(Model model) {
		model.addAttribute("newPatient", new Patient());
		model.addAttribute("patients", daoPatient.findAll("id"));
		return "patient";
	}
	
	@RequestMapping(value = "/patient", method = RequestMethod.POST)
	public String registerNewPerson(@Valid @ModelAttribute("newPatient") Patient newPatient, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			daoPatient.persist(newPatient);
			return "redirect:/patient";
		} 
		else {
			model.addAttribute("patients", daoPatient.findAll("id"));
			return "patient";
		}
	}
	
}
