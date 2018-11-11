package com.spring.datajpa.SpringBootDataJpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.datajpa.SpringBootDataJpa.entity.Person;

@Repository
@Transactional
public class PersonJpaDao {


	@Autowired
//	@PersistenceContext
	EntityManager em;
	
	public Person findById(int id) {
		return em.find(Person.class, id);
	}
	
	public void deleteById(int id) {
		Person person = em.find(Person.class, id);
		em.remove(person);
	}
	
	public Person update(Person person) {
		return em.merge(person);
	}
	
	public Person insert(Person person) {
		return em.merge(person);
	}
	
	public List<Person> findAll() {
		TypedQuery<Person> query = em.createNamedQuery("retrieve all persons", Person.class);
		return query.getResultList();
	 }
}
