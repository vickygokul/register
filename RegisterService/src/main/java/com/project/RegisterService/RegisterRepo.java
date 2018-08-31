package com.project.RegisterService;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RegisterRepo extends MongoRepository<Register, String> {

	Login findByUsername(String username);

	
	//Register findByUsernameAndPassword(String username, String password);

	

}
