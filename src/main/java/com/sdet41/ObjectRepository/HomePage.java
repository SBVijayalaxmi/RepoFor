package com.sdet41.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sdet41.genericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOut;
	
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOut() {
		return signOut;
	}

	//Business Library
	public void clickOnOrgLink()
	{
		organizationLink.click();
	}
	
	public void clickOncontactsLink()
	{
		contactsLink.click();
	}
	
	public void clickOnadministratorImg()
	{
		administratorImg.click();
	}
	
	public void signOut(WebDriver driver)
	{
		mouseHover(driver, administratorImg);
		signOut.click();
	}

}
