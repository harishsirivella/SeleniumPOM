package assure.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import assure.initiator.DriverLaunch;
import assure.resuables.Helpers;

public class ConnectBrowser_Pages {

	@FindBy(className = "manual")
	// xpath = "html/body/div[3]/div[2]/div/div[5]/div[2]/div[1]/a[2]")
	public static WebElement lnk_skipautomation;

	@FindBy(xpath="//button[contains(.,'Start Testing')]")
	public static WebElement btn_startTesting;
	
	
	public ConnectBrowser_Pages() {
		PageFactory.initElements(DriverLaunch.driver, this);
	}

	public static void skipAutomatedTesting() {
		try {
			Helpers.click(lnk_skipautomation);
			Helpers.click(btn_startTesting);
			DriverLaunch.log.log(LogStatus.PASS, "Automated testing is skipped");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}
}