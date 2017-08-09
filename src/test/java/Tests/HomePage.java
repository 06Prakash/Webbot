package WebTestFramework.Webbot;

import java.io.IOException;
//
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.SearchResultPage;
import resources.base;

public class HomePage extends base {
//	public static Logger log = LogManager.getLogger(HomePage.class.getName());


	@BeforeTest
	public void initialize() throws IOException
	{
		 driver =initializeDriver();
		 navigate_to_url(prop.getProperty("url"));
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String searchName, String testIdentity) throws IOException {
		LandingPage lp = new LandingPage(driver);
//		log.info("Reached the google search page");
		lp.getSearchBox().sendKeys(searchName);
		// k.sendKeys(searchName);
		lp.getSearchBox().sendKeys(Keys.ENTER);
		// Sending the control to the search result page
		SearchResultPage srp = new SearchResultPage(driver);
		String rhsDivText = srp.getResultDiv().getText();
		boolean text = rhsDivText.contains(searchName);
		System.out.println(text);
//		Assert.assertEquals("Ensured that the search returned the expected result", true, text);
//		log.info("Searched the text as expected");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		data[0][0] = prop.getProperty("searchName");
		data[0][1] = "Test 1";

		// data[1][0] = "https://www.google.co.in";
		// data[1][1] = "Watir";
		// data[1][2] = "Test 2";

		return data;
	}
	
	@AfterTest
	public void teardown() throws IOException {
		// Take screen shots
		base.getScreenshot("HomePage");
		driver.close();
	}
}
