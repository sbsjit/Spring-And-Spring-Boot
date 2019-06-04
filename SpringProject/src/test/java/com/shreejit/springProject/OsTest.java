package com.shreejit.springProject;

import com.shreejit.springProject.testing.FactoryPattern;
import com.shreejit.springProject.testing.OS;

public class OsTest {

	OS window=FactoryPattern.getOsInstance("window");
	
	OS android=FactoryPattern.getOsInstance("android");
	
	
	
	
}
