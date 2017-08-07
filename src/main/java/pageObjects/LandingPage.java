package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.PageObjectBase;

public class LandingPage extends PageObjectBase {

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver driver;

	By searchBox = By.id("lst-ib");
	By submit = By.name("btnK");
	By searchButton = By.xpath(".//*[@value='Google Search']");
	
	public WebElement getSearchBox() {
		return driver.findElement(searchBox);
	}
	
	public WebElement getSubmitButton() {
		return driver.findElement(submit);
	}
	
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		return driver.getTitle();
	}
	
	public String getNavigationBar() {
		return driver.getCurrentUrl().toString();
	}
}
