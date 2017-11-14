package assure.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import assure.initiator.DriverLaunch;
import assure.resuables.Helpers;

public class Testrun_Pages {

	@FindBy(xpath = "//input[@id='fields[release]']")
	public static WebElement inp_release;
	
	@FindBy(xpath = "//input[@id='fields[environment]']")
	public static WebElement inp_environment;
	
	@FindBy(xpath = "//input[@id='fields[platform]']")
	public static WebElement inp_platform;
	
	@FindBy(xpath = "//input[@id='fields[assistive-technology]']")
	public static WebElement inp_at;
	
	@FindBy(xpath ="html/body/div[3]/div[2]/div/div/div[2]/form/div[1]/p[2]/button") 
			// "//button[@id='assign-self']")
	public static WebElement lnk_assign2me;
	
	@FindBy(xpath = "//input[@value='Create Test Run']")
	public static WebElement btn_setup_createtestrun;
	
	public Testrun_Pages(){
		PageFactory.initElements(DriverLaunch.driver, this);
	}
	
	public void createTestrun(){
		try {
			DriverLaunch.log.log(LogStatus.INFO, "Creating a new testrun");
			Testcases_Pages.createtestrunButton.click();
			Helpers.click(lnk_assign2me);
			Helpers.click(btn_setup_createtestrun);
			DriverLaunch.log.log(LogStatus.PASS, "Testrun is created");
			Thread.sleep(3000);
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}
	
}
