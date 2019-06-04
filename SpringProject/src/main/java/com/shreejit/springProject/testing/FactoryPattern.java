package com.shreejit.springProject.testing;

public class FactoryPattern {
	public static OS getOsInstance(String osname) {
		
		if(osname.equals("window")) {
			return new Windows();
		}
		
		else if (osname.equals("android")) {
			return new Android();
		}
		
		else
		 return new Ios();
		
	}
}
