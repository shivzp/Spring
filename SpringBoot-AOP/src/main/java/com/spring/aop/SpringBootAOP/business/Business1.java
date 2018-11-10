package com.spring.aop.SpringBootAOP.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.aop.SpringBootAOP.data.Dao1;

@Service
public class Business1 {

	@Autowired
	Dao1 dao1;
	
	public String method() {
		return dao1.retrieveData();
	}
}
