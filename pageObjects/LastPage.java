package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LastPage extends MenuPage {

	@FindBy(css = "#back-to-products")
	private WebElement backHomeBtn;
	@FindBy(css = "#checkout_complete_container > h2")
	private WebElement errorMsg;

	public LastPage(WebDriver driver) {
		super(driver);
	}

	public void backToStart() {
		click(backHomeBtn);
	}

	// validation
	public String getErrorMes() {
		return getText(errorMsg);
	}
}
