package Utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {
	
	public static void saveScreenshot (WebDriver driver , int testID ) throws IOException
	{
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest= new File("F:\\Arvind ST\\TestID " +timestamp()+".jpg");
		FileUtils.copyFile(scr, dest) ;
	}

	private static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
	}
}