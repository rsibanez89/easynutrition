package com.easynutrition.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
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

	public long getCount() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
		Root<DataEntityPatient> root = criteria.from(DataEntityPatient.class);

		criteria.select(cb.count(root));
		
		return em.createQuery(criteria).getSingleResult();
	}
	
	public long getCount(String[] filterColumns, String filterValue) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
		Root<DataEntityPatient> root = criteria.from(DataEntityPatient.class);

		criteria.select(cb.count(root));
		criteria.where(getFiltering(filterColumns, filterValue, cb, root));
		
		return em.createQuery(criteria).getSingleResult();
	}

	public List<DataEntityPatient> findAll(int start, int length,
			String orderColumnName, String orderDir, String[] filterColumns, String filterValue) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<DataEntityPatient> criteria = cb.createQuery(clazz);
		Root<DataEntityPatient> root = criteria.from(clazz);
		
		// select
		criteria.select(root);
		
		// filtering
		criteria.where(getFiltering(filterColumns, filterValue, cb, root));
		
		// order
		criteria.orderBy("asc".equals(orderDir) ? cb.asc(root.get(orderColumnName)) : cb.desc(root.get(orderColumnName)));
		
		// pagination
		TypedQuery<DataEntityPatient> q = em.createQuery(criteria);
		q.setFirstResult(start);
		q.setMaxResults(length);
		
		return q.getResultList();
	}

	private Predicate getFiltering(String[] filterColumns, String filterValue, CriteriaBuilder cb, Root<?> root) {
		List<Predicate> likes = new ArrayList<>();
		for (String filterColumn : filterColumns) {
			Expression<String> exp = root.get(filterColumn);
			likes.add(cb.like(exp, filterValue + "%"));
		}
		return cb.or(likes.toArray(new Predicate[0]));
	}

}
