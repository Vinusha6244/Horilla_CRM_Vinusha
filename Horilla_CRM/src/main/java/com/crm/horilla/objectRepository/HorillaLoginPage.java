package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class HorillaLoginPage {
	WebDriver driver;
	WebDriverUtility webDriverUtility=new WebDriverUtility();
	public HorillaLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement userName;
	
	@FindAll({@FindBy(id="passwordInput"),@FindBy(xpath="//input[@name='password']")})
	private WebElement passWord;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submitButton;
	

	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;

	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}
	
	public void loginToApp(String username,String password)
	{
		userName.sendKeys(username);
		passWord.sendKeys(password);
		submitButton.click();
	}

}
