package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Pojo {
	
	public static WebDriver openChromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "F:\\Arvind ST\\Automation\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver ;
	}
	
    public static WebDriver openFirefoxBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "F:\\Arvind ST\\Automation\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver ;
	}
    
//    public static WebDriver openEdgeBrowser() {
//		
//		System.setProperty("webdriver.msedge.driver", "F:\\Arvind ST\\Automation\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
//		return driver ;
//	}

}
