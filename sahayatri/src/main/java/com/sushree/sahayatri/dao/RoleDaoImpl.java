package com.sushree.sahayatri.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sushree.sahayatri.model.Role;
import com.sushree.sahayatri.repository.RoleRepository;

@Service
public class RoleDaoImpl implements RoleDao {

	@Autowired
	RoleRepository roleRepository;
	
	public Role save(Role role) {
		return roleRepository.save(role);
		// save() is provided by JPA in spring boot
	}

	public List<Role> findAll() {
		
		return roleRepository.findAll();
	}

	public Role findOne(int roleid) {
		return roleRepository.findOne((long) roleid);
	}

	public void delete(Role role) {
		roleRepository.delete(role);
	}

}
