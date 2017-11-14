package assure.scripts;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import assure.initiator.DriverLaunch;
import assure.initiator.LoginApp;
import assure.pages.*;
import assure.resuables.Helpers;

public class SmokeTest {
	LoginApp appLogin;
	Testcases_Pages testcasesPages;
	Testrun_Pages testrunPages;
	Testrunoverview_Pages testrunoverviewpage;
	ConnectBrowser_Pages connectBrowserPages;
	PrepareManualTesting_Pages prepareManualTestingPage;
	CheckpointTestOverview_Page checkpointTestPage;
	Addissue_Pages addissuePage;
	KeyCloack_Pages keycloackPages;
	Home_Pages homepage;
	String pathTemp = "";
	public WebDriverWait w;
	private String testCaseName = "";

	public SmokeTest() {
	}

	@BeforeClass
	public void beforeConfig() {
		try {
			appLogin = new LoginApp();
			keycloackPages = new KeyCloack_Pages();
			testcasesPages = new Testcases_Pages();
			testrunPages = new Testrun_Pages();
			homepage = new Home_Pages();
			testrunoverviewpage = new Testrunoverview_Pages();
		} catch (Exception e) {
			Assert.fail("Testcase is failed" + e.getMessage());
		}
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception { // ITestResult result
		Helpers.testCaseResult(result);
	}

	@Test(enabled=false)
//	(priority=1, enabled=false)
	public void createSmokeuser() {
		try {
			DriverLaunch.log = DriverLaunch.reports.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			DriverLaunch.log.getStartedTime();
			appLogin.loginAdmin();
			Helpers.navigateUrl(DriverLaunch.keycloackurl);
			keycloackPages.createUser("smoke1");
			Helpers.navigateUrl(DriverLaunch.prop.getProperty("appurl"));
			appLogin.logout();
			Thread.sleep(5000);
			appLogin.loginUser("smoke1");
//			Helpers.verifyText(HomePage.welcomeheader, "Welcome smoke1");
			appLogin.logout();
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void createFolder(){
		try{
			testCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			DriverLaunch.log = DriverLaunch.reports.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			DriverLaunch.log.getStartedTime();
			appLogin.loginUser("smoke1");
			homepage.go2Testcases();
			testcasesPages.createNewFolder("01smokefolder");
//			testcasesPages.deleteFolder("01smokefolder");
			appLogin.logout();
		}
		catch(Exception e){
			DriverLaunch.log.log(LogStatus.FAIL, "Error occured during execution of test case: " + testCaseName + " " + e.getMessage());
			Assert.fail();
		}
	}
	
	@Test
//	(priority=2, enabled=false)
	public void createTestCase(){
		try{
			DriverLaunch.log = DriverLaunch.reports.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			DriverLaunch.log.getStartedTime();
			appLogin.loginUser("smoke1");
			testcasesPages.createNewTestcasewithPage("smoketestcase");
			appLogin.logout();
		}
		catch(Exception e){
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
			Assert.fail();
		}
	}

	@Test(enabled=false)
//	(priority=3, enabled=false)
	public void createTestrun(){
		try{
			DriverLaunch.log = DriverLaunch.reports.startTest(Thread.currentThread().getStackTrace()[1].getMethodName());
			DriverLaunch.log.getStartedTime();
			appLogin.loginUser("smoke1");
			homepage.go2Testcases();
			testrunPages.createTestrun();
			Helpers.verifyText(testrunoverviewpage.txt_header, "Test Run Overview");
			Thread.sleep(5000);
			appLogin.logout();
		}
		catch(Exception e){
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
			Assert.fail();
		}
	}
}
