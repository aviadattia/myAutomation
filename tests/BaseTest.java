package tests;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Utils;

public class BaseTest {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = WebDriverManager.chromedriver().create();
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utils.readProperty("url")); // if methods is static

		// TasksPage tp = new TasksPage(driver);
		// tp.waitingForLoading();
	}

	/*@Test
	public void taskKill() {
		try {
			Runtime.getRuntime().exec("taskkill.exe /F /IM chromedriver.exe /T");
		} catch (IOException e) {
			System.out.println("something went wrong" + e.getMessage());
		}
	}*/

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

	// screen shot only for tests that failed
	@AfterMethod
	public void failedTest(ITestResult result) {
		// check if the test failed
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(srcFile, new File("./ScreenShots/" + result.getName() + ".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
