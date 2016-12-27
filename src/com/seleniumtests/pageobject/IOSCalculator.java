package com.seleniumtests.pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by laxmi.somni on 28/12/2016.
 */
public class IOSCalculator {


    @iOSFindBy(accessibility = "IntegerA")
    private IOSElement ipOne;

    @iOSFindBy(accessibility = "IntegerB")
    private IOSElement ipTwo;

    @iOSFindBy(accessibility = "ComputeSumButton")
    private IOSElement computeSum;

    @iOSFindBy(accessibility = "Answer")
    private IOSElement result;


    public IOSCalculator(AppiumDriver appiumDriver)
    {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }


    public void enterNumber(final String control, final String input ) {

        final ControlType controlType = ControlType.valueOf(control.toUpperCase());

        switch (controlType) {
            case INTEGERA:
                ipOne.clear();
                ipOne.sendKeys(input);
                break;

            case INTEGERB:
                ipTwo.clear();
                ipTwo.sendKeys(input);
                break;

            default:
                throw new IllegalArgumentException("Error: Incorrect input control type.");
        }
    }


    public void equalOperation() {
        computeSum.click();
    }

    public String getResult() {
        return result.getText();
    }

    protected enum ControlType {
        INTEGERA,
        INTEGERB
    }

}
