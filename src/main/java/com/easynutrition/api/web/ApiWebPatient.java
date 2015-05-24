package com.easynutrition.api.web;

import java.security.Principal;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easynutrition.business.facade.BusinessFacadePatient;
import com.easynutrition.data.entity.DataEntityPatient;

@Controller
public class ApiWebPatient {
	@Autowired
	private BusinessFacadePatient facadePatient;

	
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public String patientsGet(Model model) {
		// shows patients page
		return "patients";
	}	
	
	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public String patientGet(Model model) {
		// shows patient page
		model.addAttribute("patient", new DataEntityPatient());
		return "patient";
	}
	
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
	public String patientEditGet(@PathVariable("id") long id, Model model) {
		// shows patient page
		model.addAttribute("patient", facadePatient.findById(id));
		return "patient";
	}
	
	@RequestMapping(value = "/patient/{id}/profile", method = RequestMethod.GET)
	public String patientProfileGet(@PathVariable("id") long id, Model model) {
		// shows patient profile
		model.addAttribute("patient", facadePatient.findById(id));
		model.addAttribute("evaluations", facadePatient.findEvaluations(id));
		return "profile";
	}
	
	/**
	 * Post method for:
	 * 		/patient 		-> create
	 * 		/patient/{id}	-> update
	 * 
	 * @param patient
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = {"/patient", "/patient/*"}, method = RequestMethod.POST)
	public String patientPost(@Valid @ModelAttribute("patient") DataEntityPatient patient, 
			BindingResult result, Model model, Principal principal, Locale locale) {
		
		if (!result.hasErrors()) {
			// creates patient
			facadePatient.createPatient(patient, principal.getName(), locale);
			
			// goes to patients view
			return "redirect:/patients";
		} 
		else {
			model.addAttribute("patients", facadePatient.findAll());
			return "patient";
		}
	}
	
}
