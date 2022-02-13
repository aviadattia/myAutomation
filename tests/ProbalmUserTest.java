package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class ProbalmUserTest extends BaseTest {

	@Test
	public void tc6() {
		LoginPage lp = new LoginPage(driver);
		lp.Login("problem_user", "secret_sauce");
		ProductsPage psp = new ProductsPage(driver);
		psp.addToCart("Sauce Labs Backpack");
		psp.addToCart("Sauce Labs Bike Light");
		psp.addToCart("Sauce Labs Bolt T-Shirt");
		psp.addToCart("Sauce Labs Fleece Jacket");
		psp.addToCart("Sauce Labs Onesie");
		psp.addToCart("Test.allTheThings() T-Shirt (Red)");
		psp.goToCart();
		int expected = 6;
		int actual = psp.getCounter();
		Assert.assertEquals(actual, expected);
		System.out.println("expected = " + expected + "||" + "actual = " + actual);
	}

}
