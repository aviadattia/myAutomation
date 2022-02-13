package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckoutInfo;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class CheckOutCustomerInformationTest extends BaseTest {

	@Test
	public void tc17() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_user", "secret_sauce");
		ProductsPage psp = new ProductsPage(driver);
		psp.addToCart("Sauce Labs Onesie");
		psp.goToCart();
		YourCartPage ycp = new YourCartPage(driver);
		ycp.checkout();
		CheckoutInfo coi = new CheckoutInfo(driver);
		coi.info("donald", "", "123456");
		String expected = "Error: Last Name is required";
		String actual = coi.getErrorMsg();
		System.out.println(actual + "||" + expected);
		Assert.assertEquals(actual, expected);
		coi.cancel();
	}

	@Test
	public void tc18() {
		YourCartPage ycp = new YourCartPage(driver);
		ycp.checkout();
		CheckoutInfo coi = new CheckoutInfo(driver);
		coi.info("", "duck", "123456");
		String expected = "Error: First Name is required";
		String actual = coi.getErrorMsg();
		System.out.println(actual + "||" + expected);
		Assert.assertEquals(actual, expected);
		coi.cancel();
	}

	@Test
	public void tc19() {
		YourCartPage ycp = new YourCartPage(driver);
		ycp.checkout();
		CheckoutInfo coi = new CheckoutInfo(driver);
		coi.info("donald", "duck", "");
		String expected = "Error: Postal Code is required";
		String actual = coi.getErrorMsg();
		System.out.println(actual + "||" + expected);
		Assert.assertEquals(actual, expected);
	}
}
