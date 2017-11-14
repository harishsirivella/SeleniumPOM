package assure.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import assure.initiator.DriverLaunch;
import assure.resuables.Helpers;

public class Testcases_Pages extends Helpers {

	@FindBy(xpath = "//a[contains(.,'Test Cases')]")
	public static WebElement testcasesmenu;

	@FindBy(xpath = "//button[contains(text(),'Create new folder')]")
	public static WebElement btn_createfolder;

	@FindBy(xpath = "//input[@id='foldername']")
	public static WebElement inp_foldername;

	@FindBy(xpath = "//input[@id='save-folder']")
	public static WebElement btn_savefolder;

	@FindBy(xpath = "//a[contains(.,'01smokefolder (0)')]")
	public static WebElement lnk_folder;

	@FindBy(xpath = "//button[contains(text(),'Edit folder')]")
	public static WebElement btn_editfolder;

	@FindBy(xpath = "//button[contains(.,'Delete folder')]")
	public static WebElement btn_delfolder;

	@FindBy(xpath = "//button[contains(.,'Yes, Delete Folder')]")
	public static WebElement btn_confirmdelete;

	@FindBy(xpath = "//a[contains(.,'New test case')]")
	public static WebElement newtestcaseButton;

	@FindBy(xpath = "//*[@id='name']")
	public static WebElement testcaseNameInput;

	@FindBy(xpath = "//button[@id='next-button']")
	public static WebElement tcNextButton;

	@FindBy(xpath = "//button[contains(.,'Add New Page')]")
	public static WebElement addNewPageButton;

	@FindBy(id = "page-name")
	public static WebElement inputPageName;

	@FindBy(xpath = "//input[@id='page-url']")
	public static WebElement pageURL;

	@FindBy(xpath = "//button[@id='save-page']")
	public static WebElement pageSave;

	@FindBy(xpath = "//button[contains(.,'Create Test Case')]")
	public static WebElement createTCButton;

	@FindBy(xpath = "html/body/div[3]/div[2]/div/div[2]/div[2]/div[2]/div/div[2]/table/tbody/tr/td[5]/ul/li[1]/a")
	// + "//a[contains(.,'Create test run')]")
	public static WebElement createtestrunButton;

	@FindBy(xpath = ".//*[@id='notifications']/div/div")
	public static WebElement notification;

	public Testcases_Pages() {
		PageFactory.initElements(DriverLaunch.driver, this);
	}

	public void createNewTestcasewithPage(String testname) {
		try {
			DriverLaunch.log.log(LogStatus.INFO, "Creating a new testcase");
			Helpers.click(testcasesmenu);
			Helpers.click(newtestcaseButton);
			Helpers.input(testcaseNameInput, testname);
			Helpers.click(tcNextButton);
			Helpers.click(tcNextButton);
			Helpers.click(addNewPageButton);
			Helpers.pageTitle("Add New Page - New Test Case - WorldSpace Assure");
			Helpers.input(inputPageName, "Page1");
			Helpers.input(pageURL, DriverLaunch.testpageurl);
			Helpers.click(pageSave);
			Thread.sleep(2000);
			Helpers.click(createTCButton);
			Thread.sleep(1000);
			Helpers.verifyText(notification, "Test case successfully created");
			DriverLaunch.log.log(LogStatus.PASS, "New test case is created:: " + testname);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	public void createNewFolder(String foldername) throws Exception {
		DriverLaunch.log.log(LogStatus.INFO, "Creating a new folder");
		click(btn_createfolder);
		input(inp_foldername, foldername);
		click(btn_savefolder);
		Thread.sleep(2000);
		verifyText(notification, "Saved successfully");
		verifyDetails(foldername);
	}

	public void deleteFolder(String foldername) {
		try {
			DriverLaunch.log.log(LogStatus.INFO, "Deleting a folder");
			click(lnk_folder);
			click(btn_editfolder);
			click(btn_delfolder);
			click(btn_confirmdelete);
			Thread.sleep(3000);
			verifyText(notification, "Deleted successfully");
			verifyNoDetails(foldername);
			DriverLaunch.log.log(LogStatus.PASS, foldername + "  :: folder is deleted");
		} catch (Exception e) {
			Assert.fail();
		}
	}
}