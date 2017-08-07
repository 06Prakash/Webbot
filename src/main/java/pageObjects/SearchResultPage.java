package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.PageObjectBase;

public class SearchResultPage extends PageObjectBase {

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver driver;
	
	By resultDiv = By.id("ires");
	
	public WebElement getResultDiv() {
		return driver.findElement(resultDiv);
	}
}
