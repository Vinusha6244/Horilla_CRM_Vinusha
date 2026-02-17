package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Listeners;

import com.crm.horilla.webDriverUtility.WebDriverUtility;


public class SettingsPage {
	
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public SettingsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h3[text()='Company Information']")
	private WebElement settingsPageTitle;
	
	@FindBy(xpath="(//div[@class='flex gap-3 w-full font-medium text-sm'])[2]")
	private WebElement baseDropDown;
	
	
	
	@FindBy(xpath="(//div[@class='flex gap-3 w-full font-medium text-sm'])[9]")
	private WebElement dataManagmentDropDown;
	
	@FindBy(xpath="//a[text()='Recycle Bin']")
	private WebElement recycleBin;
	
	@FindBy(xpath="//td//div[@class='flex gap-4 items-center relative truncate']")
	private WebElement recordName;
	
	@FindBy(id="additional-action-empty_recyclebin-RecycleBinlistdi")
	private WebElement empltyRecycleBinButton;
	
	
	@FindBy(xpath="//button[text()='Confirm']")
	private WebElement confirmDeleteButton;
	
	@FindBy(xpath="//img[@alt='Delete']")
	private WebElement recordDeleteIcon;
	

	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;

	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}
	
	public WebElement getSettingsPageTitle()
	{
		return settingsPageTitle;
		
	}
	
	public WebElement getBaseDropDown()
	{
		return baseDropDown;
		
	}
	
	public WebElement getDataManagmentDropDown()
	{
		return dataManagmentDropDown;
		
	}
	
	public WebElement getRecycleBin()
	{
		return recycleBin;
	}
	
	public WebElement getConfirmDeleteButton()
	{
		return confirmDeleteButton;
	}
	
	public WebElement getRecordDeleteIcon()
	{
		return recordDeleteIcon;
		
	}
	
	public WebElement getRecordName()
	{
		return recordName;
		
	}
	public WebElement getEmpltyRecycleBinButton()
	{
		return empltyRecycleBinButton;
		
	}

}
