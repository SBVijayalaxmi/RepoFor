package com.sdet41.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet41.genericUtility.WebDriverUtility;


public class CreateOrganizationPage extends WebDriverUtility{
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name = "industry")
	private WebElement industryDropDown;
	
	@FindBy(name = "accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	public CreateOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getIndudtryDropDown() {
		return industryDropDown;
	}

	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Business Library
	public void createOrg(String orgName)
	{
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
	
	public void createOrg(String orgName, String indType)
	{
		orgNameEdt.sendKeys(orgName);
		select(industryDropDown, indType);
		saveBtn.click();
	}
	
	public void createOrg(String orgName, String indType, String accType)
	{
		orgNameEdt.sendKeys(orgName);
		select(industryDropDown, indType);
		select(typeDropDown, accType);
		saveBtn.click();
		
	}
	
}
