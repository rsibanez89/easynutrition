package com.easynutrition.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.easynutrition.entity.Person;

@Repository
@Transactional
public class PersonDao {
	@Autowired
	private EntityManager em;

	public Person findById(Long id) {
		return em.find(Person.class, id);
	}

	public Person findByEmail(String email) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
		Root<Person> person = criteria.from(Person.class);

		criteria.select(person)
				.where(builder.equal(person.get("email"), email));
		return em.createQuery(criteria).getSingleResult();
	}

	public List<Person> findAllOrderedByName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Person> criteria = cb.createQuery(Person.class);
		Root<Person> person = criteria.from(Person.class);

		criteria.select(person).orderBy(cb.asc(person.get("name")));
		return em.createQuery(criteria).getResultList();
	}

	public void register(Person person) {
		em.persist(person);
		return;
	}
}
