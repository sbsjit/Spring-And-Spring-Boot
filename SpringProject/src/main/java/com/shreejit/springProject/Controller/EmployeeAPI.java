package com.shreejit.springProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shreejit.springProject.dao.EmployeeDao;
import com.shreejit.springProject.model.Employee;

@RestController
@RequestMapping("/emp/api")
public class EmployeeAPI {
	
	@Autowired
	private EmployeeDao edao;
	
	@RequestMapping(value="/list")
	public ResponseEntity<List<Employee>> getAllEmp() {
		
		ResponseEntity<List<Employee>>  elist = 
				new ResponseEntity<List<Employee>>(edao.getAllEmployee(),HttpStatus.OK);
		
		return elist;
	}
	
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<Employee> getOneEmp(@PathVariable("id") int id) {
		
		ResponseEntity<Employee> emp = new ResponseEntity<Employee>(edao.getById(id),HttpStatus.OK);
		
		return emp;
	}
	
	
	
	@RequestMapping(value="/change")
	public String jsonToObject() {
		
		 RestTemplate  temp = new RestTemplate();
		Employee  emp =  temp.getForObject("http://localhost:8080/springProject/emp/api/9", Employee.class);
		
		System.out.println("========"+emp.getFname());
		System.out.println("========"+emp.getLname());
		
		return "OK";
	}
	
	
	

}
