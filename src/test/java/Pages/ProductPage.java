package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import utils.DriverManager;

public class ProductPage {
	static WebDriver driver = DriverManager.getDriver();

	static By searchBox = By.className("search-keyword");

	public static void addToCart(DataTable dataTable) {
		List<String> products = dataTable.asList(String.class);

		for (String product : products) {
			// Search box and add to cart logic
			driver.findElement(searchBox).clear();
			driver.findElement(searchBox).sendKeys(product);

			WebElement addButton = driver
					.findElement(By.xpath("//h4[contains(text(),'" + product + "')]/following-sibling::div/button"));
			addButton.click();

			System.out.println(product + " Added to cart");

			List<WebElement> quantities = driver.findElements(By.cssSelector("table.cartTable input.quantity"));
			for (WebElement qty : quantities) {
				Assert.assertEquals(qty.getAttribute("value"), "1", "Quantity mismatch in cart!");

			}

		}
	}
}
