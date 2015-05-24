package com.easynutrition.data.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.easynutrition.data.entity.DataEntityUserRole;
import com.easynutrition.data.type.DataTypeUserRole;

@Repository
public class DataDaoUserRole extends DataDaoAbstract<DataEntityUserRole> {

	public DataDaoUserRole() {
		super(DataEntityUserRole.class);
	}
	
	public DataEntityUserRole findByName(DataTypeUserRole role) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<DataEntityUserRole> criteria = cb.createQuery(clazz);
		Root<DataEntityUserRole> root = criteria.from(clazz);
		criteria.select(root);
		criteria.where(cb.equal(root.get("name"), role));
		
		TypedQuery<DataEntityUserRole> q = em.createQuery(criteria);
		
		return getSingleResult(q.getResultList());
	}

}
