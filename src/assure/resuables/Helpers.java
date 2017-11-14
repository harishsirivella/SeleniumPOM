package assure.resuables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import com.relevantcodes.extentreports.LogStatus;

import assure.initiator.DriverLaunch;

public class Helpers {
	public static int timeOutInSeconds = 10; // Timeout

	public void beforeEveryTest() {
		DriverLaunch.log.getStartedTime();
	}

	// PageTitle
	public static void pageTitle(String expectedpageTitle) {
		try {
			Thread.sleep(2000);
			String actualTitle = DriverLaunch.driver.getTitle().trim();
			if (actualTitle.equals(expectedpageTitle.trim()))
				DriverLaunch.log.log(LogStatus.PASS, expectedpageTitle + " :: Page Title verified successfully");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}

	// Click Method
	public static void click(WebElement object) throws InterruptedException {
		try {
			Thread.sleep(1000);
			/*
			 * if (object != null) scrollToView(object); Thread.sleep(2000);
			 */
			object.click();
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
			// Assert.fail("Unable to click on the web element");
		}

	}

	// Capture screenshot
	public static void testCaseResult(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.SUCCESS) {
			DriverLaunch.log.getEndedTime();
			DriverLaunch.reports.endTest(DriverLaunch.log);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String screenpath = Utilities.captureScreenShot(DriverLaunch.filePath, result.getName().toString());
			System.out.println(result.getMethod().getMethodName());
			DriverLaunch.log.log(LogStatus.FAIL, DriverLaunch.log.addScreenCapture(screenpath));
			DriverLaunch.log.getEndedTime();
			DriverLaunch.reports.endTest(DriverLaunch.log);
		} else {
			String screenpath = Utilities.captureScreenShot(DriverLaunch.filePath, result.getName().toString());
			DriverLaunch.log.log(LogStatus.SKIP, DriverLaunch.log.addScreenCapture(screenpath));
			DriverLaunch.log.getEndedTime();
			DriverLaunch.reports.endTest(DriverLaunch.log);
		}
	}

	// Wait
	public static void Wait() {
		DriverLaunch.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// scroll to view the object
	public static void scrollToView(WebElement btnelement) {
		try {
			JavascriptExecutor je = (JavascriptExecutor) DriverLaunch.driver;
			WebElement scollelement = btnelement;
			je.executeScript("arguments[0].scrollIntoView(true);", scollelement);
			Thread.sleep(1000);
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}

	// wait to enter the input
	public static void input(WebElement element, String inputtext) throws InterruptedException {
		try {
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(DriverLaunch.driver, timeOutInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.sendKeys(inputtext);
			Thread.sleep(2000);
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}

	// isElement displayed
	public static void objectDisplayed(WebElement object) {
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
		if (object.isDisplayed()) {
			object.click();
		}
	}

	public static void verifyText(WebElement object, String expresult) {
		String actual = object.getText().trim();
		try {
			Assert.assertEquals(actual, expresult = expresult.trim());
			DriverLaunch.log.log(LogStatus.PASS,
					"ACTUAL is:: " + actual + " and EXPECTED is:: " + expresult + " -- Text verified successfully");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}

	// Navigate URL
	public static void navigateUrl(String url) {
		try {
			Thread.sleep(2000);
			DriverLaunch.driver.navigate().to(url);
			Thread.sleep(5000);
			DriverLaunch.log.log(LogStatus.PASS, "Navigated to ::: " + url);
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}

	// Verify details
	public static void verifyDetails(String text) {
		DriverLaunch.log.log(LogStatus.INFO, "Verifying Details ::: " + text);
		boolean contain = DriverLaunch.driver.findElement(By.cssSelector("body")).getText().contains(text);
		try {
			Thread.sleep(3000);
			Assert.assertTrue(contain);
			DriverLaunch.log.log(LogStatus.PASS, text + ":: Verified successfully");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
	// Verify No details
	public static void verifyNoDetails(String text) {
		DriverLaunch.log.log(LogStatus.INFO, "Verifying No Details ::: " + text);
		boolean contain = DriverLaunch.driver.findElement(By.cssSelector("body")).getText().contains(text);
		try {
			Thread.sleep(3000);
			Assert.assertFalse(contain);
			DriverLaunch.log.log(LogStatus.PASS, text + ":: isn't available");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}

}
