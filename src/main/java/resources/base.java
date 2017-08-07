package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {

		prop = new Properties();
		FileInputStream fis = new FileInputStream("data.properties");

		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "C://Ruby22-x64//bin//chromedriver.exe");
			driver = new ChromeDriver();
			// execute in chrome driver
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C://eclipse//geckodriver.exe");
			driver = new FirefoxDriver();
			// fire fox code
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C://eclipse//iedriver.exe");
			driver = new InternetExplorerDriver();
			// IE code
		}		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void navigate_to_url(String url) {
		driver.get(url);
	}

	public static void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test-screenshots//" + result + "screenshot.png"));
	}
}
