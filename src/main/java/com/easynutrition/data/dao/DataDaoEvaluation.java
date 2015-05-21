package com.easynutrition.data.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.easynutrition.data.entity.DataEntityEvaluation;

@Repository
public class DataDaoEvaluation extends DataDaoAbstract<DataEntityEvaluation> {

	public DataDaoEvaluation() {
		super(DataEntityEvaluation.class);
	}

	public List<DataEntityEvaluation> findByPatientId(Long patientId) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<DataEntityEvaluation> criteria = cb.createQuery(clazz);
		Root<DataEntityEvaluation> evaluation = criteria.from(clazz);
		criteria.select(evaluation).where(cb.equal(evaluation.get("patient"), patientId));
		TypedQuery<DataEntityEvaluation> q = em.createQuery(criteria);
		
		return q.getResultList();
	}

}
