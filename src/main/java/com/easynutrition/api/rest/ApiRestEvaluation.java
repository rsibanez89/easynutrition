package com.easynutrition.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easynutrition.api.rest.view.ApiRestView.ApiRestViewEvaluationOnly;
import com.easynutrition.data.dao.DataDaoEvaluation;
import com.easynutrition.data.entity.DataEntityEvaluation;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class ApiRestEvaluation {
	
	@Autowired
	private DataDaoEvaluation daoEvaluation;

	@JsonView(ApiRestViewEvaluationOnly.class)
	@RequestMapping(value = "/rest/patient/{patientId}/evaluations", method = RequestMethod.GET, produces = "application/json")
	public List<DataEntityEvaluation> displayAllPatientEvaluations(@PathVariable("patientId") Long patientId, Model model) {
		return daoEvaluation.findByPatientId(patientId);
	}

}
