package com.crm.horilla.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.horilla.webDriverUtility.WebDriverUtility;

public class RolePage  {
	
	WebDriver driver;
	WebDriverUtility wlib=new WebDriverUtility();
	public RolePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Role']")
	private WebElement roleLink;
	
	@FindBy(xpath="//button[contains(text(),'Add Role')]")
	private WebElement addRoleButton;

	@FindBy(id="id_role_name")
	private WebElement roleName;
	
	@FindBy(id="id_parent_role")
	private WebElement patnerRole;
	
	@FindBy(xpath="//button[contains(text(),'Save') and not(contains(text(),'Save & New')) and not(contains(text(),'Save to List'))]")
	private WebElement saveButton;
	
	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement roleMessage;
	
	@FindBy(xpath="//h2[@id='swal2-title']")
	private WebElement confirmationMessage;
	
	
	public WebElement getRoleLink()
	{
		return roleLink;
	}
	
	public WebElement getAddRoleButton()
	{
		return addRoleButton;
	}
	
	public void getRoleName(String name)
	{
		roleName.sendKeys(name);;
	}
	
	public void setPatnerRole(String leadOwnerName) {
		wlib.selectByText(patnerRole,leadOwnerName);
	}
	
	public WebElement getRoleMessage()
	{
		return roleName;
	}
	public WebElement getConfirmationMessage() {
		return confirmationMessage;
	}
	
	public void getSaveButton() {
		saveButton.click();
	}
}
