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
	private Map<Entity, DataDaoAbstract<?>> daos = new HashMap<>();

	public static enum Entity {
		PATIENT, EVALUATION
	}
	
	
	@Autowired
	public BusinessFacadeTable(DataDaoPatient daoPatient, DataDaoEvaluation daoEvaluation) {
		daos.put(Entity.PATIENT, daoPatient);
		daos.put(Entity.EVALUATION, daoEvaluation);
	}
	
	public Map<String, Object> getTable(Entity entity, int draw,
			int start, int length, int orderColumn, String orderDir,
			String filterValue, HttpServletRequest req) {
		// columns to filter
		String[] filterColumns = req.getParameterValues("columnsFilter[]");
		
		// column to order
		String orderColumnName = req.getParameter(String.format("columns[%d][data]", orderColumn));

		// get dao
		DataDaoAbstract<?> dao = daos.get(entity);
	
		// counts total number of records
		long countTotal = dao.getCount();

		// counts number of records filtered
		long countFiltered = dao.getCount(filterColumns, filterValue);
		
		// finds data
		List<?> data = dao.findAll(start, length, orderColumnName, orderDir, filterColumns, filterValue);
		
		// creates result
		Map<String, Object> result = new LinkedHashMap<>();
		result.put("draw", draw);
		result.put("recordsTotal", countTotal);
		result.put("recordsFiltered", countFiltered);
		result.put("data", data);
		
		return result;
	}
	
}