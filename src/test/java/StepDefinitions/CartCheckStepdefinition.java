package StepDefinitions;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.CartPage;
import Pages.ProductPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DriverManager;

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
	 @When("User adds following items to cart")
    public void user_adds_following_items_to_cart(DataTable dataTable) {
       
		ProductPage.addToCart(dataTable);

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
