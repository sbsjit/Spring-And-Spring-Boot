package com.shreejit.model;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class runStudent {

	public static void main(String[] args) {

		//addStudent();
		getAllStudent();
		//update();
		//delete();
	}

	// Adding Student Details to the database
	static void addStudent() {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();

		sess.beginTransaction();

		Student s = new Student();
		s.setfName("Subeg");
		s.setlName("Aryal");
		s.setAge(22);
		s.setCollege("KIC");
		s.setPhone("9415316");

		sess.save(s);// insert sql
		sess.getTransaction().commit();
		sess.close();
	}

	// Retrieving Student Details from the table
	static void getAllStudent() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();
		
		/* To retrieve only one record */
		Student s=(Student) sess.get(Student.class, 2);
		System.out.println("First name : " + s.getfName());
		System.out.println("Last name : " + s.getlName());
		System.out.println("Age : " + s.getAge());
		
		/*
		 * To retrive entire table data
		 */
		/*
		 * Criteria crt = sess.createCriteria(Student.class); List<Student> slist =
		 * crt.list();
		 * 
		 * for (Student s : slist) { System.out.println("Fname : " + s.getfName());
		 * System.out.println("Lname :" + s.getlName()); System.out.println("College : "
		 * + s.getCollege()); System.out.println("Phone :" + s.getPhone()); }
		 */
	}

	// Update the Student Details
	static void update() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();

		sess.beginTransaction();
		
		Student s=(Student) sess.get(Student.class, 1);
		
		s.setPhone("99999");
		s.setCollege("KEC");

		sess.update(s);// update sql
		sess.getTransaction().commit();
		sess.close();
	}
	
	//Delete the student details
	static void delete() {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session sess = sf.openSession();

		sess.beginTransaction();
		
		Student s=(Student) sess.get(Student.class, 1);
		
		

		sess.delete(s);// delete sql
		sess.getTransaction().commit();
		sess.close();
	}
	
}
