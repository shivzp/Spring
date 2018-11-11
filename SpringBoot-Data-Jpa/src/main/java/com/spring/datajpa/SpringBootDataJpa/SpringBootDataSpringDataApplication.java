package com.spring.datajpa.SpringBootDataJpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.datajpa.SpringBootDataJpa.entity.Person;
import com.spring.datajpa.SpringBootDataJpa.springdata.PersonSpringDataRepository;

@SpringBootApplication
public class SpringBootDataSpringDataApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonSpringDataRepository personJpaDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataSpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Person person = new Person(10006, "Nae", "lcoation" , new Date());
		logger.info("Person Jpa {}", personJpaDao.findById(10001));
		
		personJpaDao.deleteById(10001);
		personJpaDao.deleteById(1001);
		logger.info("Insert {}", personJpaDao.save(person));
		logger.info("update {}", personJpaDao.save(new Person(10002, "NewNaem", "NewLocation", new Date())));
		logger.info("retrieve all {}", personJpaDao.findAll());
	}
}
