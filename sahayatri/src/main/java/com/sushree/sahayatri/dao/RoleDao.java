package com.sushree.sahayatri.dao;

import java.util.List;

import com.sushree.sahayatri.model.Role;

public interface RoleDao {
	
	public Role save(Role role);

	public List<Role> findAll();

	public Role findOne(int roleid);

	public void delete(Role role);

	
}
