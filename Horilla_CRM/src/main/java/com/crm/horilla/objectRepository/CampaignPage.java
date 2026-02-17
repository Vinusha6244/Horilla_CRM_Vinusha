package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class CampaignPage {
	
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public CampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[text()='Campaigns']")
	private WebElement campaignPageTitle;
	
	@FindBy(xpath="//a[contains(text(),'Single-Step Form')]")
	private WebElement singleStepForm;
	
	@FindBy(id="//span[@id='select2-id_campaign_owner-container']")
	private WebElement campaignOwner;
	
	@FindBy(id="//Select[@id='id_campaign_owner']/following-sibling::span//span[@id='select2-id_campaign_owner-container']")
	private WebElement campaignOwner1;
	
	@FindBy(id="id_campaign_name")
	private WebElement campaignName;
	
	@FindBy(id="id_status")
	private WebElement campaignStatus;
	
	@FindBy(id="id_number_sent")
	private WebElement numberSentInCampaign;
	
	@FindBy(id="id_start_date")
	private WebElement campaignStartDate;
	
	@FindBy(id="//button[contains(text(),'Save') and not(contains(text(),'Save & New')) and not(contains(text(),'Save to List'))]")
	private WebElement saveButton;
	
	
	public WebElement getCampaignPageTitle() {
		return campaignPageTitle;
	}
	
	public void singleStepForm() {
		singleStepForm.click();
	}

	public void setCampaignOwner(String campaignOwnerName) {
		campaignOwner1.click();
		wlib.selectByText(campaignOwner1, campaignOwnerName);
		
	}

	public void setCampaignName(String campaignOwnerName) {
		campaignName.sendKeys(campaignOwnerName);
	}

	public void setCampaignStatus(String status) {
		wlib.selectByText(campaignStatus, status);
	}

	public void setNumberSentInCampaign(String numberOfCampaign) {
		numberSentInCampaign.sendKeys(numberOfCampaign);

	}

	public void setCampaignStartDate() {
	
	}

	public void setSaveButton() {
		saveButton.click();
		
	}
	
	

}
