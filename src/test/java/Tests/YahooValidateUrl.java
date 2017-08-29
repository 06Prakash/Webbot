package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.YahooLandingPage;
import junit.framework.Assert;
import ui_automation.hawk.TestBase;

public class YahooValidateUrl extends TestBase {
	public static Logger log = LogManager.getLogger(YahooValidateUrl.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		initializeDriver();
		navigate_to_url(prop.getProperty("url"));
	}

	@Test
	public void validateNavigation() throws IOException {
		YahooLandingPage l = new YahooLandingPage(driver);
		String actual = l.getTitle();
		System.out.println(actual);
		if (actual.equals("Yahoo")) {
			log.info("Navigated to yahoo page as expected");
		}
		
		String searchName = prop.getProperty("searchName");
		l.getSearchBox().sendKeys(searchName, Keys.ENTER);
		String searchText = l.getSearchDocument().getText();
		boolean text = searchText.contains(searchName);
		System.out.println(text);
		Assert.assertEquals("Ensured that the search returned the expected result", true, text);
		log.info("Searched the text as expected");
	}

	@AfterTest
	public void teardown() throws IOException {
		// Take screen shots
		TestBase.getScreenshot("YahooValidatePage");
		driver.close();
	}

}
