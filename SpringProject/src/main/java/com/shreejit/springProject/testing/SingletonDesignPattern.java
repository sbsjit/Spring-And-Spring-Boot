package com.shreejit.springProject.testing;


//Singleton design pattern(In this approach, ONly one object instance  is created of a class for entire project)
public class SingletonDesignPattern {
	
	private static final SingletonDesignPattern cmp= new SingletonDesignPattern();
	
	
	private SingletonDesignPattern() {
		
	}
	
	public static SingletonDesignPattern getInstance() {
		
		
		return cmp;	
	}
	
}
