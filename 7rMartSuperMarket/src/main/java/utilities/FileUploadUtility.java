package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {

	public void sendKeyFileUpload(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	public void robotClassFileUpload(WebElement element,String path) throws AWTException
	{
		StringSelection selection=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);//Methods to copy above path to Clipboard
		//To Paste Ctrl+V
		Robot robot=new Robot();
		robot.delay(1500);
		robot.keyPress(KeyEvent.VK_CONTROL);//VK - Virtual Key 
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);//to release
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	
	}
	
}
