package com.sushree.sahayatri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sushree.sahayatri.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
