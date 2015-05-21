package com.easynutrition.api.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easynutrition.dao.DaoEvaluation;
import com.easynutrition.dao.DaoPatient;

@Controller
public class ApiWebEvaluation {
	@Autowired
	private DaoPatient daoPatient;
	
	@Autowired
	private DaoEvaluation daoEvaluation;
	
	@RequestMapping(value = "/patient/{patientId}", method = RequestMethod.GET)
	public String displayAllPatientEvaluations(@PathVariable("patientId") Long patientId, Model model) {
		model.addAttribute("patient", daoPatient.findById(patientId));
		model.addAttribute("evaluations", daoEvaluation.findByPatientId(patientId));
		return "evaluations";
	}

}
