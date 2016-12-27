package com.seleniumtests.core;
/* Laxmi Somni 2016 */

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.seleniumtests.support.Helper;


public class SelTestCase {

	protected WebDriver driver;
	protected AppiumDriver appiumDriver;
	public SoftAssert softAssert;
	protected ScreenRecorder src;
	DesiredCapabilities capabilities;
	
	public ExtentReports extent;
	public ExtentTest extentTest;

	@BeforeSuite
	@Parameters("browser")
	public void initalisation(@Optional("FF") String browser) throws IOException, AWTException {

		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver.exe");
			driver = new ChromeDriver();

		} else if(browser.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("IE")){
			driver= new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("Cloud")){
			/*Connecting to BrowserStack*/
			 capabilities = new DesiredCapabilities();
			capabilities.setCapability("browserName", "android");
			capabilities.setCapability("platform", "ANDROID");
			capabilities.setCapability("device", "Google Nexus 7");
			capabilities.setCapability("browserstack.debug", "true");

			driver = new RemoteWebDriver(
					//TODO Note: Kindly replace below URL with the your company/team's Browserstack account key.
					new URL("http://laxmi15:xxxxxxxxxxxxxx@hub.browserstack.com/wd/hub"),
					capabilities
					);

		} else if (browser.equalsIgnoreCase("android")) {
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("appium-version", "1.0");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "6.0.1");
			capabilities.setCapability("deviceName", "ZY223GS7ZP");
			capabilities.setCapability("appPackage", "com.google.android.calculator");
			capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
			appiumDriver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else if(browser.equalsIgnoreCase("saucelab-android")) {
			final String USERNAME = "atest";
			final String ACCESS_KEY = "c228a419-62f0- 40a6-8f7a- 7170fb84b31f";
			final String sauce_URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("appium-version", "1.0");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("platformVersion", "6.0.1");
			capabilities.setCapability("appiumVersion", "1.6.3");
//			capabilities.setCapability("deviceName", "ZY223GS7ZP");
			capabilities.setCapability("appPackage", "com.google.android.calculator");
			capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
			appiumDriver = new AndroidDriver<WebElement> (new URL(sauce_URL), capabilities);
			appiumDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);


		}

		softAssert = new SoftAssert();
		src=Helper.screenRecorderSetup();
		src.start();

	}

	@AfterSuite
	public void closeBrowser() throws IOException {
		src.stop();
		driver.close();
		driver.quit();
		softAssert.assertAll();
	}
	
	
	//Extent Report Test
	 @BeforeClass
	 public void M1(){
	  driver = new FirefoxDriver();
	 }
}
