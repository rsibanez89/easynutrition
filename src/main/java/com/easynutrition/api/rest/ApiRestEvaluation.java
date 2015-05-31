package com.easynutrition.api.rest;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easynutrition.api.rest.view.ApiRestView.ApiRestViewEvaluationOnly;
import com.easynutrition.business.facade.BusinessFacadeTable;
import com.easynutrition.business.facade.BusinessFacadeTable.Entity;
import com.easynutrition.data.dao.DataDaoEvaluation;
import com.easynutrition.data.entity.DataEntityEvaluation;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class ApiRestEvaluation {
	@Autowired
	private DataDaoEvaluation daoEvaluation;
	@Autowired
	private BusinessFacadeTable facadeTable;

	
	@JsonView(ApiRestViewEvaluationOnly.class)
	@RequestMapping(value = "/rest/patient/{patientId}/evaluations/chart", method = RequestMethod.GET, produces = "application/json")
	public List<DataEntityEvaluation> displayAllPatientEvaluations(@PathVariable("patientId") Long patientId, Model model) {
		return daoEvaluation.findByPatientId(patientId);
	}

	@JsonView(ApiRestViewEvaluationOnly.class)
	@RequestMapping(value = "/rest/patient/{patientId}/evaluations/table", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> evaluationsTable(@RequestParam("draw") int draw, 
			@RequestParam("start") int start, @RequestParam("length") int length,
			@RequestParam("order[0][column]") int orderColumn, @RequestParam("order[0][dir]") String orderDir,
			@RequestParam("search[value]") String filterValue, HttpServletRequest req) {
		return facadeTable.getTable(Entity.EVALUATION, draw, start, length, orderColumn, orderDir, filterValue, req);
	}
	
}
