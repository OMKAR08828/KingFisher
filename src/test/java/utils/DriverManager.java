package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {

	private static WebDriver driver;
	private DriverManager() {
		
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}
