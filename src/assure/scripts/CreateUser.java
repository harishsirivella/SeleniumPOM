package assure.scripts;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import assure.initiator.DriverLaunch;
import assure.initiator.LoginApp;
import assure.pages.*;
import assure.resuables.Helpers;
import assure.resuables.Utilities;

public class CreateUser extends Utilities {
	LoginApp appLogin;
	Testcases_Pages testcasesPages;
	Testrun_Pages testrunPages;
	Testrunoverview_Pages testrunoverviewpage;
	ConnectBrowser_Pages connectBrowserPages;
	PrepareManualTesting_Pages prepareManualTestingPage;
	CheckpointTestOverview_Page checkpointTestPage;
	Addissue_Pages addissuePage;

	String pathTemp = "";
	public WebDriverWait w;

	public CreateUser() {
		try {
			System.out.println("create user");
			appLogin = new LoginApp();
			testcasesPages = new Testcases_Pages();
			testrunPages = new Testrun_Pages();
			testrunoverviewpage = new Testrunoverview_Pages();
			connectBrowserPages = new ConnectBrowser_Pages();
			prepareManualTestingPage = new PrepareManualTesting_Pages();
			checkpointTestPage = new CheckpointTestOverview_Page();
			addissuePage = new Addissue_Pages();
		} catch (Exception e) {
			Assert.fail("Testcase is failed" + e.getMessage());
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception { // ITestResult result
		Helpers.testCaseResult(result);
	}

	/*@BeforeMethod
	public void beforeMethod() {
		DriverLaunch.log = DriverLaunch.reports.startTest(this.getClass().getSimpleName());
	}*/

	@Test
	public void createTC(){
		try{
			DriverLaunch.log = DriverLaunch.reports.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			DriverLaunch.log.log(LogStatus.INFO, "Started login");
			DriverLaunch.log.getStartedTime();
			appLogin.loginAdmin();
			Thread.sleep(4000);
			appLogin.logout();
		}
		catch (Exception e){
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
}
