package com.easynutrition.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easynutrition.dao.PatientDao;
import com.easynutrition.entity.Patient;

@Controller
public class PatientRestController {
	@Autowired
	private PatientDao patientDao;

	@RequestMapping(value = "/rest/patients", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Patient> listAllPeople() {
		return patientDao.findAll();
	}

	@RequestMapping(value = "/rest/patient/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Patient lookupPatientById(@PathVariable("id") Long id) {
		return patientDao.findById(id);
	}
}
