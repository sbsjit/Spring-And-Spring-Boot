package com.shreejit.model;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunEmployee {

	public static void main(String[] args) {
		//onetoOneMapping();
		//oneToManyMapping();
		ManyToMany();
	}

	// one-to-one
	static void onetoOneMapping() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();

		sess.beginTransaction();

		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("Kathmandu");
		adr.setState("2");

		sess.save(adr);

		Employee emp = new Employee();
		emp.setName("Sujan");
		emp.setAddress(adr);

		sess.save(emp);
		sess.getTransaction().commit();
		sess.clear();
	}
	
	//ONe-To-Many
	static void oneToManyMapping() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();

		sess.beginTransaction();

		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("Kathmandu");
		adr.setState("2");

		sess.save(adr);

		Employee emp = new Employee();
		emp.setName("Sujan");
		emp.setAddress(adr);

		//For storing Two phone numbers
		Phone p1=new Phone();
		p1.setPhoneNumber("9999999999");
		p1.setType("NTC");
		p1.setEmployee(emp);
		sess.save(p1);
		
		Phone p2=new Phone();
		p2.setPhoneNumber("99888899");
		p2.setType("NCELL");
		p2.setEmployee(emp);
		sess.save(p2);
		
		//Setting the phone number in the employee tablessss
		emp.setPhoneList(Arrays.asList(p1,p2));
		
		sess.save(emp);
		sess.getTransaction().commit();
		sess.clear();
	}
	
	//Many-To-Many
	static void ManyToMany() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();

		sess.beginTransaction();

		Address adr = new Address();
		adr.setCountry("Nepal");
		adr.setCity("Kathmandu");
		adr.setState("2");

		sess.save(adr);

		Employee emp = new Employee();
		emp.setName("Sujan");
		emp.setAddress(adr);

		//For storing Two phone numbers
		Phone p1=new Phone();
		p1.setPhoneNumber("9999999999");
		p1.setType("NTC");
		p1.setEmployee(emp);
		sess.save(p1);
		
		Phone p2=new Phone();
		p2.setPhoneNumber("99888899");
		p2.setType("NCELL");
		p2.setEmployee(emp);
		sess.save(p2);
		
		Department d1=new Department();
		d1.setName("Admin");
		sess.save(d1);
		Department d2=new Department();
		d2.setName("IT");
		sess.save(d2);
		
		//Setting the phone number in the employee tablessss
		emp.setPhoneList(Arrays.asList(p1,p2));
		
		emp.setDeptList(Arrays.asList(d1,d2));
		
		
		sess.save(emp);
		sess.getTransaction().commit();
		sess.clear();
	}
}
