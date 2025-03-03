package testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class HomePageTest extends BaseClass {
	HomePage homePage;
  @Test
  public void verifyUserCanAbleToLogOut() {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword("admin", "admin");
	  homePage=login.clickOnSignInButton();
	  homePage.isUserAccountClick().isLogOutAccount();
	  System.out.println("Succefully Logged Out!");
	  String expected="Login | 7rmart supermarket";
	  String actual=driver.getTitle();
	  Assert.assertEquals(expected, actual,"Log Out Failed!");
  }
}
