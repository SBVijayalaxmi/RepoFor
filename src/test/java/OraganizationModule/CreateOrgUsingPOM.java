package OraganizationModule;


import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sdet41.ObjectRepository.CreateOrganizationPage;
import com.sdet41.ObjectRepository.HomePage;
import com.sdet41.ObjectRepository.LoginPage;
import com.sdet41.ObjectRepository.OrganizationPage;
import com.sdet41.genericUtility.BaseClass;
import com.sdet41.genericUtility.ExcelFileUtility;
import com.sdet41.genericUtility.JavaUtility;
import com.sdet41.genericUtility.PropertyFileUtility;
import com.sdet41.genericUtility.WebDriverUtility;
@Listeners(com.sdet41.genericUtility.ListenerImplementaionClass.class)

public class CreateOrgUsingPOM  extends BaseClass {

	@Test
	public void createOrg() throws Throwable
	 {
				
		//data for org
		String OrgName = eLib.readDataFromExcelFile("Organization", 1, 2)+jLib.randomNumber();
		String Ind = eLib.readDataFromExcelFile("Organization", 4, 3);
		System.out.println(OrgName);
		fail();
		
		//data for contact
		String lastname = eLib.readDataFromExcelFile("Contacts", 1, 2)+jLib.randomNumber();
		//String LeadSource = eLib.readDataFromExcelFile("Contacts", 1, 3);
		
		//click on Org Link
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		
		//click on Create Org link
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOncreateOrgLookupImg();
			
		//Enter Org name
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg(OrgName, Ind);
		
		
		driver.navigate().refresh();
	}
	
	/*
	@Test
	public void sample1()
	{
		System.out.println("----sample-1----");
	}
	
	@Test
	public void sample2()
	{
		System.out.println("----sample-2----");
	}
	
	@Test
	public void sample3()
	{
		System.out.println("----sample-3----");
	}*/

}
