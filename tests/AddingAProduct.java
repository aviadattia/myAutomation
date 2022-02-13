package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class AddingAProduct extends BaseTest {
	@Test
	public void tc7() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_user", "secret_sauce");
		// ADDING FROM PRODUCT PAGE
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("Sauce Labs Onesie");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
		psp.chooseProduct("Sauce Labs Bolt T-Shirt");
		pp.addToCart();
		pp.back();
		int expected = 2;
		int actual = pp.getCounter();
		Assert.assertEquals(actual, expected);
		System.out.println("expected QTY = " + expected + "||" + " actual QTY = " + actual);
	}

	@Test // ADDING FROM PRODUCTS PAGE
	public void tc8() {
		ProductsPage psp = new ProductsPage(driver);
		psp.addToCart("Sauce Labs Backpack");
		psp.addToCart("Sauce Labs Bike Light");
		int expected = 4;
		int actual = psp.getCounter();
		Assert.assertEquals(actual, expected);
		System.out.println("expected QTY = " + expected + "||" + " actual QTY = " + actual);
		psp.goToCart();
	}

	@Test // ADDING FROM CART PAGE
	public void tc9() {
		YourCartPage ycp = new YourCartPage(driver);
		ycp.continueShop();
		ProductsPage psp = new ProductsPage(driver);
		psp.addToCart("Sauce Labs Fleece Jacket");
		psp.addToCart("Test.allTheThings() T-Shirt (Red)");
		int expected = 6;
		int actual = psp.getCounter();
		Assert.assertEquals(actual, expected);
		System.out.println("expected QTY = " + expected + "||" + " actual QTY = " + actual);
	}
}