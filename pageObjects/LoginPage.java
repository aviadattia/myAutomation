package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	@FindBy(css = "#user-name")
	private WebElement usernameField;
	@FindBy(css = "#password")
	private WebElement passwordField;
	@FindBy(css = "#login-button")
	private WebElement loginBtn;

	@FindBy(css = "[data-test='error']")
	private WebElement errorLabel;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void Login(String username, String password) {
		fillText(usernameField, username);
		fillText(passwordField, password);
		click(loginBtn);
	}

	public String getErrorMsg() {
		return getText(errorLabel);
	}
}
