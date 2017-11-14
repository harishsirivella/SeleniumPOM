package assure.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import assure.initiator.DriverLaunch;
import assure.resuables.Helpers;

public class ViewIssue_Page extends Helpers{

	@FindBy(xpath = "html/body/div[3]/div[2]/div/div[5]/div[2]/div[1]/h2")
	public static WebElement misc_issuename;
	
	@FindBy(xpath = "html/body/div[3]/div[2]/div/div[5]/div[2]/div[2]/div[1]/dl/dd[1]")
	public static WebElement createdby;
	
	@FindBy(xpath = "//dd[2]/a")
	public static WebElement checkpoint;
	
	@FindBy(className="description-text")
	public static WebElement description_text;
	
	@FindBy(xpath = "html/body/div[3]/div[2]/div/div[5]/div[2]/div[2]/div[1]/dl/dd[3]")
	public static WebElement issueType;
	
	@FindBy(xpath = "html/body/div[3]/div[2]/div/div[5]/div[2]/div[2]/div[1]/dl/dd[4]")
	public static WebElement impact;
	
	@FindBy(xpath = "html/body/div[3]/div[2]/div/div[5]/div[2]/div[2]/div[1]/dl/dd[5]")
	public static WebElement method;
	
	@FindBy(xpath ="html/body/div[3]/div[2]/div/div[5]/div[2]/div[2]/div[1]/dl/dd[6]")
	public static WebElement testRunStarted;
	
	@FindBy(xpath = "html/body/div[3]/div[2]/div/div[5]/div[2]/div[2]/div[1]/dl/dd[7]")
	public static WebElement testRunCompleted;
	
	@FindBy(xpath = "html/body/div[3]/div[2]/div/div[5]/div[2]/div[2]/div[1]/ul/li[2]/div[2]/div/div[1]/input")
	public static WebElement url;
	
	@FindBy(xpath="html/body/div[3]/div[2]/div/div[5]/div[2]/div[2]/div[1]/ul/li[1]/div[2]/a")
	public static WebElement page_Comp_Name;
	
	
	public ViewIssue_Page() {
		PageFactory.initElements(DriverLaunch.driver, this);
	}
	
}
