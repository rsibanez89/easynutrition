package com.easynutrition.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.easynutrition.entity.Patient;

@Repository
@Transactional
public class PatientDao {
	@Autowired
	private EntityManager em;

	public Patient findById(Long id) {
		return em.find(Patient.class, id);
	}
	
	public List<Patient> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> criteria = cb.createQuery(Patient.class);
		Root<Patient> patient = criteria.from(Patient.class);

		criteria.select(patient).orderBy(cb.asc(patient.get("name")));
		return em.createQuery(criteria).getResultList();
	}
	
	public void register(Patient patient) {
		em.persist(patient);
		return;
	}

}
