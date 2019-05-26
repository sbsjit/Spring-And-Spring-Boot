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

import com.sushree.sahayatri.dao.RoleDao;
import com.sushree.sahayatri.model.Role;

@RestController
@RequestMapping("/sahayatri")
public class RoleController {
	
	@Autowired
	RoleDao roleDao;

	/* Save Role */
	@PostMapping("/role")
	public Role createRole(@Valid @RequestBody Role role) {
		return roleDao.save(role);
	}

	/* Get all roles */
	@GetMapping("/roles")
	public List<Role> getAllRole() {
		return roleDao.findAll();
	}
	

	/* Get Role by "roleId" */
	@GetMapping("/role/{id}")
	public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") int roleId) {

		Role role= roleDao.findOne(roleId);

		if (role == null) {
			/*This is basically the message you get  when you call the Rest-Api 
				when you dont find that particular id*/
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(role);

	}

	/* Update an role by roleId*/
	@PutMapping("/role/{id}")
	public ResponseEntity<Role> updateRole(@PathVariable(value = "id") int roleId,
			@Valid @RequestBody Role roleDetails) {

		Role role = roleDao.findOne(roleId);
		if (role == null) {
			return ResponseEntity.notFound().build();
		}

		role.setName(roleDetails.getName());
		
		Role updateRole= roleDao.save(role);
		return ResponseEntity.ok().body(updateRole);

	}

	/* Delete a role */
	@DeleteMapping("/role/{id}")
	public ResponseEntity<Role> deleteRole(@PathVariable(value = "id") int roleId) {

		Role role = roleDao.findOne(roleId);
		if (role == null) {
			return ResponseEntity.notFound().build();
		}
		roleDao.delete(role);

		return ResponseEntity.ok().build();

	}
	
	
	
}
