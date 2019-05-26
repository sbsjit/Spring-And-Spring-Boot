package com.shreejit.springProject.dao;

import com.shreejit.springProject.model.User;

public interface UserDao {
	
	//Deals with signup and login
	
	void userSignUp(User u);
	
	boolean userLogin(String un,String psw);
	
}
