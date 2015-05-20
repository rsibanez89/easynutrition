package com.easynutrition.api.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easynutrition.api.rest.table.ApiRestTablePatient;
import com.easynutrition.dao.DaoPatient;
import com.easynutrition.entity.Patient;

@Controller
public class ApiRestPatient {
	@Autowired
	private DaoPatient daoPatient;
	

	@RequestMapping(value = "/rest/patients", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Patient> listAllPeople() {
		// finds data
		List<Patient> patients = daoPatient.findAll("lastName");
		
		// does not serialize evaluations
		for (Patient patient : patients) {
			patient.setEvaluations(null);
		}
		
		return patients;
	}

	@RequestMapping(value = "/rest/table/patients", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody ApiRestTablePatient listAllPeopleTable(@RequestParam("draw") int draw) {
		// finds data
		List<Patient> data = listAllPeople();
		
		ApiRestTablePatient result = new ApiRestTablePatient(draw, data.size(), data.size(), data);
		
		return result;
	}

	@RequestMapping(value = "/rest/patient/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Patient lookupPatientById(@PathVariable("id") Long id) {
		// finds data
		Patient patient = daoPatient.findById(id);
		
		// does not serialize evaluations
		patient.setEvaluations(null);
		
		return patient;
	}
	
}
