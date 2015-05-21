package com.easynutrition.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.easynutrition.entity.Evaluation;

@Repository
public class DaoEvaluation extends AbstractDao<Evaluation> {

	public DaoEvaluation() {
		super(Evaluation.class);
	}

	public List<Evaluation> findByPatientId(Long patientId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Evaluation> criteria = cb.createQuery(clazz);
		Root<Evaluation> evaluation = criteria.from(clazz);
		criteria.select(evaluation).where(cb.equal(evaluation.get("patient"), patientId));
		TypedQuery<Evaluation> q = em.createQuery(criteria);
		
		return q.getResultList();
	}

}
