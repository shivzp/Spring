package com.hibernate.database.databasejpa.Jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.database.databasejpa.entity.Person;

@Repository
@Transactional
public class PersonJpaDao {

	@Autowired
	EntityManager em;
	
	public Person findById(int id) {
		return em.find(Person.class, id);
	}
	
	public Person insert(Person person) {
		return em.merge(person);
	}
	
	public Person update(Person person) {
		return em.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = em.find(Person.class, id);
	    em.remove(person);
	};
	
	public List<Person> findAll() {
		TypedQuery<Person> query = em.createNamedQuery("retrieve all", Person.class);
		return query.getResultList();
		
	}
	
	
}
