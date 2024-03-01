package stepDefinations;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import cucumberBase.CucmberBase;
import io.cucumber.java.BeforeAll;

import io.cucumber.java.AfterAll;
 
public class Hooks {
	public static WebDriver driver;
	 static Properties p;
	 
	@BeforeAll
   public static void setup() throws IOException
   {
	
	driver=CucmberBase.initilizeBrowser();	    	
   	p=CucmberBase.getProperties();
   	driver.get(p.getProperty("appUrl"));
   	driver.manage().window().maximize(); 
   	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
   	
   	
   	
   	}
	
	
	@AfterAll
	public static void Close() throws IOException {
		
		driver.quit();
	}
}