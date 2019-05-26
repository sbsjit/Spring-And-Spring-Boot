package com.shreejit.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {
	
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	
	@OneToOne
	@JoinColumn(name="addressId")
	private Address address;
	
	@OneToMany(mappedBy = "employee", fetch=FetchType.LAZY)
	private List<Phone> phoneList;
	
	@ManyToMany
	//Many to many case requires joining the entire table and not only just the columns
	@JoinTable(name="empDept", joinColumns = {@JoinColumn(name="empId")}, inverseJoinColumns = {@JoinColumn(name="deptId")})
	//joinColumns=employee table column name
	//InverseJoinColumns=department table column name
	private List<Department> deptList;
	
	//FetchType LAZY because it only fetches the data firing the query when necessary, so the data isnt fetched always which may full the buffer
	
	public List<Department> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}
	public List<Phone> getPhoneList() {
		return phoneList;
	}
	public void setPhoneList(List<Phone> phoneList) {
		this.phoneList = phoneList;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
	
}
