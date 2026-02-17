package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class SalesPage {
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public SalesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="leads")
	private WebElement leadsLink;
	
	@FindBy(id="campaigns")
	private WebElement campaignLink;
	
	@FindBy(id="opportunities")
	private WebElement opportunityLink;
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	private WebElement createButton;
	

	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;

	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}
	
	public WebElement getLeadsLink() {
		wlib.waitForElementToBeClikable(driver, leadsLink);
		return leadsLink;
	}

	public WebElement getCampaignLink() {
		wlib.waitForElementToBeClikable(driver, campaignLink);
		return campaignLink;
	}

	public WebElement getOpportunityLink() {
		wlib.waitForElementToBeClikable(driver, opportunityLink);
		return opportunityLink;
	}

	public void getCreateButton() {
		wlib.waitForElementPresent(driver, createButton);
		wlib.waitForElementToBeClikable(driver, createButton);
		 createButton.click();
	}

	
	
}
