package com.easynutrition.api.rest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easynutrition.data.dao.DataDaoPatient;
import com.easynutrition.data.entity.DataEntityPatient;

@RestController
public class ApiRestPatient {
	@Autowired
	private DataDaoPatient daoPatient;
	

	@RequestMapping(value = "/rest/patients", method = RequestMethod.GET, produces = "application/json")
	public List<DataEntityPatient> listPatients() {
		// finds data
		List<DataEntityPatient> patients = daoPatient.findAll("lastName");
		
		// does not serialize evaluations
		for (DataEntityPatient patient : patients) {
			patient.setEvaluations(null);
		}
		
		return patients;
	}

	@RequestMapping(value = "/rest/table/patients", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> listPatientsTable(@RequestParam("draw") int draw) {
		// finds data
		List<DataEntityPatient> data = listPatients();
		
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("draw", draw);
		result.put("recordsTotal", data.size());
		result.put("recordsFiltered", data.size());
		result.put("data", data);
		
		return result;
	}

	@RequestMapping(value = "/rest/patient/{id}", method = RequestMethod.GET, produces = "application/json")
	public DataEntityPatient lookupPatientById(@PathVariable("id") Long id) {
		// finds data
		DataEntityPatient patient = daoPatient.findById(id);
		
		// does not serialize evaluations
		patient.setEvaluations(null);
		
		return patient;
	}
	
}
