package com.easynutrition.api.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easynutrition.business.mail.BusinessMailSender;
import com.easynutrition.data.dao.DataDaoEvaluation;
import com.easynutrition.data.dao.DataDaoPatient;
import com.easynutrition.data.entity.DataEntityPatient;

@Controller
public class ApiWebPatient {
	@Autowired
	private BusinessMailSender sender;
	@Autowired
	private DataDaoPatient daoPatient;
	
	@Autowired
	private DataDaoEvaluation daoEvaluation;

	
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
	
	@RequestMapping(value = "/patient/{id}/profile", method = RequestMethod.GET)
	public String patientProfileGet(@PathVariable("id") long id, Model model) {
		// shows patient profile
		model.addAttribute("patient", daoPatient.findById(id));
		model.addAttribute("evaluations", daoEvaluation.findByPatientId(id));
		return "profile";
	}
	
	@RequestMapping(value = "/patient/{id}", method = RequestMethod.GET)
	public String patientEditGet(@PathVariable("id") long id, Model model) {
		// shows patient page
		model.addAttribute("patient", daoPatient.findById(id));
		return "patient";
	}
	
	@RequestMapping(value = {"/patient", "/patient/*"}, method = RequestMethod.POST)
	public String patientPost(@Valid @ModelAttribute("patient") DataEntityPatient patient, BindingResult result, Model model) {
		if (!result.hasErrors()) {
			// sends mail on patient create
			if (patient.getId() == null && !patient.getEmail().isEmpty()) {
				sender.sendMail(patient.getEmail());
			}
				
			// persists data
			daoPatient.merge(patient);
			
			// goes to patients view
			return "redirect:/patients";
		} 
		else {
			model.addAttribute("patients", daoPatient.findAll("id"));
			return "patient";
		}
	}
	
}
