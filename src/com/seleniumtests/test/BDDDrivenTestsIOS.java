/**
 * (c) Laxmi Somni
 */
package com.seleniumtests.test;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.pageobject.AndroidCalculator;
import com.seleniumtests.pageobject.IOSCalculator;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * @author Laxmi.Somni
 *
 */
public class BDDDrivenTestsIOS extends SelTestCase {

	IOSCalculator iosCalculator;


//	@Before("@calci")
//	public void beforeScenario() throws IOException, AWTException {
//		initalisation("Android");
//	}


	@Given("^I have opened the calculator$")
	public void iHaveOpenedTheCalculator() throws Throwable {

		initalisation("ios");
		iosCalculator = new IOSCalculator(appiumDriver);
	}


	@And("^I hit Compute Sum button$")
	public void iHitComputeSumButton() {
		iosCalculator.equalOperation();
	}


	@When("^I enter \"([^\"]*)\" as \"([^\"]*)\"$")
	public void selectControlAndEnterValue(final String control, final String sValue)  {
		iosCalculator.enterNumber(control, sValue);
	}

	@Then("^I should be displayed result as \"([^\"]*)\"$")
	public void verifyOutput(final String sResult)  {
		Assert.assertTrue("ERROR: Result didn't match with expected result",
				sResult.equalsIgnoreCase(iosCalculator.getResult()));
	}
}
