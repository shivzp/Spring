package com.spring.aop.SpringBootAOP.data;

import org.springframework.stereotype.Repository;

@Repository
public class Dao1 {

	public String retrieveData() {
		return "Data";
	}
}
