package assure.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;

import assure.initiator.DriverLaunch;
import assure.resuables.Helpers;

public class CheckpointTestOverview_Page {
	
	@FindBy(xpath = "//a[contains(.,'Continue Testing')]")
	public static WebElement btn_continueTesting;
	
	@FindBy(xpath="html/body/div[3]/div[2]/div/div[5]/div[2]/div[2]/div[2]/div/div[2]/button]")
	public static WebElement btn_cptoaddissue;
	
	@FindBy(xpath = ".//*[@id='notifications']/div/div")
	public static WebElement notification;
	
	@FindBy(xpath ="//div[1]/p/a/span")
	public static WebElement lnk_manual_issuecount;
	
	@FindBy(xpath = "//p[2]/a/span")
	public static WebElement lnk_total_issuecount;
	
	
	
	public CheckpointTestOverview_Page() {
		PageFactory.initElements(DriverLaunch.driver, this);
	}

//	Add A11y issue from CPTO page
	public static void addA11yIssueCPTO(String issuename) {
		DriverLaunch.log.log(LogStatus.INFO, "Adding a new issue " + issuename);
		try {
			Helpers.click(btn_cptoaddissue);
			Addissue_Pages.issueSummary(issuename);
			Addissue_Pages.selectCheckpoint("1.1.1.a Alternative Text (Active Images)");
			Addissue_Pages.selectDescription("AREA alt text is missing");
			Helpers.click(Addissue_Pages.btn_createissue);
			Thread.sleep(1000);
			Helpers.verifyText(notification, "Issue saved successfully for 1.1.1.a Alternative Text (Active Images)");
			DriverLaunch.log.log(LogStatus.PASS, issuename +"  is created");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, "Adding a new issue is failed :: " + e.getMessage());
		}
	}
	
//	Add Best Practice issue from CPTO page 
	public static void addBestPracticeIssueCPTO(String issuename) {
		DriverLaunch.log.log(LogStatus.INFO, "Adding a new issue " + issuename);
		try {
			Helpers.click(btn_cptoaddissue);
			Addissue_Pages.issueSummary(issuename);
			Addissue_Pages.selectCheckpoint("1.1.1.a Alternative Text (Active Images)");
			Addissue_Pages.selectDescription("Alt text duplicates adjacent link text");
			Helpers.click(Addissue_Pages.btn_createissue);
			Thread.sleep(1000);
			Helpers.verifyText(notification, "Issue saved successfully for 1.1.1.a Alternative Text (Active Images)");
			DriverLaunch.log.log(LogStatus.PASS, issuename +"  is created");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, "Adding a new issue is failed :: " + e.getMessage());
		}
	}
	
//	Add A11y issue with flag
	public static void addA11yIssueFlagCPTO(String issuename) {
		DriverLaunch.log.log(LogStatus.INFO, "Adding a new issue " + issuename);
		try {
			Helpers.click(btn_cptoaddissue);
			Addissue_Pages.issueSummary(issuename);
			Addissue_Pages.selectCheckpoint("1.1.1.a Alternative Text (Active Images)");
			Helpers.click(Addissue_Pages.chk_flag);
			Helpers.input(Addissue_Pages.inp_flagreason, "flagged issue");
			Addissue_Pages.selectDescription("AREA alt text is missing");
			Helpers.click(Addissue_Pages.btn_createissue);
			Thread.sleep(1000);
			Helpers.verifyText(notification, "Issue saved successfully for 1.1.1.a Alternative Text (Active Images)");
			DriverLaunch.log.log(LogStatus.PASS, issuename +"  is created");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, "Adding a new issue is failed :: " + e.getMessage());
		}
	}
}
