package com.easynutrition.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class AbstractDao<T> {
	@Autowired
	protected EntityManager em;

	protected T getSingleResult(List<T> res) {
		assert res.size() <= 1 : "invalid result size " + res.size();
		
		if (res.isEmpty()) {
			return null;
		} else {
			return res.get(0);
		}
	}
	
}
