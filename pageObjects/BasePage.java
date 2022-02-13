package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	JavascriptExecutor js;
	Actions actions;
	// WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		// wait = new WebDriverWait(driver, 15);
	}

	public void fillText(WebElement el, String text) {
		highlightElement(el, "red");
		el.clear();
		sleep(200);
		el.sendKeys(text);
	}

	public void click(WebElement el) {
		highlightElement(el, "blue");
		sleep(200);
		el.click();
	}

	public String getText(WebElement el) {
		highlightElement(el, "green");
		sleep(200);
		return el.getText();
	}

	public void alertOk(String text) {
		driver.switchTo().alert().sendKeys(text);
		driver.switchTo().alert().accept();
	}

	// mouse
	public void moveTo(WebElement el) {
		actions.moveToElement(el).build().perform();
	}

	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// highlight Element
	private void highlightElement(WebElement element, String color) {
		String originalStyle = element.getAttribute("style");
		String newStyle = ";background-color:pink; border: 5px solid " + color + ";" + originalStyle;
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ newStyle + "');},0);", element);

		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);
	}
}
