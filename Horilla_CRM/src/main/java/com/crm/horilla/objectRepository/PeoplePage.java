package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class PeoplePage {
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public PeoplePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="accounts")
	private WebElement accountsLink;
	
	@FindBy(id="account-create")
	private WebElement newButton;
	

	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;

	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}
	
	public WebElement getNewButton() {
		 wlib.waitForElementToBeClikable(driver, newButton);
		return newButton;
	}

	public WebElement getAccountsLink() {
		 wlib.waitForElementToBeClikable(driver, accountsLink);
		return accountsLink;
	}

	
}
