package com.spring.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.webapp.UserValidationService;

@Controller
public class LoginController {
	
	@Autowired
	UserValidationService service;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String hello() {
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String welcome(@RequestParam String name, @RequestParam String password, ModelMap model) { 
		model.put("name", name);
		model.put("password", password);
		if(service.isUserValid(name, password)) {
			return "welcome";
		} else {
			model.put("errormessage", "Invalid");
		 return "login";
		}}
}
