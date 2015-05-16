package com.easynutrition.controller.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easynutrition.dao.PatientDao;
import com.easynutrition.entity.Patient;

@Controller
public class PatientController {
	@Autowired
	private PatientDao patientDao;

	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public String displaySortedPeople(Model model) {
		model.addAttribute("newPatient", new Patient());
		model.addAttribute("patients", patientDao.findAll());
		return "patient";
	}
	
	@RequestMapping(value = "/patient", method = RequestMethod.POST)
	public String registerNewPerson(@Valid @ModelAttribute("newPatient") Patient newPatient, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			patientDao.register(newPatient);
			return "redirect:/patient";
		} 
		else {
			model.addAttribute("patients", patientDao.findAll());
			return "patient";
		}
	}
	
}
