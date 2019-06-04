package com.shreejit.springProject;

import com.shreejit.springProject.testing.SingletonDesignPattern;

public class TestClass {

	
	public static void main(String[] args) {
		SingletonDesignPattern c1=SingletonDesignPattern.getInstance();
		SingletonDesignPattern c2=SingletonDesignPattern.getInstance();	
		
		System.out.println(c1);
		System.out.println(c2);
		
	}

	
	
	
}
