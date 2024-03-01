package pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class bikesobjects extends Basepage {
	
	public bikesobjects(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//*[@id=\"headerNewNavWrap\"]/nav/div/ul/li[3]/a")
	WebElement newbikeshover;
	
	@FindBy(xpath="//span[@onclick=\"goToUrl('/upcoming-bikes')\"]")
	WebElement upcoming;
	
	@FindBy(id="makeId")
	WebElement Honda;
	
	@FindBy(xpath="//h1[@class='mt-0 pt-2 pull-left zm-cmn-colorBlack']")
	WebElement hondatext;
	
	@FindBy(xpath="//table[@class='tbl bdr fnt-12 pl-15 pr-15 mb-15']/tbody/tr/td[1]")
	List<WebElement> name;
	
	@FindBy(xpath="//tr[@class=\"ml-15 \"]/child::td[2]")
	List<WebElement> price;
	
	@FindBy(xpath="//td[3]")
	List<WebElement> date;
	
	@FindBy(xpath="//span[contains(text(),'...Read More')]")
	WebElement readmore;
	
	@FindBy(xpath="//tr[@class=\"ml-15 \"][10]")
	WebElement scroll;
	
	
	//Actions
		public void reachupcomingbikes() {
			Actions act = new Actions(driver);
			act.moveToElement(newbikeshover).perform();
			upcoming.click();
			Select s = new Select(Honda);
			s.selectByVisibleText("Honda");
			readmore.click();
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].scrollIntoView();", scroll);
		}
		public boolean checkname() {
			String v = hondatext.getText();
			boolean res;
			if(v.equals("Honda Upcoming Bikes in India")) {
				return res = true;
			}
			else
				return res=false;
		}
		
		public void datalist() {
			List<WebElement> newname = new ArrayList<WebElement>();
			List<WebElement> newdate = new ArrayList<WebElement>();
			List<WebElement> newprice = new ArrayList<WebElement>();
			for(int i=0;i<10;i++) {
				String priceT =price.get(i).getText();
				String pricedigits = priceT.split(" ")[1].replace(",", "");;
				  double priceabs = Double.parseDouble(pricedigits);
				//String pricedigits = priceT.replaceAll("\\D","");
				//Float digiprice= Float.parseFloat(pricedigits);
				if(priceabs<4.0 || priceabs==79000) {
					newprice.add(price.get(i));
					newname.add(name.get(i));
					newdate.add(date.get(i));
				}
			}
			
			
			//System.out.println(price.size());
			//System.out.println(name.size());
			//System.out.println(newname.size());
			//System.out.println(newprice.size());
			//System.out.println(newdate.size());
			
			for(int i=0;i<6;i++) {
				System.out.println(newname.get(i).getText()+" "+newprice.get(i).getText()+" "+newdate.get(i).getText());
				System.out.println();
			}
			
			
			
		}
	
	
}
