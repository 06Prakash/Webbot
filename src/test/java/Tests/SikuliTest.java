package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//import junit.framework.Assert;
import PageObject.IPhoneHome;
import junit.framework.Assert;
import ui_automation.hawk.TestBase;

public class SikuliTest extends TestBase {
	public static Logger log = LogManager.getLogger(SikuliTest.class.getName());

	protected WebDriver driver;

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		navigate_to_url("https://www.apple.com/in/iphone/");
	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		IPhoneHome iphonehome = new IPhoneHome(driver);

		Assert.assertEquals("iPhone", iphonehome.getPageHeader());
		// click the iphone6 image
		log.info("Ensured that the next page is reached and the image button got process and found as expected");
		iphonehome.clickImage(iphonehome.iphoneimg);
	}

	@AfterTest
	public void teardown() throws IOException {
		// Take screen shots

		driver.close();
	}
}
