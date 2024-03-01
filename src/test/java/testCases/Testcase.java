package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObject.bikesobjects;
import pageObject.carobjects;
import pageObject.errorobjects;
import testBase.Baseclass;


@Listeners(utilities.ExtentReportManager.class)
public class Testcase extends Baseclass{		
		
		
		
		
		
		
		@Test(priority=1)
		void pagevalidation() {
			bikesobjects obj1 = new bikesobjects(driver);
			obj1.reachupcomingbikes();
			Assert.assertEquals(obj1.checkname(), true);
			
		}
		
		@Test(priority=2)
		void displaybikedata() {
			bikesobjects obj2 = new bikesobjects(driver);
			obj2.datalist();
			
		}
		
		@Test(priority=3)
		void displayusedcars() throws IOException {
			carobjects obj1 = new carobjects(driver);
			obj1.printchennaicars();
			
			
		}
		
		@Test(priority=4)
		void printcarsexcel() throws IOException {
			carobjects obj2 = new carobjects(driver);
			obj2.printexcel();
		}
		
		@Test(priority=5)
		void returntomainpage() {
			errorobjects obj1 = new errorobjects(driver);
			obj1.bigimg();
			
		}
		
		@Test(priority=6)
		void clickonlogin() {
		   errorobjects obj2 = new errorobjects(driver);
		   obj2.loginclick();
		}
		
		@Test(priority=7)
		void clickgoogle() {
			errorobjects obj3 = new errorobjects(driver);
			obj3.googleclick();
		}
		
		
		
		@Test(priority=8)
		void errormessage() {
			errorobjects obj4 = new errorobjects(driver);
			obj4.signin_With_Email();
			obj4.clicknxtbtn();
			Assert.assertEquals(obj4.geterrormsg(), "Enter a valid email or phone number");
		}
		
		
		
  
}
