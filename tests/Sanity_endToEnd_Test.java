package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckoutInfo;
import pageObjects.FinishOrder;
import pageObjects.LastPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;
import utils.Utils;

public class Sanity_endToEnd_Test extends BaseMethod {

	@Test
	public void tc26() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "Swag Labs";
		Assert.assertEquals(actualTitle, expectedTitle);

		ProductsPage psp = new ProductsPage(driver);
		Assert.assertTrue(psp.isLoginPass());
		System.out.println(psp.isLoginPass());

		psp.chooseProduct("Sauce Labs Bolt T-Shirt");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
		psp = new ProductsPage(driver);
		psp.chooseProduct("Test.allTheThings() T-Shirt (Red)");
		pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
		psp = new ProductsPage(driver);
		psp.chooseProduct("Sauce Labs Backpack");
		pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
		pp.sleep(100);

		psp.addToCart("Sauce Labs Onesie");
		psp.addToCart("Sauce Labs Bike Light");
		psp.addToCart("Sauce Labs Fleece Jacket");
		pp.sleep(100);

		psp.removeFromCart("Test.allTheThings() T-Shirt (Red)");

		psp.chooseProduct("Sauce Labs Onesie");
		pp = new ProductPage(driver);
		pp.removeCart();
		pp.sleep(100);
		psp.openCart();

		YourCartPage ycp = new YourCartPage(driver);
		Assert.assertTrue(ycp.isYourCartPage());
		System.out.println(ycp.isYourCartPage());

		ycp.removeFromCart("Sauce Labs Bolt T-Shirt");
		ycp.checkout();
		pp.sleep(100);

		CheckoutInfo coi = new CheckoutInfo(driver);
		Assert.assertTrue(coi.isYourCartInfo());
		System.out.println(coi.isYourCartInfo());
		pp.sleep(100);
		coi.cancel();

		pp.sleep(100);
		ycp = new YourCartPage(driver);
		ycp.checkout();
		coi.info("aviad", "attia", "123456789");

		psp.sleep(2000);
		driver.navigate().back();
		psp.sleep(2000);
		driver.navigate().refresh();
		psp.sleep(2000);
		driver.navigate().forward();

		FinishOrder fo = new FinishOrder(driver);
		Assert.assertTrue(fo.isoverviewPage());
		System.out.println(fo.isoverviewPage());
		System.out.println("items in cart = " + fo.getCounter());
		fo.checkBill();

		LastPage lap = new LastPage(driver);
		String expected = "THANK YOU FOR YOUR ORDER";
		String actual = lap.getErrorMes();
		System.out.println(actual + "||" + expected);
		Assert.assertEquals(actual, expected);
		lap.backToStart();
		lap.sleep(2000);
		driver.get(Utils.readProperty("emptyCart"));
	}
}
