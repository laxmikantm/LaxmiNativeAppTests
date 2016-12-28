package com.seleniumtests.pageobject;

import cucumber.api.java.cs.A;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

/**
 * Created by laxmi.somni on 26/12/2016.
 */
public class Calculator extends BasePage {

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_1")
    private MobileElement one;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_2")
    private MobileElement two;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_3")
    private MobileElement three;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_4")
    private MobileElement four;

    @AndroidFindBy (id = "com.google.android.calculator:id/digit_5")
    private  MobileElement five;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_6")
    private MobileElement six;

    @AndroidFindBy(id= "com.google.android.calculator:id/digit_7")
    private MobileElement seven;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_8")
    private MobileElement eight;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_9")
    private MobileElement nine;

    @AndroidFindBy(id = "com.google.android.calculator:id/digit_0")
    private MobileElement zero;

    @AndroidFindBy(id = "com.google.android.calculator:id/op_add")
    private MobileElement addButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/eq")
    private MobileElement equalButton;

    @AndroidFindBy(id = "com.google.android.calculator:id/formula")
    private MobileElement acceptInput;

    @AndroidFindBy(id = "com.google.android.calculator:id/result")
    private MobileElement result;

    public Calculator(AppiumDriver appiumDriver) {
        loggerPageObjectLevel.debug("TESTS");
        loggerPageObjectLevel.info("Browser Opened");
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
        loggerPageObjectLevel.debug("TESTS");
        loggerPageObjectLevel.info("Browser Opened");
    }


    public void enterNumber(final String sNum) {
        acceptInput.sendKeys(sNum.trim());
    }

    public void addOperation() {
        addButton.click();
    }

    public void eqOperation() {
        equalButton.click();
    }

    public String getResult() {
        return result.getText();
    }
}
