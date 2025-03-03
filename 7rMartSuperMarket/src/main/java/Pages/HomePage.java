package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver)//Constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement adminAccount;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'])[1]")WebElement logOutBtn;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'])[2]")WebElement adminUsersPageClick;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'])[2]")WebElement manageNewsPageClick;
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'])[4]")WebElement manageProductPageClick;
	//@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'])[4]")WebElement manageCategoryPageClick;
	@FindBy(xpath="(//a[@class='small-box-footer'])[3]")WebElement manageCategoryPageClick;
	
	@FindBy(xpath="(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'])[1]")WebElement manageSubCategoryPageClick;
	public HomePage isUserAccountClick()
	{
		adminAccount.click();
		return this;
	}
	public HomePage isLogOutAccount()
	{
		logOutBtn.click();
		return this;
	}
	public AdminUsersPage adminUserPageClick()
	{
		adminUsersPageClick.click();
		return new AdminUsersPage(driver);
	}
	public ManageNewsPage manageNewsPageClick()
	{
		manageNewsPageClick.click();
		return new ManageNewsPage(driver);
	}
	public ManageProductPage manageProductsPageClick()
	{
		manageProductPageClick.click();
		return new ManageProductPage(driver);
	}
	public ManageCategoryPage manageCategoriesPageClick()
	{
		manageCategoryPageClick.click();
		return new ManageCategoryPage(driver);
	}
	public ManageSubCategoryPage manageSubCategoriesPageClick()
	{
		manageSubCategoryPageClick.click();
		return new ManageSubCategoryPage(driver);
		
	}
}
