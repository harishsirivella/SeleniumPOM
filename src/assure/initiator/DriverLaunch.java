package assure.initiator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.DBReporter.Config;

public class DriverLaunch {

	public static WebDriver driver;
	public static FileInputStream fs;
	public static Properties prop;
	public static ExtentReports reports;
	public static ExtentTest log;
	public static String filePath = "";
	public static String projpath = System.getProperty("user.dir");
	public static String path = projpath + "\\screenshots";
	public static WebDriver wbdv=null;
	public static String testpageurl = "";
	public static String keycloackurl = "";

	@Parameters("browser")
	@BeforeSuite 
	public void configurations(String browser) throws IOException {
		System.setProperty("webdriver.gecko.driver", projpath + "\\main\\resources\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", projpath + "\\main\\resources\\chromedriver.exe");
		if (browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else if (browser.equalsIgnoreCase("chrome")){
			driver = new ChromeDriver();
			DriverLaunch.driver.manage().window().maximize();
		}
		else
			driver = new InternetExplorerDriver();
		fs = new FileInputStream(projpath + "\\src\\assure\\resources\\CONFIG.properties");
		prop = new Properties();
		prop.load(fs);
		 testpageurl = DriverLaunch.prop.getProperty("defaulturl");
		 keycloackurl= DriverLaunch.prop.getProperty("keycloackurl");
		System.out.println("project path: " + System.getProperty("user.dir"));
		filePath = System.getProperty("user.dir") + "\\screenshots";
		reports = new ExtentReports("DequeRegression.html", true);
		reports.loadConfig(new File(projpath + "\\src\\assure\\resources\\extent-config.xml"));
	}

	@AfterSuite
	public void connectionClose() {
		reports.flush();
		driver.quit();
	}

}
