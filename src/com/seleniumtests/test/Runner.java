/**
 *
 */
package com.seleniumtests.test;

import com.seleniumtests.listner.ExtentCucumberFormatter;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Laxmi.Somni
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
//		plugin = {"com.seleniumtests.listner.ExtentCucumberFormatter"},
		features = {"src/com/seleniumtests/resources"}
		,format ={"pretty", "html:target/cucumber-html-report"}
		,glue={"com.seleniumtests.test"}
		,tags = {"@Androidcalci"}

		)
public class Runner {

	@BeforeClass
	public static void setup() {
		// Initiates the extent report and generates the output in the output/Run_<unique timestamp>/report.html file by default.
		ExtentCucumberFormatter.initiateExtentCucumberFormatter();
		// Loads the extent config xml to customize on the report.
		ExtentCucumberFormatter.loadConfig(new File("src/com/seleniumtests/resources/extent-config.xml"));

		// User can add the system information as follows
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Firefox");
		ExtentCucumberFormatter.addSystemInfo("Browser version", "v31.0");
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v2.53.0");

		// Also you can add system information using a hash map
		Map systemInfo = new HashMap();
		systemInfo.put("Cucumber version", "v1.2.3");
		systemInfo.put("Extent Cucumber Reporter version", "v1.1.1");
		ExtentCucumberFormatter.addSystemInfo(systemInfo);
	}

}
