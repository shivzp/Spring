package com.hibernate.database.databasejpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hibernate.database.databasejpa.Jdbc.PersonJDBCDao;
import com.hibernate.database.databasejpa.Jpa.PersonJpaDao;
import com.hibernate.database.databasejpa.entity.Person;

@SpringBootApplication
public class DatabaseJpaApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	PersonJDBCDao dao;
	
	@Autowired
	PersonJpaDao dao1;
	

	public static void main(String[] args) {
		SpringApplication.run(DatabaseJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Person person = new Person (1, "newName", "newLocation", new Date());
		Person person1= new Person (1002, "newName", "newLocation", new Date());

		
		logger.info("retreive one {}", dao1.findById(1001));
		dao1.deleteById(1001);
		logger.info("insert by id {}", dao1.insert(person));
		logger.info("update person {}", dao1.update(person1));
		logger.info("retrieve all {}", dao1.findAll());
	}
}
