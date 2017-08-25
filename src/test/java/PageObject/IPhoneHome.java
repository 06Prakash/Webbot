package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ui_automation.hawk.PageObjectBase;

public class IPhoneHome extends PageObjectBase {

	public String iphoneimg = "src/test/java/resources/iphone6.PNG";

	public IPhoneHome(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver driver;

	By header = By.tagName("h2");
	
	public String getPageHeader() {
		return driver.findElement(header).getText();
	}
}
