package com.easynutrition.api.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easynutrition.data.dao.DataDaoPatient;
import com.easynutrition.data.entity.DataEntityPatient;

@Controller
public class ApiWebPatient {
	@Autowired
	private DataDaoPatient daoPatient;

	
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public String displayAllPatients(Model model) {
		// shows patients page
		return "patients";
	}	
	
	@RequestMapping(value = "/patient/add", method = RequestMethod.GET)
	public String displaySortedPeople(Model model) {
		// shows patient page
		model.addAttribute("newPatient", new DataEntityPatient());
		return "patient";
	}
	
	@RequestMapping(value = "/patient/add", method = RequestMethod.POST)
	public String registerNewPerson(@Valid @ModelAttribute("newPatient") DataEntityPatient newPatient, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			daoPatient.persist(newPatient);
			return "redirect:/patients";
		} 
		else {
			model.addAttribute("patients", daoPatient.findAll("id"));
			return "patient";
		}
	}
	
}
