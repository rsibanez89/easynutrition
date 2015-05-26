package com.easynutrition.data.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public abstract class DataDaoAbstract<T> {
	protected Class<T> clazz; 
	@Autowired
	protected EntityManager em;

	
	public DataDaoAbstract(Class<T> clazz) {
		this.clazz = clazz;
	}

	public T findById(Long id) {
		return em.find(clazz, id);
	}
	
	public List<T> findAll(String... orders) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<T> criteria = cb.createQuery(clazz);
		Root<T> root = criteria.from(clazz);
		criteria.select(root);
		
		for (String order : orders) {
			criteria.orderBy(cb.asc(root.get(order)));
		}
		
		return em.createQuery(criteria).getResultList();
	}
	
	protected T getSingleResult(List<T> res) {
		assert res.size() <= 1 : "invalid result size " + res.size();
		
		if (res.isEmpty()) {
			return null;
		} else {
			return res.get(0);
		}
	}

	public void persist(T t) {
		em.persist(t);
	}

	public void delete(Long id) {
		T entity = em.find(clazz, id);
		em.remove(entity);
	}

	public T merge(T t) {
		return em.merge(t);
	}

	public void flush() {
		em.flush();
	}

}
