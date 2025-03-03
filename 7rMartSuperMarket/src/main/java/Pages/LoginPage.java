package Pages;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class LoginPage {
		public WebDriver driver;
		public LoginPage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="//input[@name='username']")WebElement userName;
		@FindBy(xpath="//input[@name='password']")WebElement passWord;
		@FindBy(xpath="//button[text()='Sign In']")WebElement signInBtn;
		@FindBy(xpath="//a[text()='Home']")WebElement homePageText;
		////a[text()='Home']
		
		public LoginPage enterUserNameAndPassword(String UserName,String Password)
		{
			userName.sendKeys(UserName);
			passWord.sendKeys(Password);
			return this;
		}
		public HomePage clickOnSignInButton()
		{
			signInBtn.click();
			return new HomePage(driver);
		}
		public boolean isHomePageDisplayed()
		{
			return homePageText.isDisplayed();
		}

	}



