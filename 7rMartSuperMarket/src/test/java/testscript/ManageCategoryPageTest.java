package testscript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryPageTest extends BaseClass {
	HomePage homePage;
	ManageCategoryPage manageCategoryPage;
  @Test
  public void isUserAbleToAddNewCategories() throws IOException, AWTException {
	  String adminUserName=ExcelUtility.getStringdata(1, 0, "AdminUserTest");
	  String adminPassWord=ExcelUtility.getStringdata(1, 1, "AdminUserTest");
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword(adminUserName,adminPassWord);
	  homePage=login.clickOnSignInButton();
	  manageCategoryPage=homePage.manageCategoriesPageClick();
	  manageCategoryPage.newCategoryAddClick().categoryDetailsAdd("Fruits").
	  imageUpload().categoryDetailsSave();
  }
}
