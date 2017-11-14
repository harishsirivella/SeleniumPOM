package assure.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assure.initiator.DriverLaunch;

public class PrepareManualTesting_Pages {

	
	@FindBy(xpath = "//button[contains(.,'Start Testing')]")
	public WebElement btn_StartTesting;
	
	public PrepareManualTesting_Pages()
	{
		PageFactory.initElements(DriverLaunch.driver, this);
	}
}
