package PracticePackage;

import static org.testng.Assert.assertEquals;

import org.testng.Assert.*;
import org.testng.annotations.Test;

public class PracticeHardAssert {
	
	@Test
	public void create()
	{
		System.out.println("---step-1---");
		System.out.println("---step-2---");
		System.out.println("---step-3---");
		assertEquals("A","B");
		System.out.println("---step-4---");
		System.out.println("---step-5---");
		
	}
	@Test
	public void update()
	{
		System.out.println("---step-6---");
		System.out.println("---step-7---");
		assertEquals("X","Y");
		System.out.println("---step-4---");
		System.out.println("---step-5---");
	}
}
