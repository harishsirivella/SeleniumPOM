package assure.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.LogStatus;

import assure.initiator.DriverLaunch;

public class Addissue_Pages {

	@FindBy(xpath = "//input[@id='summary']")
	public WebElement inp_issueSummary;

	@FindBy(xpath = "//input[@id='combobox']")
	public static WebElement inp_checkpoint;

	@FindBy(xpath = "html/body/div[4]/div[2]/form/div[1]/div[2]/div/div/div[1]/div[2]/span")
	// html/body/div[4]/div[2]/form/div[1]/div[2]/div/div/div[1]/div[2]
	public static WebElement dd_checkpoint;

	@FindBy(id = "issue-flagged")
	public static WebElement chk_flag;
	
	@FindBy(id = "flagReason")
	public static WebElement inp_flagreason;
	
	@FindBy(xpath = "//select[@id='description_id']")
	public static WebElement dd_description;

	@FindBy(xpath ="//button[contains(.,'Create your own description')]")
	public static WebElement lnk_createOwnDescription;
	
	@FindBy(xpath = "html/body/div[4]/div[2]/form/div[2]/button")
	public static WebElement btn_createissue;

	
	// Enter text in summary
	public static void issueSummary(String issuesummary) {
		try {
			inp_checkpoint.sendKeys(issuesummary);
			Thread.sleep(1000);
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}

	// select checkpoint
	public static void selectCheckpoint(String issuecheckpoint) throws Exception {
		try {
			inp_checkpoint.clear();
			inp_checkpoint.sendKeys(issuecheckpoint);
			Thread.sleep(2000);
			dd_checkpoint.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, "Failed to select checkpoint:: " + e.getMessage());
		}
	}

	public static void selectDescription(String issuedesc) throws Exception {
		try {
			dd_description.sendKeys(issuedesc);
			Thread.sleep(2000);
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, "Failed to select Description :: " + e.getMessage());
		}
	}
}
