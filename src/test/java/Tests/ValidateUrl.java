package Tests;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.LandingPage;
import ui_automation.hawk.TestBase;

public class ValidateUrl extends TestBase {

	@BeforeTest
	public void initialize() throws IOException {
		initializeDriver();
		navigate_to_url(prop.getProperty("url"));
	}

	@Test
	public void validateNavigation() throws IOException {
		LandingPage l = new LandingPage(driver);
		String actual = l.getTitle();
		System.out.println(actual);
		if (actual.equals("Google")) {
			System.out.println("Looks fine");
		}
		// driver.close();
	}

	@AfterTest
	public void teardown() throws IOException {
		// Take screen shots
		TestBase.getScreenshot("HomePage");
		driver.close();
	}

}
