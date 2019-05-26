package com.shreejit.crudApplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shreejit.crudApplication.model.Employee;
import com.shreejit.crudApplication.repository.EmployeeRepository;

//When defined DAO in spring boot, the class must be annotated with @Service 
@Service
public class EmployeeDao {

	@Autowired
	EmployeeRepository employeeRepository;

	/* to save an employee */

	public Employee save(Employee emp) {
		return employeeRepository.save(emp);
		// save() is provided by JPA in spring boot
	}

	/* search all employees */

	public List<Employee> findAll() {
		return employeeRepository.findAll();
		// save(), findAll(); findOne(empid); delete(emp) is provided by JPA in spring boot
	}

	/* get an employee by id */
	public Employee findOne(Long empid) {
		return employeeRepository.findOne(empid);
	}

	/* delete an employee */

	public void delete(Employee emp) {
		employeeRepository.delete(emp);
	}

}
