package PracticePackage;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeSoftAssert {
	@Test
	public void create()
	{
		System.out.println("---step-1---");
		System.out.println("---step-2---");
		System.out.println("---step-3---");
		SoftAssert sa = new SoftAssert();
		sa.assertEquals("A","B");
		System.out.println("---step-4---");
		System.out.println("---step-5---");
		sa.assertAll();
	}
	

}
