package org.jobSeekers.service;

import org.springframework.stereotype.Service;

@Service
public class JobSeekersService {
	
	@Autowired
	JobSeekersRepository repository;
	
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
	
	public void saveRegisterDetails(String firstName,String middleName,String lastName,String email,String mobile) {
		repository.saveRegisterDetails(firstName, middleName, lastName, email, mobile);
		
	}
	
	
	
	public JobSeekersModel search(String search) {
		JobSeekersModel js=repository.search(search);
		return js;
	}

}
