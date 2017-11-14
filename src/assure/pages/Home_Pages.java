package assure.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import assure.initiator.DriverLaunch;
import assure.resuables.Helpers;


public class Home_Pages {

	public static String keycloackUrl = DriverLaunch.prop.getProperty("keycloackurl");
	
	@FindBy(xpath = "html/body/div[3]/div[2]/div/div[1]/h1")
	public static WebElement welcomeheader;
	
	// Top menu - Testcases
	@FindBy(xpath = "//a[contains(.,'Test Cases')]")
	public static WebElement testcasesmenu;
	
	//Admin Settings
	@FindBy(xpath = "html/body/div[3]/div[1]/div[1]/nav/ul/li[2]/a")
	public static WebElement adminsettings;
	
	//Home 
	@FindBy(xpath = "//nav/ul/li[1]/a")
	public static WebElement home;
	
	public Home_Pages() {
		PageFactory.initElements(DriverLaunch.driver, this);
	}

//	Navigate to Test cases page page
	public void go2Testcases() {
		try {
			DriverLaunch.log.log(LogStatus.INFO, "Navigating to Testcases page");
			testcasesmenu.click();
			Thread.sleep(2000);
			DriverLaunch.log.log(LogStatus.PASS, "Navigated to Test cases page");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
		
	}

	public static void go2AdminSettings() {
		try {
			DriverLaunch.log.log(LogStatus.INFO, "Navigating to Admin Settings page");
			Thread.sleep(2000);
			Helpers.click(Home_Pages.adminsettings);
			Helpers.pageTitle("Admin Settings - WorldSpace Assure");
			DriverLaunch.log.log(LogStatus.PASS, "Navigated to Admin settings page");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
		
	}
	
//	Navigate to Home page
	public static void go2Home() {
		try {
			DriverLaunch.log.log(LogStatus.INFO, "Navigating to Home page");
			Thread.sleep(2000);
			Helpers.click(Home_Pages.home);
			DriverLaunch.log.log(LogStatus.PASS, "Navigated to Home page");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
}
