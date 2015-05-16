package com.easynutrition.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.easynutrition.entity.Patient;

@Repository
@Transactional
public class PatientDao extends AbstractDao<Patient> {

	public Patient findById(Long id) {
		return em.find(Patient.class, id);
	}
	
	public Patient findByEmail(String email) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> criteria = cb.createQuery(Patient.class);
		Root<Patient> patient = criteria.from(Patient.class);
		
		criteria.select(patient).where(cb.equal(patient.get("email"), email));
		TypedQuery<Patient> q = em.createQuery(criteria);
		
		return getSingleResult(q.getResultList());
	}
	
	public List<Patient> findAll() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> criteria = cb.createQuery(Patient.class);
		Root<Patient> patient = criteria.from(Patient.class);

		criteria.select(patient).orderBy(cb.asc(patient.get("id")));
		return em.createQuery(criteria).getResultList();
	}
	
	public void register(Patient patient) {
		em.persist(patient);
		return;
	}

}
