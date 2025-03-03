package testscript;

import org.testng.annotations.Test;

import constant.Constant;
import utilities.ScreenshotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	public WebDriver driver;
	public Properties properties;
	public FileInputStream fis;
	@Parameters("browser")
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browser) throws Exception {
	  /*driver=new ChromeDriver();
	  driver.get("https://groceryapp.uniqassosiates.com/admin/login");*/
		try {
			properties = new Properties();
			fis = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
	  driver.get(properties.getProperty("URL"));	
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//wait apply to all elements
  }

  @AfterMethod
  public void afterMethod(ITestResult itResult) throws IOException {
	  
	  if (itResult.getStatus() == ITestResult.FAILURE) {
	  			ScreenshotUtility sc = new ScreenshotUtility();
	  			sc.captureFailureScreenShot(driver, itResult.getName());
	  		}
	  		if (driver != null) {
	  			driver.quit();
	  		}
  }

}
