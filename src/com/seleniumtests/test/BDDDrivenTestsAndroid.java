/**
 * (c) Laxmi Somni
 */
package com.seleniumtests.test;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.pageobject.AndroidCalculator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * @author Laxmi.Somni
 *
 */
public class BDDDrivenTestsAndroid extends SelTestCase {

	AndroidCalculator androidCalculator;


//	@Before("@calci")
//	public void beforeScenario() throws IOException, AWTException {
//		initalisation("Android");
//	}


	@Given("^I have opened the native calculator$")
	public void iHaveOpenedTheCalculator() throws Throwable {

		initalisation("android");//or android
	}


	@When("^I enter \"([^\"]*)\"$")
	public void iEnter(final String sNumber) {

		androidCalculator = new AndroidCalculator(appiumDriver);
		androidCalculator.enterNumber(sNumber);
	}

	@And("^I select addition operation$")
	public void iSelectAdditionOperation() {
		androidCalculator.addOperation();
	}

	@And("^I hit equals button$")
	public void iHitEqualsButton() {
		androidCalculator.eqOperation();
	}

	@Then("^I should be presented with \"([^\"]*)\"$")
	public void iShouldBePresentedWith(final String sResult)  {
		Assert.assertTrue("ERROR: Result didn't match with expected result",
				sResult.equalsIgnoreCase(androidCalculator.getResult()));
		logger.info("::Result assertion performed::");
	}
}
