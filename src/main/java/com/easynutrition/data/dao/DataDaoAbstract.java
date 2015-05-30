package com.easynutrition.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
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

	/*
	 * ============================ CRUD METHODS ============================
	 */
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

	/*
	 * ============================ TABLE METHODS ============================
	 */
	public long getCount() {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
		Root<T> root = criteria.from(clazz);

		criteria.select(cb.count(root));

		return em.createQuery(criteria).getSingleResult();
	}

	public long getCount(String[] filterColumns, String filterValue) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
		Root<T> root = criteria.from(clazz);

		criteria.select(cb.count(root));
		criteria.where(getFiltering(filterColumns, filterValue, cb, root));

		return em.createQuery(criteria).getSingleResult();
	}

	public List<T> findAll(int start, int length, String orderColumnName,
			String orderDir, String[] filterColumns, String filterValue) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<T> criteria = cb.createQuery(clazz);
		Root<T> root = criteria.from(clazz);

		// select
		criteria.select(root);

		// filtering
		criteria.where(getFiltering(filterColumns, filterValue, cb, root));

		// order
		criteria.orderBy("asc".equals(orderDir) ? cb.asc(root
				.get(orderColumnName)) : cb.desc(root.get(orderColumnName)));

		// pagination
		TypedQuery<T> q = em.createQuery(criteria);
		q.setFirstResult(start);
		q.setMaxResults(length);

		return q.getResultList();
	}

	private Predicate getFiltering(String[] filterColumns, String filterValue,
			CriteriaBuilder cb, Root<?> root) {
		List<Predicate> likes = new ArrayList<>();
		for (String filterColumn : filterColumns) {
			Expression<String> exp = root.get(filterColumn);
			likes.add(cb.like(exp, filterValue + "%"));
		}
		return cb.or(likes.toArray(new Predicate[0]));
	}

}
