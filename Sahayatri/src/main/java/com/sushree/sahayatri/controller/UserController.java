package com.sushree.sahayatri.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sushree.sahayatri.dao.UserDao;
import com.sushree.sahayatri.model.User;

@RestController
@RequestMapping("/sahayatri")
public class UserController {
	@Autowired
	UserDao userDao;

	/* Save User */
	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
		return userDao.save(user);
	}

	/* Get all user */
	@GetMapping("/user")
	public List<User> getAllUser() {
		return userDao.findAll();
	}
	

	/* Get User by "userId" */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") int userId) {

		User user= userDao.findOne(userId);

		if (user == null) {
			/*This is basically the message you get  when you call the Rest-Api 
				when you dont find that particular id*/
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);

	}

	/* Update an user by userId*/
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") int userId,
			@Valid @RequestBody User userDetails) {

		User user = userDao.findOne(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}

		user.setName(userDetails.getName());
		user.setEmail(userDetails.getEmail());
		user.setPassword(userDetails.getPassword());
		user.setAddress(userDetails.getAddress());
		user.setName(userDetails.getName());
		user.setPhone(userDetails.getPhone());
		user.setVerifiedStatus(userDetails.getVerifiedStatus());
		
		User updateUser = userDao.save(user);
		return ResponseEntity.ok().body(updateUser);

	}

	/* Delete a user */
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id") int userId) {

		User user = userDao.findOne(userId);
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		userDao.delete(user);

		return ResponseEntity.ok().build();

	}
	
	
	
}
