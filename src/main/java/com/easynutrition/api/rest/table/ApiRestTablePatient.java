package com.easynutrition.api.rest.table;

import java.util.List;

import com.easynutrition.entity.Patient;


public class ApiRestTablePatient {
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private List<Patient> data;
	
	public ApiRestTablePatient(int draw, int recordsTotal, int recordsFiltered, List<Patient> data) {
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public int getDraw() {
		return draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public List<Patient> getData() {
		return data;
	}

}
