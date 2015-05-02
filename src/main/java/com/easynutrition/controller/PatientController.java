package com.easynutrition.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easynutrition.dao.PatientDAO;
import com.easynutrition.entity.Patient;

@Controller
public class PatientController {
	@Autowired
	private PatientDAO patientDAO;

	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public String displaySortedPeople(Model model) {
		model.addAttribute("newPatient", new Patient());
		model.addAttribute("patients", patientDAO.findAllOrderedByName());
		return "patient";
	}
	
	@RequestMapping(value = "/patient", method = RequestMethod.POST)
	public String registerNewPerson(@Valid @ModelAttribute("newPatient") Patient newPatient, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			patientDAO.register(newPatient);
			return "redirect:/patient";
		} 
		else {
			//model.addAttribute("people", patientDAO.findAllOrderedByName());
			return "redirect:/patient";
		}
	}
	
	@RequestMapping(value = "/rest/patients", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Patient> listAllPatients() {
		return patientDAO.findAllOrderedByName();
	}
	

}
