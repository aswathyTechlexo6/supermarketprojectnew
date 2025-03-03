package testscript;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ManageProductPage;

public class ManageProductPageTest extends BaseClass {
	HomePage homePage;
	ManageProductPage manageProductsPage;
  @Test
  public void isAbleToSearchProduct() {
	  LoginPage login=new LoginPage(driver);
	  login.enterUserNameAndPassword("admin", "admin");
	  homePage=login.clickOnSignInButton();
	  manageProductsPage=homePage.manageProductsPageClick();
	  manageProductsPage.isSearchSelected().isTitleSelected().isProductSelected().isCategorySelected().isSubCategorySelected().isSearchOptionClick();
	  
  }
}
