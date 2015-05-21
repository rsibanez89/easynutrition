package com.easynutrition.data.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.easynutrition.data.entity.DataEntityPatient;

@Repository
public class DataDaoPatient extends DataDaoAbstract<DataEntityPatient> {

	public DataDaoPatient() {
		super(DataEntityPatient.class);
	}

	public DataEntityPatient findByEmail(String email) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<DataEntityPatient> criteria = cb.createQuery(clazz);
		Root<DataEntityPatient> patient = criteria.from(clazz);
		criteria.select(patient).where(cb.equal(patient.get("email"), email));
		TypedQuery<DataEntityPatient> q = em.createQuery(criteria);
		
		return getSingleResult(q.getResultList());
	}
	
}
