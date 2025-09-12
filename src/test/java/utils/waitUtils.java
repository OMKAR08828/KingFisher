package utils;

import utils.DriverManager;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import config.ConfigReader;

public class waitUtils {
	
	public static class WaitUtils {
		WebDriver driver;
		ConfigReader reader= new ConfigReader();	    
	    public static WebElement waitForElementVisible(By locator) throws Exception {
	        WebDriver driver = DriverManager.getDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	    }

	  
	    public WebElement waitForElementClickable(By locator) throws SQLException {
	        WebDriver driver = DriverManager.getDriver();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        return wait.until(ExpectedConditions.elementToBeClickable(locator));
	    }
}

	
		
	}

