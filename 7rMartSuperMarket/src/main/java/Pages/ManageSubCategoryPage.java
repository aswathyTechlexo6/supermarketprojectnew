package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageSubCategoryPage {
	public WebDriver driver;
	PageUtility utility=new PageUtility();
	FileUploadUtility fileUtility=new FileUploadUtility();
	WaitUtility waitUtility=new WaitUtility();
	public ManageSubCategoryPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/add']")WebElement newSubCategory;
	@FindBy(xpath="//select[@id='cat_id']")WebElement enterCategory;
	@FindBy(xpath="//input[@id='subcategory']")WebElement enterSubCategory;
	@FindBy(xpath="//input[@id='main_img']")WebElement chooseFile;
	@FindBy(xpath="//button[@type='submit']")WebElement saveSubCategoryBtn;
	@FindBy(xpath="//i[@class='icon fas fa-check']")WebElement subCategoryAlert;
	
	//select[@id='cat_id']
	
	public ManageSubCategoryPage newSubCategoryAddClick()
	{
		newSubCategory.click();
		return this;
	}
	
	public ManageSubCategoryPage enterCategoryDetails()
	{
		enterCategory.click();
		//waitUtility.waitForElementToSelect(driver, enterCategory);
		utility.selectByValue(enterCategory, "556");
		return this;
	}
	public ManageSubCategoryPage enterSubCategoryDetails(String subCategory)
	{
		enterSubCategory.sendKeys(subCategory);
		return this;
	}
	public ManageSubCategoryPage imageUpload()
	{
		fileUtility.sendKeyFileUpload(chooseFile, Constant.SUB_CATEGORY_IMAGE_PATH);
		return this;
	}
	public ManageSubCategoryPage newSubCategoryAddition()
	{
		saveSubCategoryBtn.click();
		return this;
	}
	public boolean isNewSubCategoryAdded()
	{
		return subCategoryAlert.isDisplayed();
	}

}
