package com.easynutrition.api.rest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easynutrition.business.facade.BusinessFacadePatient;
import com.easynutrition.data.entity.DataEntityPatient;

@RestController
public class ApiRestPatient {
	@Autowired
	private BusinessFacadePatient facadePatient;
	

	@RequestMapping(value = "/rest/patients/table", method = RequestMethod.GET, produces = "application/json")
	public Map<String, Object> patientsTable(@RequestParam("draw") int draw, 
			@RequestParam("start") int start, @RequestParam("length") int length,
			@RequestParam("order[0][column]") int orderColumn, @RequestParam("order[0][dir]") String orderDir,
			@RequestParam("search[value]") String filterValue, HttpServletRequest req) {
		// columns to filter
		String[] filterColumns = req.getParameterValues("columnsFilter[]");
		
		// column to order
		String orderColumnName = req.getParameter(String.format("columns[%d][data]", orderColumn));
		
		// counts total number of records
		long countTotal = facadePatient.getCount();

		// counts number of records filtered
		long countFiltered = facadePatient.getCount(filterColumns, filterValue);
		
		// finds data
		List<DataEntityPatient> data = facadePatient.findAll(start, length, orderColumnName, orderDir, filterColumns, filterValue);
		
		// does not serialize evaluations
		for (DataEntityPatient patient : data) {
			patient.setEvaluations(null);
		}

		Map<String, Object> result = new LinkedHashMap<>();
		result.put("draw", draw);
		result.put("recordsTotal", countTotal);
		result.put("recordsFiltered", countFiltered);
		result.put("data", data);
		
		return result;
	}

	@RequestMapping(value = "/rest/patient/{id}", method = RequestMethod.DELETE)
	public void patientDelete(@PathVariable("id") Long id) {
		facadePatient.delete(id);
	}
	
}
