package assure.resuables;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import assure.initiator.DriverLaunch;

public class Utilities {
	// public static WebDriver driver;
	// commonly used methods like click, drop down selection, enter text etc..,

	public static String projectpath = System.getProperty("user.dir")+ "\\screenshots\\";
	

	public static String captureScreenShot(String filePath, String screenshotName) {
		String temp = "";
	
		// TakesScreenshot driver = null;
		File src = ((TakesScreenshot) DriverLaunch.driver).getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("File path is: " + DriverLaunch.filePath);
			System.out.println("Testcase name:  " + screenshotName);
			FileUtils.copyFile(src, new File(projectpath + screenshotName + ".png"));
			temp = projectpath + screenshotName + ".png";
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return temp;
	}
	
	
}
