package com.shreejit.springProject;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.shreejit.springProject.testing.Calculation;

public class TestCalculation {
	
	static Calculation cal= null;
	
	@BeforeClass
	public static void init() {
		cal=new Calculation();
	}
	
	
	/*--------------------------------------------------------*/
	@Test
	public void testSquare() {
		int result = cal.square(8);
		assertEquals(result, 64);
	}
	
	@Test
	public void testSI() {
		int check = cal.SI(5000, 5, 5);
		assertEquals(check, 1250);
	}
	
	@AfterClass
	public static void endClass() {
		cal=null;
	}
	
	
}
