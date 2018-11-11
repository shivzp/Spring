package com.spring.datajpa.SpringBootDataJpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.datajpa.SpringBootDataJpa.entity.Person;
import com.spring.datajpa.SpringBootDataJpa.jdbc.PersonDao;

//@SpringBootApplication
public class SpringBootDataJdbcApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonDao personDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("person dao {}", personDao.findAll());
		
		logger.info("Person dao id {}", personDao.findById(1002));
		
		logger.info("Person name {}", personDao.findByName("Name1"));
		
		logger.info("Delete person {}", personDao.deleteById(1004));
	
		logger.info("insert {}", personDao.insert(new Person(1005, "Name" , "Location5", new Date())));
		
		logger.info("update{} ", personDao.update(new Person(1005,"Name1","Location2", new Date())));
		
		logger.info("person dao {}", personDao.findAll());

	}
}
