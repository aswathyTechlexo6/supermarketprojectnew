package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;
	public ManageNewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement newNews;
	@FindBy(xpath="//textarea[@placeholder='Enter the news']")WebElement enterNewsText;
	@FindBy(xpath="//button[text()='Save']")WebElement enterNewsSaveBtn;
	@FindBy(xpath="//i[@class='icon fas fa-check']")WebElement successAlert;
	
	
	public ManageNewsPage isNewNewsOptionClick()
	{
		newNews.click();
		return this;
	}
	public ManageNewsPage isNewNewsEnter()
	{
		enterNewsText.sendKeys("Weather Broacast");
		enterNewsSaveBtn.click();
		return this;
	}
	public boolean isNewsCreatedSuccesfully()
	{
		return successAlert.isDisplayed();
	}
	
}
