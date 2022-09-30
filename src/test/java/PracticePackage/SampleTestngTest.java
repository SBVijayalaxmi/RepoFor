package PracticePackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SampleTestngTest {

	@BeforeSuite
	public void configDB()
	{
		System.out.println("-----conncet to DB-----");
	}

	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("--- Browser launched successfully----");
	}
	
	@BeforeMethod
	public void login()
	{
		System.out.println("---Logged in successfully----");
	}
	
	@AfterMethod
	public void logOut()
	{
		System.out.println("---Logged out successfully----");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("---close the browser---");
	}
	
	@AfterSuite
	public void closeDB()
	{
		System.out.println("--- closed DB connection");
	}
	
	@Test
	public void create()
	{
		
		System.out.println("--created successfully--");
	}
	
	@Test(dependsOnMethods = "create")
	public void update()
	{
		System.out.println("--Updated successfully--");
	}
	
	@Test
	public void delete()
	{
		System.out.println("--deleted successfully--");
	}
	
	
	
	
	
}
