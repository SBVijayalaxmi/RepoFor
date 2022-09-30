package ContactsModule;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.math3.analysis.function.Log;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.sdet41.ObjectRepository.ContactPage;
import com.sdet41.ObjectRepository.CreateContactPage;
import com.sdet41.ObjectRepository.CreateOrganizationPage;
import com.sdet41.ObjectRepository.HomePage;
import com.sdet41.ObjectRepository.LoginPage;
import com.sdet41.ObjectRepository.OrganizationInfoPage;
import com.sdet41.ObjectRepository.OrganizationPage;
import com.sdet41.genericUtility.BaseClass;
import com.sdet41.genericUtility.ExcelFileUtility;
import com.sdet41.genericUtility.JavaUtility;
import com.sdet41.genericUtility.PropertyFileUtility;
import com.sdet41.genericUtility.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactTest extends BaseClass {

	@Test
	
	public void createContacts() throws Throwable
	
	{
		
		//data for org
		String OrgName = eLib.readDataFromExcelFile("Organization", 1, 2)+jLib.randomNumber();
		String Ind = eLib.readDataFromExcelFile("Organization", 4, 3);
		System.out.println(OrgName);
		
		//data for contact
		String lastname = eLib.readDataFromExcelFile("Contacts", 1, 2)+jLib.randomNumber();
		String LeadSource = eLib.readDataFromExcelFile("Contacts", 1, 3);
		
		HomePage hp =new HomePage(driver);
		hp.clickOnOrgLink();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOncreateOrgLookupImg();
		
				
		//Enter Org name
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg(OrgName, Ind);
		Thread.sleep(2000);
		
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		oip.orgInfoPage();
				
		driver.navigate().refresh();
		
		//Create Contact
		hp.clickOncontactsLink();
	
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContacts();
		
		CreateContactPage ccp = new CreateContactPage(driver);
		ccp.createContact(driver, lastname, OrgName, LeadSource);
			
		driver.navigate().refresh();
		
	}

}
