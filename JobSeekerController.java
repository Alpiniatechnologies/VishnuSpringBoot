package org.jobSeekers.controller;

import org.jobSeekers.service.JobSeekersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobSeekerController {
	
	@Autowired
	JobSeekersService service;
	
	@RequestMapping("/")
	public String sample() {
		return "welcome";
	}
	
	
	@RequestMapping(value="/login",method =RequestMethod.POST)
	public String login(@RequestParam("username")String userName,@RequestParam("password") String password ) {
		System.out.println("Usernmae="+userName);
		System.out.println("password="+password);
		String status=service.validateUserDetails(userName, password);
		System.out.println("status="+status);
		if(status.equalsIgnoreCase("validUser")) {
			return "home";
		}else {
			return "welcome";
		}
		//return "home";
		
	}

	
	
	@RequestMapping(value="/dashboard",method =RequestMethod.POST)
	public String DashBoard() {
		return null;
		
	}
	
	
}
