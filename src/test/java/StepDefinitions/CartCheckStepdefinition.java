package StepDefinitions;

import utils.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.ProductPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import config.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jdk.internal.org.jline.utils.Log;

public class CartCheckStepdefinition {

	private static final Logger log = LogManager.getLogger(CartCheckStepdefinition.class);
WebDriver driver=DriverManager.getDriver();

	@Test
	@Given("User is on the product page")
	public void User_is_on_product_page()  {
		DriverManager.implicitWait();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		log.info("User is on product page");
	}

	@Test
	@When("User adds {string} , {string}, {string},{string},{string} to cart")
	public void User_adds_products_to_cart(String p1, String p2, String p3, String p4, String p5) {
		ProductPage.addToCart(p1, p2, p3, p4, p5);

		log.info("Products added to cart");
	}

	@Test
	@Then("Cart should have {int} items")
	public void Cart_should_have_items(Integer int1) {
		CartPage.verifyCartItems(int1);

	}

	@Test
	@When("User proceed to checkout and apply promo {string}")
	public void User_proceed_to_checkout_and_apply_promo(String promoCode) {
		CartPage.checkOut(promoCode);
	}

	@Test
	@Then("Discount should be applied and order placed successfully")
	public void Discount_should_be_applied_and_order_placed_successfully() throws InterruptedException {
		CartPage.promoCheckStatus();
		
	//	driver.close();

	}

	@When("User apply invalid promo {string}")
	public void User_apply_invalid_promo(String promoCode) {
		CartPage.InvalidPromoCheck(promoCode);
		log.info("Invalid promocode entered");
	}

	@Then("Error message {string} should be displayed")
	public void Error_message_should_be_displayed(String string) {
		CartPage.verifyErrorMsg(string);
		log.info("Please enter valid promocode");
		driver.quit();
		
		
		
	}

	

}
