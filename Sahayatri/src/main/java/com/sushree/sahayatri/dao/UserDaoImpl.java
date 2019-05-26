package com.sushree.sahayatri.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushree.sahayatri.model.User;
import com.sushree.sahayatri.repository.UserRepository;

@Service
public class UserDaoImpl implements UserDao {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
		// save() is provided by JPA in spring boot
	}

	@Override
	public List<User> findAll() {
		
		return userRepository.findAll();
	}

	@Override
	public User findOne(int userid) {
		return userRepository.findOne((long) userid);
	}

	@Override
	public void delete(User user) {
		userRepository.delete(user);
	}

}
