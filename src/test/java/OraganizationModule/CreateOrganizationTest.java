package OraganizationModule;



import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.sdet41.ObjectRepository.CreateOrganizationPage;
import com.sdet41.ObjectRepository.HomePage;
import com.sdet41.ObjectRepository.LoginPage;
import com.sdet41.ObjectRepository.OrganizationPage;
import com.sdet41.genericUtility.ExcelFileUtility;
import com.sdet41.genericUtility.JavaUtility;
import com.sdet41.genericUtility.PropertyFileUtility;



public class CreateOrganizationTest {

	public static void main(String[] args) throws Throwable {
	
				
		//get data CommonData from property file
		PropertyFileUtility pLib = new PropertyFileUtility();
		ExcelFileUtility eLib = new ExcelFileUtility();
		JavaUtility jLib = new JavaUtility();
		
		//get Data from property file
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		//get TestData from Excel
		
		//data for orgn
		String orgvalue = eLib.readDataFromExcelFile("Organization", 1, 2)+jLib.randomNumber();
		String Ind = eLib.readDataFromExcelFile("Organization", 4, 3);
		
		System.out.println(orgvalue);
			
		//launch browser
		WebDriver driver = null;
		if(BROWSER.contains("chrome"))
		{
		 driver= new ChromeDriver();
		}
		else if(BROWSER.contains("firefox"))
		{
			 driver= new FirefoxDriver();
			}
		else
		{
			System.out.println("invalid browser");
		}
		driver.manage().window().maximize();
		
		driver.get(URL);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		LoginPage lp= new LoginPage(driver);
		lp.loginPage(USERNAME, PASSWORD);
		
		
		//Select Org Major tab
		HomePage hp = new HomePage(driver);
		hp.clickOnOrgLink();
		
		OrganizationPage op = new OrganizationPage(driver);
		op.clickOncreateOrgLookupImg();
	
		
		//click on Create Org link
		CreateOrganizationPage cop = new CreateOrganizationPage(driver);
		cop.createOrg(orgvalue, Ind);
				

	}

}
