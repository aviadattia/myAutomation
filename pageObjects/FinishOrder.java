package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FinishOrder extends MenuPage {
	@FindBy(css = "#finish")
	private WebElement completeOrder;

	@FindBy(css = ".summary_subtotal_label")
	private WebElement itemsField;
	@FindBy(css = ".summary_tax_label")
	private WebElement taxField;
	@FindBy(css = ".summary_total_label")
	private WebElement totalField;

	@FindBy(css = ".title")
	private WebElement overviewLabel;

	public FinishOrder(WebDriver driver) {
		super(driver);
	}

	public void checkBill() {

		String item = getText(itemsField);
		String tax = getText(taxField);
		String total = getText(totalField);
		click(completeOrder);
	
		item = item.replace("Item total: $", "");
		double itemP = Double.parseDouble(item);
		tax = tax.replace("Tax: $", "");
		double taxP = Double.parseDouble(tax);
		total = total.replace("Total: $", "");
		double totalP = Double.parseDouble(total);

		System.out.println("total item = " + itemP);
		System.out.println("tax = " + taxP);
		System.out.println("total price = " + totalP);
		if ((taxP + itemP) == totalP && totalP != 0) {
			System.out.println("bill is correct");
		} else {
			System.out.println("bill is NOT correct");
		}
	}

	public boolean isoverviewPage() {
		if (getText(overviewLabel).equalsIgnoreCase("CHECKOUT: OVERVIEW")) {
			return true;
		}
		return false;
	}
}
