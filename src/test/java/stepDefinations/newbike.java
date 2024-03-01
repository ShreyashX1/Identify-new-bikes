package stepDefinations;

import java.io.IOException;

import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import cucumberBase.CucmberBase;
import io.cucumber.java.en.*;
import pageObject.bikesobjects;
import pageObject.carobjects;
import pageObject.errorobjects;


public class newbike {
	
	WebDriver driver;

	@Given("the user is on the zigwheels.com page")
	public void the_user_is_on_the_zigwheels_com_page() {
		bikesobjects obj1 = new bikesobjects(CucmberBase.getDriver());
		obj1.reachupcomingbikes();
		Assert.assertEquals(obj1.checkname(), true);
	}
	@Then("user filters out all upcoming honda bikes below 4lakhs and prints the list")
	public void user_filters_out_all_upcoming_honda_bikes_below_4lakhs_and_prints_the_list() {
		bikesobjects obj2 = new bikesobjects(CucmberBase.getDriver());
		obj2.datalist();
	}
	
	
	@Given("User moves to used cars section,retrieves prints on console")
	public void user_moves_to_used_cars_section_retrieves_prints_on_console() {
		carobjects obj1 = new carobjects(CucmberBase.getDriver());
		obj1.printchennaicars();
	}
	@Then("User prints all the used cars in excel file")
	public void user_prints_all_the_used_cars_in_excel_file() throws IOException {
		carobjects obj2 = new carobjects(CucmberBase.getDriver());
		obj2.printexcel();
	}
	
	@Given("User returns to main page")
	public void user_returns_to_main_page() {
		errorobjects obj1 = new errorobjects(CucmberBase.getDriver());
		obj1.bigimg();
	}
	@Then("User clicks on login button")
	public void user_clicks_on_login_button() {
		 errorobjects obj2 = new errorobjects(CucmberBase.getDriver());
		   obj2.loginclick();
	}
	@Then("User clicks on google button")
	public void user_clicks_on_google_button() {
		errorobjects obj3 = new errorobjects(CucmberBase.getDriver());
		obj3.googleclick();
	}
	@Then("User capture the error message")
	public void user_capture_the_error_message() {
		errorobjects obj4 = new errorobjects(CucmberBase.getDriver());
		obj4.signin_With_Email();
		obj4.clicknxtbtn();
		Assert.assertEquals(obj4.geterrormsg(), "Enter a valid email or phone number");
	}









	



}
