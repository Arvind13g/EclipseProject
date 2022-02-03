package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveScorePage {
	
	@SuppressWarnings("unused")
	private WebDriver driver ; 
	
	@FindBy (xpath = "//a[text()='Rankings']")
	private WebElement rankings ;
	
    public LiveScorePage (WebDriver driver) {
		
		PageFactory.initElements(driver , this);
		
		this.driver = driver ;

}
    public void ClickOnRanking() {
    	rankings.click();
    }
}