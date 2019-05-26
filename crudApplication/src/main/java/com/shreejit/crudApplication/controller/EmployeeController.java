package com.shreejit.crudApplication.controller;

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

import com.shreejit.crudApplication.dao.EmployeeDao;
import com.shreejit.crudApplication.model.Employee;

/*RestAPI - This is where all the url's entered in the browser or 
 through the postman application will be handled*/

@RestController

@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	/* Save Employee */
	@PostMapping("/employees")
	/*Its a alternate of:
	 * @RequestMapping("/company", method =RequestMethod.POST)
	 */
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		/*
		 * In a Spring REST context, the implementation of the addUser() method is
		 * fairly standard.
		 * 
		 * Of course, the most relevant part is the use of the @Valid annotation.
		 * 
		 * When Spring Boot finds an argument annotated with @Valid, it automatically
		 * bootstraps the default JSR 380 implementation — Hibernate Validator — and
		 * validates the argument.
		 * 
		 * When the target argument fails to pass the validation, Spring Boot throws a
		 * MethodArgumentNotValidException exception.
		 */
		return employeeDao.save(emp);
	}

	/* Get all employees */
	@GetMapping("/employees")
	/*Its a alternate of:
	 * @RequestMapping("/company", method =RequestMethod.GET)
	 */
	public List<Employee> getAllEmployees() {
		return employeeDao.findAll();
	}
	

	/* Get employee by "empId" */
	@GetMapping("/employees/{id}")
	/*{id} --- So @PathVariable value must be defined of a parameter*/
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long empid) {

		Employee emp = employeeDao.findOne(empid);

		if (emp == null) {
			/*This is basically the message you get  when you call the Rest-Api 
				when you dont find that particular id*/
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);

	}

	/* Update an employee by empid */
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long empid,
			@Valid @RequestBody Employee empDetails) {

		Employee emp = employeeDao.findOne(empid);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}

		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());

		Employee updateEmployee = employeeDao.save(emp);
		return ResponseEntity.ok().body(updateEmployee);

	}

	/* Delete an employee */
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value = "id") Long empid) {

		Employee emp = employeeDao.findOne(empid);
		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		employeeDao.delete(emp);

		return ResponseEntity.ok().build();

	}

}