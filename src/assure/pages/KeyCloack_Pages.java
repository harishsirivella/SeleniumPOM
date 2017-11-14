package assure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.LogStatus;
import assure.initiator.DriverLaunch;
import assure.resuables.Helpers;

public class KeyCloack_Pages {

	// Users link
	@FindBy(xpath = "//a[@href='#/realms/assuredev/users']")
	public static WebElement lnk_userspage;

	// Search field
	@FindBy(xpath = "//div[@class='input-group']/input")
	public static WebElement inp_user_search;

	// search button
	@FindBy(xpath = "//i[@id='userSearch']")
	public static WebElement userSearch;

	@FindBy(xpath = "//a[@id='createUser']")
	public static WebElement lnk_adduser;

	@FindBy(xpath = "//input[@id='username']")
	public static WebElement inp_username;

	@FindBy(xpath = "//*[@id='password']")
	public static WebElement inp_password;

	@FindBy(xpath = "//button[contains(text(),'Save')]")
	public static WebElement btn_save_createuser;

	@FindBy(xpath = "//a[contains(text(),'Credentials')]")
	public static WebElement lnk_credentials_tab;
	
	@FindBy(xpath = "//input[@id='confirmPassword']")
	public static WebElement inp_confirmpassword;

	@FindBy(xpath = "//span[contains(text(),'ON')]")
	public static WebElement btn_temporary;
	
	@FindBy(xpath = "//button[@type='submit']")
	public static WebElement btn_resetPassword;

	@FindBy(xpath = "//button[contains(text(),'Change password')]")
	public static WebElement btn_passwordconfirm;

	@FindBy(xpath = "//td[contains(.,'Edit')]")
	public static WebElement btn_edituser;

	public KeyCloack_Pages() {
		PageFactory.initElements(DriverLaunch.driver, this);
	}

	
	public void createUser(String username) {
		try {
			Helpers.click(lnk_userspage);
			Helpers.input(inp_user_search, username);
			Helpers.click(userSearch);
			Thread.sleep(3000);
			boolean existingUser = DriverLaunch.driver.findElement(By.cssSelector("body")).getText().contains(username);
			Thread.sleep(2000);
			if (!existingUser){
				Helpers.click(lnk_adduser);
				Helpers.input(inp_username, username);
				Helpers.click(btn_save_createuser);
			} else {
				DriverLaunch.log.log(LogStatus.INFO, username + " is exists, resetting the password");
				Helpers.click(btn_edituser);
			}
				Helpers.click(lnk_credentials_tab);
				Helpers.input(inp_password, DriverLaunch.prop.getProperty("passwordinput"));
				Helpers.input(inp_confirmpassword, DriverLaunch.prop.getProperty("passwordinput"));
				Helpers.click(btn_temporary);
				Helpers.click(btn_resetPassword);
				Helpers.click(btn_passwordconfirm);
			DriverLaunch.log.log(LogStatus.PASS, "New username is  :: " + username);
		} catch (Exception e) {
			DriverLaunch.log.log(LogStatus.FAIL, "Failed to create new user" + username+ " :: "+ e.getMessage());
		}
	}

}
