package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageNewsPage;

public class ManageNewsTest extends BaseClass {
	HomePage homePage;
	ManageNewsPage manageNewsPage;
  @Test
  public void isNewNewsAbleToAdd() {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword("admin", "admin");
	  homePage=login.clickOnSignInButton();
	  manageNewsPage=homePage.manageNewsPageClick();
	  manageNewsPage.isNewNewsOptionClick().isNewNewsEnter();
	  boolean isNewsCreated=manageNewsPage.isNewsCreatedSuccesfully();
	  Assert.assertTrue(isNewsCreated,"News not created successfully");
  }
}
