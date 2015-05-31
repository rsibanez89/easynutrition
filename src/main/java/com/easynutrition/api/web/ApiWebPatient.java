package com.easynutrition.api.web;

import java.security.Principal;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.easynutrition.business.facade.BusinessFacadePatient;
import com.easynutrition.data.entity.DataEntityPatient;

@Controller
public class ApiWebPatient {
	@Autowired
	private BusinessFacadePatient facadePatient;

	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/patients", method = RequestMethod.GET)
	public String patientsGet(Model model) {
		// shows patients page
		return "patients";
	}	
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public String patientGet(Model model) {
		// shows patient page
		model.addAttribute("patient", new DataEntityPatient());
		return "patient";
	}
	
	@PreAuthorize("hasRole('ADMIN') OR @businessFacadePatient.findById(#patientId).getEmail().equals(authentication.name)")
	@RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET)
	public String patientEditGet(@PathVariable("patientId") long patientId, Model model) {
		// shows patient page
		model.addAttribute("patient", facadePatient.findById(patientId));
		return "patient";
	}
	
	@PreAuthorize("hasRole('ADMIN') OR @businessFacadePatient.findById(#patientId).getEmail().equals(authentication.name)")
	@RequestMapping(value = "/patient/{patientId}/profile", method = RequestMethod.GET)
	public String patientProfileGet(@PathVariable("patientId") long patientId, Model model) {
		// shows patient profile
		model.addAttribute("patient", facadePatient.findById(patientId));
		model.addAttribute("patientId", patientId);
		return "profile";
	}
	
	/**
	 * Post method for:
	 * 		/patient 				-> create
	 * 		/patient/{patientId}	-> update
	 * 
	 * @param patient
	 * @param result
	 * @param model
	 * @return
	 */
	@PreAuthorize("hasRole('ADMIN') OR @businessFacadePatient.findById(#patient.id).getEmail().equals(authentication.name)")
	@RequestMapping(value = {"/patient", "/patient/*"}, method = RequestMethod.POST)
	public String patientPost(@Valid @ModelAttribute("patient") DataEntityPatient patient, 
			BindingResult result, Principal principal, Locale locale, 
			@RequestParam(value = "sendmail", defaultValue = "false") boolean sendmail) {
		
		if (!result.hasErrors()) {
			// persists patient
			facadePatient.merge(patient, principal.getName(), locale, sendmail);
			
			// goes to home
			return "redirect:/home";
		} else {
			return "patient";
		}
	}
	
}
