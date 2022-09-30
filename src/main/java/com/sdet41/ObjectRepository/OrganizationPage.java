package com.sdet41.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgLookupImg;
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOrgLookupImg() {
		return createOrgLookupImg;
	}

	//Business library
	public void clickOncreateOrgLookupImg()
	{
		createOrgLookupImg.click();
	}
}
