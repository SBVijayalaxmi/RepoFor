package com.sdet41.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	
	@FindBy(xpath= "//span[@class='dvHeaderText']")
	private WebElement OrgInfoPage;

	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getOrgInfoPage() {
		return OrgInfoPage;
	}
	
	//Business Library
	public void orgInfoPage()
	{
		OrgInfoPage.getText();
		
	}
	
}
