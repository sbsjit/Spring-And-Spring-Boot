package com.sushree.sahayatri.dao;

import java.util.List;

import com.sushree.sahayatri.model.User;

public interface UserDao {
	
	public User save(User user);
	
	public List<User> findAll();
	
	
	public User findOne(int userid);
	
	public void delete(User user);
	
	
}
