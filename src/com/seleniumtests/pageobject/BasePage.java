/**
 * Author: Laxmi Somni
 */
package com.seleniumtests.pageobject;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumtests.support.Helper;


public class BasePage {

	protected WebDriver driver;
	protected AppiumDriver appiumDriver;
	protected WebDriverWait myWait;
	public Logger loggerPageObjectLevel;
	public JavascriptExecutor jse;


	public BasePage() {

		loggerPageObjectLevel = Logger.getLogger(this.getClass());
		Logger logger = Logger.getLogger("<ClassName>");
		PropertyConfigurator.configure("Log4j.properties");
		logger.debug("TESTTSTSTSTSTTSTST");

	}


	public String getPageURL(WebDriver driver){
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		return driver.getCurrentUrl();
	}

	public void getRentPage(WebDriver driver){
		driver.get(Helper.BaseURL+"/huur/");
		driver.manage().window().maximize();
	}



	public String getPageTitle(WebDriver driver) {
		return driver
				.getTitle();

	}

	public WebDriver getWebDriver(){
		return driver;
	}

	public void _waitUntil(final WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		loggerPageObjectLevel.debug("TESTS");
		loggerPageObjectLevel.info("Browser Opened");

	}


//	Logger logger=Logger.getLogger("BasePage");
//	final  Logger logger1 = Logger.getLogger(BasePage.class);
//	logg

//	logger1.debug()
//
//	// configure log4j properties file
//	BasicConfigurator.configure();
//       PropertyConfigurator.configure("Log4j.properties");
//       logger
}