package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@SuppressWarnings("unused")
	private WebDriver driver ;
	
	@FindBy (xpath = "(//a[@class='cb-hm-mnu-itm'])[1]")
	private WebElement livescore ;
	
	@FindBy (xpath = "//a[text()='Rankings']")
	private WebElement rankings ;
	
    public HomePage (WebDriver driver) {
		
		PageFactory.initElements(driver , this);
		
		this.driver = driver ;

}
    public void ClickOnLivescore() {
    	livescore.click();
    }
    
    public void ClickOnRankings() {
    	rankings.click();
    }
}