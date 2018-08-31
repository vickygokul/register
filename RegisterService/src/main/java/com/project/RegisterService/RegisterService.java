package com.project.RegisterService;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@Service
public class RegisterService {

	@Autowired
	private RegisterRepo repo;
	
	private static AtomicInteger counter = new AtomicInteger();
	
	private static int nextValue() {
		return counter.getAndIncrement();
	}
	
	public Register create(String firstname, String lastname, String username, String email, 
			String password, long mobileNo) {
	return repo.save(new Register( firstname, lastname, username, email, password, mobileNo));
	}
	
	//public Register getUsernamePassword(String username, String password) {
		//Register register = repo.findByUsernameAndPassword(username, password);
		//System.out.println(register);
		//return register;
	//}
	
	public Boolean getUsernamePassword(Login login) {
		Login login2 = repo.findByUsername(login.getUsername());
		
		if(login.getPassword().equals(login2.getPassword())) {
			return true;
		}
		
		else {
		return false;
		}
	}
}
