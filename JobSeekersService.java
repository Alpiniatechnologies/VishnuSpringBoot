package org.jobSeekers.service;

import org.springframework.stereotype.Service;

@Service
public class JobSeekersService {
	
	
	public String validateUserDetails(String username,String password) {
		String status=null;
		//We need to do DB call and check user is valid or not
		if(username.equalsIgnoreCase("alpinia") && password.equalsIgnoreCase("alpinia") ) {
			status="validUser";
		}else {
			status="notValidUser";
		}
		return status;
		
	}

}
