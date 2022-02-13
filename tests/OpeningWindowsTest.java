package tests;

import java.util.Set;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;

public class OpeningWindowsTest extends BaseTest {

	@Test
	public void tc23()  {

		LoginPage lp = new LoginPage(driver);
		lp.Login("standard_user", "secret_sauce");
		// website window
		driver.findElement(By.cssSelector(".social_twitter a")).click();
		String main = driver.getWindowHandle();
		// move to twitter
		Set<String> list = driver.getWindowHandles();
		for (String win : list) {
			driver.switchTo().window(win);
		}
		// twitter window

		String actual = driver.getCurrentUrl();
		String expected = "https://twitter.com/saucelabs";
		Assert.assertEquals(actual, expected);
		System.out.println("expected url = " + expected + "||" + "actual url = " + actual);

		lp.sleep(1000);
		driver.close();
		driver.switchTo().window(main);

	}

	@Test
	public void tc24() throws InterruptedException {
		// website window
		driver.findElement(By.cssSelector(".social_facebook a")).click();
		String main = driver.getWindowHandle();
		// move to facebbok
		Set<String> list1 = driver.getWindowHandles();
		for (String win : list1) {
			driver.switchTo().window(win);
		}
		// facebook window

		String actual = driver.getCurrentUrl();
		String expected = "https://www.facebook.com/saucelabs";
		Assert.assertEquals(actual, expected);
		System.out.println("expected url = " + expected + "||" + "actual url = " + actual);

		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(main);
	}

	@Test
	public void tc25() throws InterruptedException {
		// website window
		driver.findElement(By.cssSelector(".social_linkedin a")).click();
		String main = driver.getWindowHandle();
		// move to linkdein
		Set<String> list1 = driver.getWindowHandles();
		for (String win : list1) {
			driver.switchTo().window(win);
		}
		// linkdein window

		// no assertion because verification on site
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(main);
		Thread.sleep(2000);
	}
}
