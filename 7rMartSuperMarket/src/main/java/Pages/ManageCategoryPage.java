package Pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	public WebDriver driver;
	FileUploadUtility fileUtility=new FileUploadUtility();
	PageUtility utility=new PageUtility();
	WaitUtility waitUtility=new WaitUtility();
	public ManageCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newCategory;
	@FindBy(xpath="//input[@id='category']")WebElement enterCategory;
	@FindBy(xpath="//input[@id='main_img']")WebElement selectImage;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement selectGroups;
	@FindBy(xpath="//button[@type='submit']")WebElement saveBtn;
	
	
	public ManageCategoryPage newCategoryAddClick()
	{
		newCategory.click();
		return this;
	}
	public ManageCategoryPage categoryDetailsAdd(String category) throws AWTException
	{
		enterCategory.sendKeys(category);
		//utility.dragElements(selectGroups);
		selectGroups.click();
		return this;
	}	
	public 	ManageCategoryPage imageUpload() throws AWTException
	{
		//selectImage.click();
		waitUtility.waitForElementToClick(driver, selectImage);
		//fileUtility.robotClassFileUpload(selectImage, Constant.IMAGE_PATH);
		fileUtility.sendKeyFileUpload(selectImage, Constant.IMAGE_PATH);
		return this;
	}
	public ManageCategoryPage categoryDetailsSave()
	{
		waitUtility.waitForElementToClick(driver, saveBtn);
		//add javascriptexecutor
		saveBtn.click();
		return this;
	}
	
}
