package com.sdet41.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.sdet41.ObjectRepository.HomePage;
import com.sdet41.ObjectRepository.LoginPage;

public class BaseClass {
	
	public DatabaseUtility dLib = new DatabaseUtility();
	public JavaUtility jLib = new JavaUtility();
	public ExcelFileUtility eLib = new ExcelFileUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public WebDriverUtility wLib = new WebDriverUtility();
	public WebDriver driver;
	
	//public static WebDriver sDriver;
	
	@BeforeSuite(groups = "smoke")
	public void connectToDB() throws Throwable
	{
		dLib.connectToDB();
		System.out.println("--connect to DB--");
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups = "smoke")

	public void launchBrowser() throws Throwable
	{
		System.out.println("--launch browser--");
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else
		{
			driver = new InternetExplorerDriver();
		}
		
		//sDriver = driver;
		
		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		
	}
	
	@BeforeMethod(groups = "smoke")
	public void login() throws Throwable
	{
		
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		driver.get(URL);
		
		LoginPage lp = new LoginPage(driver);
		lp.loginPage(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups = "smoke")
	public void logout()
	{
		HomePage hp = new HomePage(driver);
		hp.signOut(driver);
	}
	
	@AfterClass(groups = "smoke")
	public void closeBrowser()
	{
		driver.quit();
	}
	
	@AfterSuite(groups = "smoke")
	public void closeDB() throws Throwable
	{
		dLib.closeDB();
		System.out.println("-- Close DB--");
	}
	

}
