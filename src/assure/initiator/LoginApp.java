package assure.initiator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import assure.resuables.Helpers;

public class LoginApp {
	// public static Object appLogin;

	@FindBy(xpath = "//*[@id='email']")
	public WebElement username; // driver.findElement(By.locator());

	@FindBy(xpath = "//*[@id='login-email-section']/form/button")
	public WebElement userNext;

	@FindBy(xpath = "//*[@id='password-field']")
	public WebElement password;

	@FindBy(xpath = "//*[@id='login-password-section']/form/button")
	public WebElement signInButton;

	@FindBy(xpath = "//span[@aria-label='Account Actions']")
	public WebElement accountLogoutIcon;

	@FindBy(xpath = "//a[contains(.,'Log Out')]")
	public WebElement userLogout;

	public LoginApp() {
		PageFactory.initElements(DriverLaunch.driver, this);
	}

	// (String uname, String pword)
	public void loginUser(String uname) throws InterruptedException {
		try {
		
			DriverLaunch.driver.get(DriverLaunch.prop.getProperty("appurl"));
			username.clear();
			username.sendKeys(uname);
			userNext.click();
			password.clear();
			password.sendKeys(DriverLaunch.prop.getProperty("passwordinput"));
			signInButton.click();
			DriverLaunch.log.log(LogStatus.PASS, "Login " + uname + "is success");
			Helpers.pageTitle("Home - WorldSpace Assure");
			Thread.sleep(3000);
		} catch (Exception e) {
			// throw(e);
//			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
			Assert.fail(e.getMessage());
		}
	}

	public void loginAdmin() throws InterruptedException {
		try {
			DriverLaunch.driver.manage().window().maximize();
			DriverLaunch.driver.get(DriverLaunch.prop.getProperty("appurl"));
			username.clear();
			username.sendKeys(DriverLaunch.prop.getProperty("useradmin"));
			userNext.click();
			password.clear();
			password.sendKeys(DriverLaunch.prop.getProperty("adminpassword"));
			signInButton.click();
			DriverLaunch.log.log(LogStatus.PASS, "Login Admin is success");
			Helpers.pageTitle("Home - WorldSpace Assure");
		} catch (Exception e) {
			// throw(e);
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}

	public void logout() throws Exception {
		try {
			Thread.sleep(7000);
			accountLogoutIcon.click();
			userLogout.click();
			DriverLaunch.log.log(LogStatus.PASS, "Logout is success");
			Helpers.pageTitle("Sign in to Deque");
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, e.getMessage());
		}
	}

}
