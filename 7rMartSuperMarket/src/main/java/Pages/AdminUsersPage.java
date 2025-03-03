package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility utility=new PageUtility();
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newUser;
	@FindBy(xpath="//input[@id='username']")WebElement userName;
	@FindBy(xpath="//input[@id='password']")WebElement passWord;
	@FindBy(xpath="//select[@id='user_type']")WebElement userType;
	@FindBy(xpath="//button[@name='Create']")WebElement saveBtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement newUserAlert;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement searchOption;
	@FindBy(xpath="//input[@id='un']")WebElement userNameSearch;
	@FindBy(xpath="//select[@id='ut']")WebElement userTypeSearch;
	@FindBy(xpath="//button[@name='Search']")WebElement searchBtn;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[1]")WebElement searchTableResult;
	
	
	//button[@name='Search']
	
	
	public AdminUsersPage newUserBtnClick()//different methods to be created
	{
		newUser.click();
		return this;
		
	}
	public AdminUsersPage newUserDetails(String adminUserName,String adminPassWord)//different methods to be created
	{
		userName.sendKeys(adminUserName);
		passWord.sendKeys(adminPassWord);
		userType.click();
		/*Select select=new Select(userType);
		select.selectByIndex(1);*/
		utility.selectByIndex(userType, 1);
		return this;
	}
	public AdminUsersPage newUserCreation()
	{
		
		saveBtn.click();
		return this;	
	}
	public boolean isNewUserAlertCreated()
	{
		return newUserAlert.isDisplayed();
	}
	
	public AdminUsersPage isSearchOptionClick()
	{
		searchOption.click();
		return this;
	}
	public AdminUsersPage isSearchDetailsProvided(String search)
	{
		userNameSearch.sendKeys(search);
		userTypeSearch.click();
		utility.selectByIndex(userTypeSearch, 1);
		return this;
	}
	public void isSearchBtnClick()
	{
		searchBtn.click();
	}
	public boolean isSearchResultDisplayed()
	{
		return searchTableResult.isDisplayed();
	}

}
