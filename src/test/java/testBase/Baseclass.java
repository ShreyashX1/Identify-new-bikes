package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
	public static WebDriver driver;
	public Logger logger;
	Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void openUrl(String os , String browser) throws IOException{

		logger=LogManager.getLogger(this.getClass());
		
		FileReader file = new FileReader(".//src/test/resources/properties.config");
		p = new Properties();
		p.load(file);
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities capabalities = new DesiredCapabilities();
			//os
			if(os.equalsIgnoreCase("windows")) {
				capabalities.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("mac")) {
				capabalities.setPlatform(Platform.MAC);
			}
			else {
				System.out.println("no matching os .....");
				return;
			}
			//browser
			if(browser.equalsIgnoreCase("chrome")) {
				capabalities.setBrowserName("chrome");
			}
			else if(browser.equalsIgnoreCase("edge")) {
				capabalities.setBrowserName("MicrosoftEdge");
			}
			else {
				System.out.println("no matching browser .....");
				return;
			}
 
			 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);
		}
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			
			ChromeOptions option = new ChromeOptions();
			EdgeOptions options = new EdgeOptions();
			option.addArguments("--disable-blink-features=AutomationControlled");
			option.addArguments("--disable-notifications");
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--disable-notifications");
			
			if(browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver(option);
				logger.info("Chrome browser opened successfully");
				
			}
			else if(browser.equalsIgnoreCase("edge")){
				driver = new EdgeDriver(options);
				logger.info("Edge browser opened successfully");
			}
			else {
				System.out.println("no matching browser......");
				logger.info("no matching browser......");
				return;
			}
		}
		
	
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	
	@AfterClass
	public void closeBowser() {
		 driver.quit();
	 }
	
	
	public String captureScreen(String tname) {
				
				String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
				TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
				File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
				
				String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
				File targetFile=new File(targetFilePath);
				
				sourceFile.renameTo(targetFile);
				
				return targetFilePath;
			}
}
