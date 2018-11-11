package com.spring.datajpa.SpringBootDataJpa.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.datajpa.SpringBootDataJpa.entity.Person;

public interface PersonSpringDataRepository extends JpaRepository<Person, Integer>{

}
