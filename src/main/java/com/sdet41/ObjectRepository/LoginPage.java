package com.sdet41.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//declaration
	@FindBy(name = "user_name")
	private WebElement userNameEdit;
	
	@FindBy(name = "user_password")
	private WebElement passwordEdit;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getPasswordEdit() {
		return passwordEdit;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	//Business Library
	public void loginPage(String username, String password)
	{
		userNameEdit.sendKeys(username);
		passwordEdit.sendKeys(password);
		submitBtn.click();
	}
	
}
