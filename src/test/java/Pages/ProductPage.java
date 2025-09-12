package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import utils.DriverManager;

public class ProductPage {
	static WebDriver driver = DriverManager.getDriver();

	static By searchBox = By.className("search-keyword");
	

	public static void addToCart(String p1, String p2, String p3, String p4, String p5) {
		String[] products = { p1, p2, p3, p4, p5 };

		for (String product : products) {
			// Search box and add to cart logic
			driver.findElement(searchBox).clear();
			driver.findElement(searchBox).sendKeys(product);

			WebElement addBtn = driver.findElement(By.xpath("//h4[contains(text(),'" + product + "')]/../div/button"));
			addBtn.click();
			
			List<WebElement> quantities =driver.findElements(By.cssSelector("table.cartTable input.quantity"));
			for (WebElement qty : quantities) {
			    Assert.assertEquals(qty.getAttribute("value"), "1", "Quantity mismatch in cart!");
			}
		

		}
	}
}
