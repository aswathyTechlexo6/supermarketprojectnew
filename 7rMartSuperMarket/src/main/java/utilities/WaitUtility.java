package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	WebDriver driver;
	public void waitForElementToClick(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(element));//element to be present, visible -- 5 methods
	}
	public void waitForElementToSelect(WebDriver driver,WebElement element)
	{
		WebDriverWait waitSelect=new WebDriverWait(driver,Duration.ofSeconds(20));
		waitSelect.until(ExpectedConditions.elementToBeSelected(element));//element to be present, visible -- 5 methods
	}

}
