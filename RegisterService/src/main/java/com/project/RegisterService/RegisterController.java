package com.project.RegisterService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RegisterController {

	@Autowired
	private RegisterService service;
	
	@PostMapping("/api/register")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public Register create(@RequestBody Register register) {
		service.create( register.getFirstname(), register.getLastname(), register.getUsername(),
				register.getEmail(),register.getPassword(), register.getMobileNo());
		return register;
	}
	
	/*@GetMapping("api/getusers")
	public List<Register> getUsers(){
		 return service.getAll();
	}*/
	
	@PostMapping("/api/validate")
	@Consumes({MediaType.APPLICATION_JSON})
		public Boolean getUsernamePassword(@RequestBody Login login) {
			return service.getUsernamePassword(login);
		}
}
