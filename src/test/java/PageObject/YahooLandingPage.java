package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ui_automation.hawk.PageObjectBase;

public class YahooLandingPage extends PageObjectBase {

	public WebDriver driver;
	
		public YahooLandingPage(WebDriver driver){
			this.driver = driver;
		}
		
		By searchBox = By.id("uh-search-box");
		By submit = By.xpath(".//*[@id='yui_3_18_0_3_1504007817943_1232']");
		By searchdocument = By.id("doc");
		
				
		public WebElement getSearchDocument() {
			return driver.findElement(searchdocument);
		}

		public WebElement getSearchBox() {
			return driver.findElement(searchBox);
		}
		
		public WebElement getSubmitButton() {
			return driver.findElement(submit);
		}
		
		public String getTitle() {
			// TODO Auto-generated method stub
			return driver.getTitle();
		}
		
		public String getNavigationBar() {
			return driver.getCurrentUrl().toString();
		}
		
}
