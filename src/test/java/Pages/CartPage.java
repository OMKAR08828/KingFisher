package Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.DriverManager;

public class CartPage {

	static WebDriver driver = DriverManager.getDriver();

	static By cartButton = By.cssSelector("img[alt='Cart']");
	static By checkOutBtn = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	static By promoBox = By.className("promoCode");
	static By promoBtn = By.className("promoBtn");
	static By promoStatus = By.cssSelector(".promoInfo");
	static By placeOrderBtn = By.xpath("//button[text()='Place Order']");
	static By proceedBtn = By.xpath("//button[text()='Proceed']");

	public static void verifyCartItems(int n) {
		driver.findElement(cartButton).click();
		driver.findElement(checkOutBtn).click();

		List<WebElement> cartItems = driver.findElements(By.xpath("//*[@id=\"productCartTables\"]/tbody/tr"));
		Assert.assertEquals(n, cartItems.size());

	}

	public static void checkOut(String promo) {
		driver.findElement(promoBox).sendKeys(promo);
		driver.findElement(promoBtn).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
	}

	public static void promoCheckStatus() {

		WebElement promoMsg = driver.findElement(promoStatus);
		Assert.assertTrue(promoMsg.getText().contains("Code applied"));

		driver.findElement(placeOrderBtn).click();

		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/select"));
		Select select = new Select(dropdown);
		select.selectByValue("India");

		driver.findElement(By.className("chkAgree")).click();

		driver.findElement(proceedBtn).click();

	}

	public static void InvalidPromoCheck(String code) {
		driver.findElement(promoBox).sendKeys(code);
		driver.findElement(promoBtn).click();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static void verifyErrorMsg(String error) {
		WebElement promoMsg = driver.findElement(promoStatus);
		Assert.assertTrue(promoMsg.getText().contains("Invalid code ..!"));

	}
	
	
	
	
	public void test1()
	{
		
	}
}
