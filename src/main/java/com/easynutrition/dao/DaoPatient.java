package com.easynutrition.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.easynutrition.entity.Patient;

@Repository
public class DaoPatient extends AbstractDao<Patient> {

	public DaoPatient() {
		super(Patient.class);
	}

	public Patient findByEmail(String email) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Patient> criteria = cb.createQuery(clazz);
		Root<Patient> patient = criteria.from(clazz);
		criteria.select(patient).where(cb.equal(patient.get("email"), email));
		TypedQuery<Patient> q = em.createQuery(criteria);
		
		return getSingleResult(q.getResultList());
	}
	
}
