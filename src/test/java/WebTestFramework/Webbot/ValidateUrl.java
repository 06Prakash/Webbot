package WebTestFramework.Webbot;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;

public class ValidateUrl extends base {

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
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
//		driver.close();
	}

}
