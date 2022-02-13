package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutInfo extends MenuPage {
	@FindBy(css = "#first-name")
	private WebElement firstNameField;
	@FindBy(css = "#last-name")
	private WebElement lastNameField;
	@FindBy(css = "#postal-code")
	private WebElement postalCodeField;
	@FindBy(css = "#continue")
	private WebElement continueBtn;
	@FindBy(css = "#cancel")
	private WebElement cancelBtn;

	@FindBy(css = "[data-test='error']")
	private WebElement errorMsg;
	@FindBy(css = ".title")
	private WebElement checkInfoLabel;

	public CheckoutInfo(WebDriver driver) {
		super(driver);
	}

	public void info(String firstName, String lastName, String post) {
		fillText(firstNameField, firstName);
		fillText(lastNameField, lastName);
		fillText(postalCodeField, post);
		click(continueBtn);
	}

	public void cancel() {
		click(cancelBtn);
	}

	// validation
	public String getErrorMsg() {
		return getText(errorMsg);
	}

	public boolean isYourCartInfo() {
		if (getText(checkInfoLabel).equalsIgnoreCase("CHECKOUT: YOUR INFORMATION")) {
			return true;
		}
		return false;
	}
}
