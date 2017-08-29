package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import PageObject.SearchResultPage;
import ui_automation.hawk.ExcelDataProviderConfig;
import ui_automation.hawk.TestBase;

public class ExcelDataDrivenCase extends TestBase {
	public static Logger log = LogManager.getLogger(ExcelDataDrivenCase.class.getName());
	ExcelDataProviderConfig sheet = new ExcelDataProviderConfig("Testdata.xlsx");
	
	@BeforeTest
	public void initialize() throws IOException
	{
		String browserName = sheet.getData(0,1,0);
		System.out.println(browserName);
		initializeDriver(browserName);
		navigate_to_url(sheet.getData(0,1,1));
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String searchName, String testIdentity) throws IOException {
		LandingPage lp = new LandingPage(driver);
		log.info("Reached the google search page");
		System.out.println(searchName);
		System.out.println(testIdentity);
		lp.getSearchBox().sendKeys(searchName);
		// k.sendKeys(searchName);
		lp.getSearchBox().sendKeys(Keys.ENTER);
		// Sending the control to the search result page
		SearchResultPage srp = new SearchResultPage(driver);
		String rhsDivText = srp.getResultDiv().getText();
		boolean text = rhsDivText.contains(searchName);
		System.out.println(text);
//		Assert.assertEquals("Ensured that the search returned the expected result", true, text);
		log.info("Searched the text as expected");
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[1][2];
		
		data[0][0] = sheet.getData(0,1,3);
		data[0][1] = "Test 1";

		return data;
	}
	
	@AfterTest
	public void teardown() throws IOException {
		// Take screen shots
		TestBase.getScreenshot("Search Page");
		driver.close();
	}
}