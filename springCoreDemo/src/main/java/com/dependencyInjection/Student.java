package com.dependencyInjection;

public class Student {
	private int id;
	private String fname;
	private String lname;
	private String college;

	
	//Creation of the constructor
	public Student(int id, String fname, String lname, String college) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.college = college;
	}

	//Defining toString() method to fetch the values
	@Override
	public String toString() {
		return "Student [id=" + id + ", fname=" + fname + ", lname=" + lname + ", college=" + college + "]";
	}

}
