package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class CalendarPage {
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public CalendarPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td[@data-date='2026-02-24']")
	private WebElement specificDate;

	@FindBy(xpath="//button[contains(text(),'New Activity')]")
	private WebElement newActivityLink;
	
	public void specificDate(String Date) {
		specificDate.click();
	}
	
	public void newActivityLink() {
		newActivityLink.click();
	}
	
	
}
