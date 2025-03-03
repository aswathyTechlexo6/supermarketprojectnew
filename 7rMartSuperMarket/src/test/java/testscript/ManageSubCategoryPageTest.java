package testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageSubCategoryPage;
import constant.Constant;
import utilities.ExcelUtility;

public class ManageSubCategoryPageTest extends BaseClass {
	HomePage homePage;
	ManageSubCategoryPage manageSubCategoryPage;
  @Test
  public void isUserAbleToAddNewSubCategories() throws IOException {
	  String adminUserName=ExcelUtility.getStringdata(1, 0, "AdminUserTest");
	  String adminUserPassword=ExcelUtility.getStringdata(1,1, "AdminUserTest");
	  String subCategory=ExcelUtility.getStringdata(0, 0, "SubCategoryTest");
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword(adminUserName, adminUserPassword);
	  homePage=login.clickOnSignInButton();  
	  manageSubCategoryPage=homePage.manageSubCategoriesPageClick();
	  manageSubCategoryPage.newSubCategoryAddClick().enterCategoryDetails().enterSubCategoryDetails(subCategory).imageUpload().newSubCategoryAddition();
	  boolean isSubCategoryAdded=manageSubCategoryPage.isNewSubCategoryAdded();
	  Assert.assertTrue(isSubCategoryAdded, Constant.SUB_CATEGORY_ADD_ERROR_MESSAGE);
	  		  
  }
}
