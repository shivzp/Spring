package com.spring.webapp;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {

	public boolean isUserValid(String user, String password) {
		if(user.equals("name")  && password.equals("password")) {
			return true;
		}
		return false;
	}
}
