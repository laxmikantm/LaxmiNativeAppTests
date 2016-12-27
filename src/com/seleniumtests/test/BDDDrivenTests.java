/**
 * (c) Laxmi Somni
 */
package com.seleniumtests.test;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.pageobject.Calculator;
import com.seleniumtests.pageobject.HomePage;
import com.seleniumtests.pageobject.ResultsPage;
import com.seleniumtests.support.Helper;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.awt.*;
import java.io.IOException;

/**
 * @author Laxmi.Somni
 *
 */
public class BDDDrivenTests extends SelTestCase {

//	WebDriverExcercise webDriverExcercise;
	Calculator calculator;


//	@Before("@calci")
//	public void beforeScenario() throws IOException, AWTException {
//		initalisation("Android");
//	}

//    @And("^I am on the Funda Home Page$")
//	public void landingPage(){
//		webDriverExcercise = new WebDriverExcercise();
//		homePage = new HomePage(driver);
//		homePage.getRentPage(driver);
//
//	}

	@When("^I fill in  \"([^\"]*)\" in search box$")
	public void i_fill_in_search_Keyword(String sKeyWord) {


	}


	@Given("^I have opened the calculator$")
	public void iHaveOpenedTheCalculator() throws Throwable {

//		initalisation("android");//or android
	}


	@When("^I enter \"([^\"]*)\"$")
	public void iEnter(final String sNumber) {

//		webDriverExcercise = new WebDriverExcercise();
		calculator = new Calculator(appiumDriver);
		calculator.enterNumber(sNumber);
	}

	@And("^I select addition operation$")
	public void iSelectAdditionOperation() {
		calculator.addOperation();
	}

	@And("^I hit equals button$")
	public void iHitEqualsButton() {
		calculator.eqOperation();
	}

	@Then("^I should be presented with \"([^\"]*)\"$")
	public void iShouldBePresentedWith(final String sResult)  {
		Assert.assertTrue("ERROR: Result didn't match with expected result",
				sResult.equalsIgnoreCase(calculator.getResult()));
	}
}
