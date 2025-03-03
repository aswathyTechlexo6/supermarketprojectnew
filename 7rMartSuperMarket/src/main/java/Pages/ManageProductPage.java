package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ManageProductPage {
	public WebDriver driver;
	public ManageProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchOptionClick;
	@FindBy(xpath="//input[@placeholder='Title']")WebElement titleField;
	@FindBy(xpath="//input[@placeholder='Product Code']")WebElement productField;
	@FindBy(xpath="//select[@id='cat_id']")WebElement categoryField;
	@FindBy(xpath="//select[@id='sb']")WebElement subCategoryField;
	@FindBy(xpath="//button[@name='Search']")WebElement searchBtn;
	
	public ManageProductPage isSearchSelected()
	{
		searchOptionClick.click();
		return this;
	}
	public ManageProductPage isTitleSelected()
	{
		titleField.sendKeys("Boost Jar-500g");
		return this;
	}
	public ManageProductPage isProductSelected()
	{
		productField.sendKeys("Veg");
		return this;
	}
	public ManageProductPage isCategorySelected()
	{
		Select select=new Select(categoryField);
		select.selectByIndex(1);
		return this;
	}
	public ManageProductPage isSubCategorySelected()
	{
		Select select=new Select(subCategoryField);
		select.selectByIndex(2);
		return this;
	}
	public ManageProductPage isSearchOptionClick()
	{
		searchBtn.click();
		return this;
	}
	
}
