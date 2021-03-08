package com.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.jpa.User;
import com.jpa.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userrepository;
	
	public User addUser(User user)
	{
		return userrepository.save(user);
	}
	
	public User getUserById(int userId)
	{
		return userrepository.findById(userId).get();
	}
	
	public User updateUser(User user)
	{
		 // check if the user with the passed id exists or not
		User userDB=userrepository.findById(user.getUserId()).orElseThrow(null);
		return userrepository.save(user);
		
	}
	
	 public List<User> getAllUsers(){
		    return userrepository.findAll();
		  }
	
	public void deleteUserById(int userId) {
	    try {
	    	userrepository.deleteById(userId);  
	    }catch(DataAccessException ex){
	      throw new RuntimeException(ex.getMessage());
	    }
	  }
	
	
}
