package com.dependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RunStudent {

	public static void main(String[] args) {

		// Linking the bean configuration file (applicationContext.xml)
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		/* Constructor injection method */
		Student s = (Student) context.getBean("stud");
		System.out.println(s);

		// Setter Injection
		User u = context.getBean("user", User.class);
		System.out.println(u);

	}

}
