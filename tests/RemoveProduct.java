package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class RemoveProduct extends BaseTest {

	@Test
	public void tc10() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_user", "secret_sauce");

		ProductsPage psp = new ProductsPage(driver);
		psp.addToCart("Sauce Labs Backpack");
		psp.addToCart("Sauce Labs Bike Light");
		psp.addToCart("Sauce Labs Bolt T-Shirt");
		psp.addToCart("Sauce Labs Fleece Jacket");
		int expected = 4;
		int actual = psp.getCounter();
		Assert.assertEquals(actual, expected);
		System.out.println("expected QTY = " + expected + "||" + " actual QTY = " + actual);
		// remove from product page
		psp.chooseProduct("Sauce Labs Fleece Jacket");
		ProductPage pp = new ProductPage(driver);
		pp.removeCart();
		pp.back();
		int expected1 = 3;
		int actual1 = psp.getCounter();
		Assert.assertEquals(actual1, expected1);
		System.out.println("expected QTY = " + expected1 + "||" + " actual QTY = " + actual1);
	}

	@Test
	public void tc11() {
		ProductsPage psp = new ProductsPage(driver);
		// remove from products page
		psp.removeFromCart("Sauce Labs Bike Light");
		int expected = 2;
		int actual = psp.getCounter();
		Assert.assertEquals(actual, expected);
		System.out.println("expected QTY = " + expected + "||" + " actual QTY = " + actual);
		psp.goToCart();
	}

	@Test
	public void tc12() {
		YourCartPage ycp = new YourCartPage(driver);
		// remove from cart page
		ycp.removeFromCart("Sauce Labs Bolt T-Shirt");
		int expected = 1;
		int actual = ycp.getCounter();
		Assert.assertEquals(actual, expected);
		System.out.println("expected QTY = " + expected + "||" + " actual QTY = " + actual);
	}
}
