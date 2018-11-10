package com.spring.aop.SpringBootAOP.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.aop.SpringBootAOP.data.Dao;

@Service
public class Business {

//	private Logger logger = new LoggerFactory.getLogger(this.getClass());
	@Autowired
	Dao dao;
	
	public String method() {
		return dao.retrieveData();
	}
}
