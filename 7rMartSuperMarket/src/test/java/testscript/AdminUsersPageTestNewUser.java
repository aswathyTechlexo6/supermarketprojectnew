package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AdminUsersPage;
import Pages.HomePage;
import Pages.LoginPage;
import constant.Constant;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersPageTestNewUser extends BaseClass {
	HomePage homePage;
	AdminUsersPage adminUsersPage;
	FakerUtility fakerUtility=new FakerUtility();
  @Test
  public void isNewUserIsAbleToCreate() throws IOException {//method name to be corrected
	  String newUserUserName=fakerUtility.getFakeFirstName();
	  String newUserPassword=fakerUtility.getPassword();
	  String adminUserName=ExcelUtility.getStringdata(1, 0, "AdminUserTest");
	  String adminPassWord=ExcelUtility.getStringdata(1, 1, "AdminUserTest");
	  /*String newUserUserName=ExcelUtility.getStringdata(2, 0, "AdminUserTest");
	  String newUserPassword=ExcelUtility.getStringdata(2, 1, "AdminUserTest");*/
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword(adminUserName,adminPassWord);
	  homePage=login.clickOnSignInButton();
	  adminUsersPage=homePage.adminUserPageClick();
	  adminUsersPage.newUserBtnClick().newUserDetails(newUserUserName,newUserPassword).newUserCreation();
	  boolean isNewUserCreated=adminUsersPage.isNewUserAlertCreated();
	  Assert.assertTrue(isNewUserCreated,Constant.NEWUSER_ERROR_MESSAGE);
  }
  @Test
  public void isAbleToSearchExistingUser() throws IOException
  {
	  String adminUserName=ExcelUtility.getStringdata(1, 0, "AdminUserTest");
	  String adminPassWord=ExcelUtility.getStringdata(1, 1, "AdminUserTest");
	  String searchString=ExcelUtility.getStringdata(3, 0, "AdminUserTest");
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword(adminUserName, adminPassWord);
	  homePage=login.clickOnSignInButton();
	  adminUsersPage=homePage.adminUserPageClick();
	  adminUsersPage.isSearchOptionClick().isSearchDetailsProvided(searchString).isSearchBtnClick();
	  boolean isUserExists=adminUsersPage.isSearchResultDisplayed();
	  Assert.assertTrue(isUserExists, Constant.USER_SEARCH_ERROR_MESSAGE);
  }
}
