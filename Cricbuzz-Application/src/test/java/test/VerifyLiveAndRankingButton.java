package test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.Pojo;
import Utils.Utility;
import pom.HomePage;


public class VerifyLiveAndRankingButton extends Pojo {
	
	private WebDriver driver ;
	private HomePage homepage ;
	private SoftAssert softAssert ;
	private int testID ;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeTest
	@Parameters("browser")
	public void launchBrowser(String browser) {
		System.out.println("launchBrowser");
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		if(browser.equals("chrome"))
		{
			driver = openChromeBrowser() ;
		}
		
		if(browser.equals("firefox"))
		{
			driver = openFirefoxBrowser() ;
		}
		
//		if(browser.equals("edge"))
//		{
//			driver = openEdgeBrowser() ;
//		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void initializePomClasses() {
		homepage = new HomePage(driver);
		
	}
	
	@BeforeMethod
	public void getlaunchBrowser() {
		System.out.println("getlaunchBrowser");
		driver.get("http://www.cricbuzz.com/");
		softAssert = new SoftAssert();
	}
	
	
	@Test
	public void toVerifyLiveScoreButton() {
		System.out.println("toVerifyLiveScoreButton");
		testID = 101 ;
		homepage.ClickOnLivescore();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://www.cricbuzz.com/cricket-match/live-scores");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		softAssert.assertEquals(title, "T20 World Cup Live Cricket Score | Scorecard | Live Commentary | Cricbuzz.com");
		softAssert.assertAll();
	}
	
	@Test
	public void toVerifyRankingButton() {
		System.out.println("toVerifyRankingButton");
		testID = 102 ;
		homepage.ClickOnRankings();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals(url, "https://www.cricbuzz.com/cricket-stats/icc-rankings/men/batting");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		softAssert.assertEquals(title, "ICC Player Ranking | Men's Ranking | Top 100 Batsmen | Cricbuzz.com");
		softAssert.assertAll();
	}

	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		System.out.println("aftermethod");
		if(ITestResult.FAILURE == result.getStatus())
		{
		   Utility.saveScreenshot(driver, testID);
		}
	}
	
	@AfterClass
	public void closeBrowser() {
		System.out.println("closebrowser");
        homepage = null ;
	}
	
	@AfterTest
	public void closedBrowser() {
		System.out.println("closedBrowser");
		driver.quit();
		driver = null ;
		System.gc();
	}

}
