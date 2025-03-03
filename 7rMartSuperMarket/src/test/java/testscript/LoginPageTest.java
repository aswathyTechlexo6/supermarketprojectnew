package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import Pages.LoginPage;
import constant.Constant;
import utilities.ExcelUtility;

public class LoginPageTest extends BaseClass {
  @Test(dataProvider = "Credentials",groups = {"smoke"})
  public void verifyUserIsAbleToLoginValidCredentials(String userName,String passWord) {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword(userName,passWord);
	  login.clickOnSignInButton();
	  boolean isHomePageLoaded=login.isHomePageDisplayed();
	  Assert.assertTrue(isHomePageLoaded,Constant.ERROR_MESSAGE);
  }
  @Test(groups= {"smoke"})
  @Parameters({"userName","passWord"})
  public void verifyUserIsAbleToLoginInvalidUserNameValidPassword(String userName1,String passWord1) {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword(userName1, passWord1);
	  login.clickOnSignInButton();
	  boolean isHomePageLoaded=login.isHomePageDisplayed();
	  Assert.assertTrue(isHomePageLoaded, Constant.ERROR_MESSAGE);
  }
  @Test(retryAnalyzer = retry.Retry.class)
  public void verifyUserIsAbleToLoginValidUserNameInvalidPassword() throws IOException {
	  String userName=ExcelUtility.getStringdata(1, 0, "LoginPageTest");
	  String passWord=ExcelUtility.getStringdata(1, 1, "LoginPageTest");
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword(userName,passWord);
	  login.clickOnSignInButton();
	  boolean isHomePageLoaded=login.isHomePageDisplayed();
	  Assert.assertTrue(isHomePageLoaded,Constant.ERROR_MESSAGE);
  }
  @Test
  public void verifyUserIsAbleToLoginInvalidUserNameInvalidPassword() {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword("ad", "ad");
	  login.clickOnSignInButton();
	  boolean isHomePageLoaded=login.isHomePageDisplayed();
	  Assert.assertTrue(isHomePageLoaded, Constant.ERROR_MESSAGE);
  }
  @DataProvider(name="Credentials")//Annotation 
 public Object[][] testData()// Object class
 {
	  Object data[][]= {{"admin","admin"},{"admin","ad"},{"ad","ad"},{"an","as"}};
	  return data;
 }
  
}
