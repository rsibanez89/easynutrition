package com.easynutrition.business.facade;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.easynutrition.data.dao.DataDaoAbstract;
import com.easynutrition.data.dao.DataDaoEvaluation;
import com.easynutrition.data.dao.DataDaoPatient;

@Service
@Transactional
public class BusinessFacadeTable {
	private Map<String, DataDaoAbstract<?>> daos = new HashMap<>();

	
	@Autowired
	public BusinessFacadeTable(DataDaoPatient daoPatient, DataDaoEvaluation daoEvaluation) {
		daos.put("patient", daoPatient);
		daos.put("evaluation", daoEvaluation);
	}
	
	public Map<String, Object> patientsTable(String entity, int draw,
			int start, int length, int orderColumn, String orderDir,
			String filterValue, HttpServletRequest req) {
		// columns to filter
		String[] filterColumns = req.getParameterValues("columnsFilter[]");
		
		// column to order
		String orderColumnName = req.getParameter(String.format("columns[%d][data]", orderColumn));
		
		// counts total number of records
		long countTotal = getCount(entity);

		// counts number of records filtered
		long countFiltered = getCount(entity, filterColumns, filterValue);
		
		// finds data
		List<?> data = findAll(entity, start, length, orderColumnName, orderDir, filterColumns, filterValue);
		
		// creates result
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("draw", draw);
		result.put("recordsTotal", countTotal);
		result.put("recordsFiltered", countFiltered);
		result.put("data", data);
		
		return result;
	}
	
	long getCount(String entity) {
		return daos.get(entity).getCount();
	}

	long getCount(String entity, String[] filterColumns, String filterValue) {
		return daos.get(entity).getCount(filterColumns, filterValue);
	}

	List<?> findAll(String entity, int start, int length,
			String orderColumnName, String orderDir, String[] filterColumns,
			String filterValue) {
		return daos.get(entity).findAll(start, length, orderColumnName, orderDir, filterColumns, filterValue);
	}
	
}