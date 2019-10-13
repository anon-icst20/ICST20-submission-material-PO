package utils;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected static WebDriver driver;
	// for Docker Toolbox users change 'localhost' below with the IP address written on the console
	// when you start the Docker Toolbox program
	protected static String URL = "http://localhost:3000/addressbook/";

	@Before
	public void setUp() throws InterruptedException {

		driver = getDriver();
		driver.get(URL);
	}

	@After
	public void tearDown() {
		driver.quit();
		driver = null;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
			driver.get(URL);
		}
		return driver;
	}

}
