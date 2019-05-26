package com.shreejit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//Process of changing a class into Table using Hibernate ORM

@Entity
//Generating Table in the database using hibernate persistance api
@Table(name="student")

public class Student {
	
	@Id	//Primary key generation
	@GeneratedValue //Auto Increment annotation
	private int id;
	
	@Column(name="firstName")
	private String fName;
	@Column(name="lastName")
	private String lName;
	@Column(name="phoneNumber")
	private String phone;
	@Column(name="age")
	private int age;
	@Column(name="college")
	private String college;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", fName=" + fName + ", lName=" + lName + ", phone=" + phone + ", age=" + age
				+ ", college=" + college + "]";
	}
	
	
}
