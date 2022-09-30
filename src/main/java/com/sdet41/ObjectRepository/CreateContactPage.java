package com.sdet41.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.sdet41.genericUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	
	//declaration
	@FindBy(name = "lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']")
	private WebElement orgNamelookUpImg;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement searchButton;
	
	@FindBy(name="mobile")
	private WebElement mobileNo;
	
	@FindBy(name="imagename")
	private WebElement uploadFile;
	
	//initialization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getOrgNamelookUpImg() {
		return orgNamelookUpImg;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public WebElement getMobileNo() {
		return mobileNo;
	}

	public WebElement getUploadFile() {
		return uploadFile;
	}

	//Business Library
	public void createContact(WebDriver driver, String lastName)
	{
		lastNameEdt.sendKeys(lastName);
	}

	public void createContact(WebDriver driver, String lastName, String orgName,String leadSource)
	{
		lastNameEdt.sendKeys(lastName);
		orgNamelookUpImg.click();
		switchToWindow(driver, "Accounts");//child window
		searchEdt.sendKeys(orgName);
		searchButton.click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts"); //parent window
		selectByVisibleText(leadSourceDropDown, leadSource);
		saveButton.click();	
		
	}
	
	
	
}
