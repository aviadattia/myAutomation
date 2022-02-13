package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.CheckoutInfo;
import pageObjects.FinishOrder;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;
import pageObjects.YourCartPage;

public class CheckBillTest extends BaseMethod {

	@Test
	public void tc20() {
		ProductsPage psp = new ProductsPage(driver);
		psp.chooseProduct("Sauce Labs Backpack");
		ProductPage pp = new ProductPage(driver);
		pp.addToCart();
		pp.back();
		psp.chooseProduct("Sauce Labs Bike Light");
		pp.addToCart();
		pp.back();
		psp.chooseProduct("Sauce Labs Bolt T-Shirt");
		pp.addToCart();
		pp.back();

		pp.goToCart();
		YourCartPage ycp = new YourCartPage(driver);
		ycp.checkout();
		CheckoutInfo coi = new CheckoutInfo(driver);
		coi.info("aviad", "attia", "123456");

		FinishOrder fo = new FinishOrder(driver);
		fo.checkBill();

		String expected = "THANK YOU FOR YOUR ORDER";
		String actual = fo.getText(driver.findElement(By.cssSelector(".complete-header")));
		Assert.assertEquals(actual, expected);
		System.out.println("expected = " + expected + "||" + "actual = " + actual);
	}
}
