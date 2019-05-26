package com.shreejit.crudApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shreejit.crudApplication.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}