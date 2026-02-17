package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class AccountPage {
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Single-Step Form')]")
	private WebElement singleStepForm;  
	
	@FindBy(id="id_account_owner")
	private WebElement accountOwner;
	
	@FindBy(xpath="//input[@name='name']")
	private WebElement accountName;
	
	@FindBy(id="id_industry")
	private WebElement industry;
	
	@FindBy(xpath="//button[contains(text(),'Save') and not(contains(text(),'Save & New')) and not(contains(text(),'Save to List'))]")
	private WebElement saveButton;
	
	@FindBy(xpath="//span[@id='soft-delete-spinner']/..")
	private WebElement softDeleteButton;
	
	@FindBy(xpath="//span[@id='confirm-delete-spinner']/..")
	private WebElement confirmDeleteButton;
	
	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;
	
	public void singleStepForm() {
		wlib.waitForElementToBeClikable(driver, singleStepForm);
		singleStepForm.click();
	}

	public void setAccountOwner(String leadOwnerName) {
		wlib.waitForElementToBeClikable(driver, accountOwner);
		wlib.selectByText(accountOwner,leadOwnerName);
	}

	public void setAccountName(String name) {
		wlib.waitForElementToBeClikable(driver, accountName);
		accountName.sendKeys(name);;
	}
	
	public void  setIndustry(String industryvalue) {
		wlib.waitForElementToBeClikable(driver, industry);
		 wlib.selectByText(industry, industryvalue);  
		}

	public void getSaveButton() {
		saveButton.click();
	}
	
	public void getSoftDeleteButton() {
		wlib.waitForElementToBeClikable(driver, softDeleteButton);
		softDeleteButton.click();
	}
	
	public void getConfirmDeleteButton() {
		wlib.waitForElementToBeClikable(driver, confirmDeleteButton);
		confirmDeleteButton.click();
	}
	
	public WebElement getConfirmationMessage() {
		wlib.waitForElementToBeClikable(driver, confirmationMessage);
		return confirmationMessage;
	}
}
