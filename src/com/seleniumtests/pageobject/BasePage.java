/**
 * Author: Laxmi Somni
 */
package com.seleniumtests.pageobject;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
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
	public JavascriptExecutor jse;

	public String getPageURL(WebDriver driver){
		driver.manage().timeouts().pageLoadTimeout(2, TimeUnit.SECONDS);
		return driver.getCurrentUrl();
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

	}

}