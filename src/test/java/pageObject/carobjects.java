package pageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utilities.apache;



public class carobjects extends Basepage{
	
	public carobjects(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//a[normalize-space()='Used Cars']")
	WebElement usedcarhover;
	
	@FindBy(xpath="//span[@onclick=\"goToUrl('/used-car/Chennai')\"]")
	WebElement chennai;
	
	@FindBy(xpath="//span[normalize-space()='Read More']")
	WebElement readmore2;
	
	@FindBy(xpath="//ul[@class=\"zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10\"]/li/label")
	List<WebElement> popularcars;
	
	@FindBy(xpath="//h1[@class='mt-0 pt-2 pull-left zm-cmn-colorBlack']")
	WebElement newscrol;
	
	//Actions
	
	public void printchennaicars() {
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("arguments[0].scrollIntoView();", newscrol);
		Actions act = new Actions(driver);
		act.moveToElement(usedcarhover).perform();
		chennai.click();
		readmore2.click();
		System.out.println("------LIST OF POPULAR CARS------");
		for(int i=0;i<9;i++) {
			System.out.println(popularcars.get(i).getText());
			System.out.println(" ");
		}
	}
	public void printexcel() throws IOException {
		for(int i=0;i<9;i++) {
			apache.Excelutilsheaders(popularcars);
		}
	}
}
