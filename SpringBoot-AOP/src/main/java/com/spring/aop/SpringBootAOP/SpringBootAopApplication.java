package com.spring.aop.SpringBootAOP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.aop.SpringBootAOP.business.Business;
import com.spring.aop.SpringBootAOP.business.Business1;

@SpringBootApplication
public class SpringBootAopApplication implements CommandLineRunner{

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	Business business;
	
	@Autowired
	Business1 business1;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		logger.info("business {}", business.method());
		logger.info("business1 {}", business1.method());
	}
	
	
}
