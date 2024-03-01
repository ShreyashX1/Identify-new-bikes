package pageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class errorobjects extends Basepage{
	
	public errorobjects(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//img[@alt='ZigWheels - New Cars, Used Cars, Bikes Prices, News, Reviews, QnA']")
	WebElement backtomain;
	
	@FindBy(id="forum_login_title_lg")
	WebElement login;
	
	@FindBy(xpath="//*[@id=\"myModal3-modal-content\"]/div[1]/div/div[3]/div[6]/div")
	WebElement google;
	
	@FindBy(id = "identifierId")
    WebElement email;
	
	@FindBy(xpath = "//span[contains(text(),'Next')]")
	WebElement nextbtn;
	
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae' and contains(text(),'Enter a valid email or phone number')]")
	WebElement error;
	
	//Actions
	public void bigimg() {
		backtomain.click();
	}
	
	public void loginclick() {
		login.click();
	}
	
	public void googleclick() {
		google.click();
	}
	
	//public void textwrite() {
		//textfield.sendKeys("abcd@gmail.com");
	//}
	
	
	public void signin_With_Email() {
		 try {
		        // Get all window handles
		        Set<String> windows = driver.getWindowHandles();
		        List <String> windowslist = new ArrayList(windows);
		        String parent = windowslist.get(0);
		        String child = windowslist.get(1);
		        driver.switchTo().window(child);
		        email.sendKeys("abd@abc");
		       } 
		 catch (Exception e ) {
		 e.printStackTrace();
		    }
	 }
	public void clicknxtbtn() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
		nextbtn.click();
	}

	public String geterrormsg() {
		String er=error.getText();
		System.out.println(er);
		return er;
	}

}
