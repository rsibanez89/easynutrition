package com.easynutrition.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easynutrition.business.facade.BusinessFacadePatient;
import com.easynutrition.data.entity.DataEntityEvaluation;

@Controller
public class ApiWebEvaluation {
	@Autowired
	private BusinessFacadePatient facadePatient;

	
	@RequestMapping(value = "/patient/{patientId}/evaluations", method = RequestMethod.GET)
	public String displayAllPatientEvaluations(@PathVariable("patientId") Long patientId, Model model) {
		model.addAttribute("patient", facadePatient.findById(patientId));
		model.addAttribute("patientId", patientId);
		model.addAttribute("evaluations", facadePatient.findEvaluations(patientId));
		return "evaluations";
	}
	
	@RequestMapping(value = "/patient/{patientId}/evaluation", method = RequestMethod.GET)
	public String patientGet(Model model) {
		// shows evaluation page
		model.addAttribute("evaluation", new DataEntityEvaluation());
		return "evaluation";
	}

}
