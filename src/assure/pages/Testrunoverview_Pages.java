package assure.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import assure.initiator.DriverLaunch;
import assure.resuables.Helpers;

public class Testrunoverview_Pages {

	@FindBy(xpath = "//a[contains(.,'Start Testing ')]")
	public WebElement btn_startTesting;

	@FindBy(xpath = "html/body/div[3]/div[2]/div/div[1]/div[1]/div/h1")
	public WebElement txt_header;

	public Testrunoverview_Pages() {
		PageFactory.initElements(DriverLaunch.driver, this);
	}

	public void clickStartTesting() throws InterruptedException {
		try {
			Helpers.click(btn_startTesting);
			DriverLaunch.log.log(LogStatus.PASS, "Start Testing button is clicked");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}
}
