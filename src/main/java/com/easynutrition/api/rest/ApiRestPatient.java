package com.easynutrition.api.rest;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easynutrition.api.rest.view.ApiRestView.ApiRestViewPatientOnly;
import com.easynutrition.business.facade.BusinessFacadePatient;
import com.easynutrition.business.facade.BusinessFacadeTable;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class ApiRestPatient {
	@Autowired
	private BusinessFacadePatient facadePatient;
	@Autowired
	private BusinessFacadeTable facadeTable;
	

	@JsonView(ApiRestViewPatientOnly.class)
	@RequestMapping(value = "/rest/patients/table", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> patientsTable(@RequestParam("draw") int draw, 
			@RequestParam("start") int start, @RequestParam("length") int length,
			@RequestParam("order[0][column]") int orderColumn, @RequestParam("order[0][dir]") String orderDir,
			@RequestParam("search[value]") String filterValue, HttpServletRequest req) {
		return facadeTable.patientsTable("patient", draw, start, length, orderColumn, orderDir, filterValue, req);
	}

	@RequestMapping(value = "/rest/patient/{id}", method = RequestMethod.DELETE)
	public void patientDelete(@PathVariable("id") Long id) {
		facadePatient.delete(id);
	}
	
}
