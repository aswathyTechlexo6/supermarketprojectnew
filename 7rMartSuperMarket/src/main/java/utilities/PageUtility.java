package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
WebDriver driver;
public void selectByIndex(WebElement element,int index)
{
	Select selectUser=new Select(element);
	selectUser.selectByIndex(index);
}
//Create minimum 5 methods, Action Class, SelectByValue,SelectByVisibleText, JavaScriptExecutor etc
public void dragElements(WebElement element)
{
	Actions actions=new Actions(driver);
	actions.moveToElement(element).click();//moveToElement - Method to mouse hover an element
	actions.doubleClick(element).perform();
}
public void selectByValue(WebElement element,String value)
{
	Select selectCategory=new Select(element);
	selectCategory.selectByValue(value);
}
public void selectByVisibleText(WebElement element,String value)
{
	Select selectCategory=new Select(element);
	selectCategory.selectByVisibleText(value);
}
public void javaScriptExecutor(WebElement element,String value)
{
	JavascriptExecutor executor=(JavascriptExecutor) driver;
	executor.executeScript("window.scrollBy(0,3000)");
}
}
