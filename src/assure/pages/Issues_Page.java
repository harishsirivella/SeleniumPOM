package assure.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import assure.initiator.DriverLaunch;

public class Issues_Page {

	
	@FindBy(xpath = "//a[contains(.,'View Issue')]")
	public static WebElement btn_viewIssue;
	
	public Issues_Page() {
		PageFactory.initElements(DriverLaunch.driver, this);
	}


}
