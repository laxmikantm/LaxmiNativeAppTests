package com.seleniumtests.pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by laxmi.somni on 26/12/2016.
 */
public class AndroidCalculator extends BasePage {

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

    public AndroidCalculator(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);

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
