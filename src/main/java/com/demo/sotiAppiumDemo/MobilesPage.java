package com.demo.sotiAppiumDemo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * Created by Sandeep on 4/27/2016.
 */
public class MobilesPage extends BasePage {
    private By chkSamsung;
    private By btnFindMobile;


    public MobilesPage(AppiumDriver driver) {
        super(driver);

        btnFindMobile = By.xpath("//android.widget.Button[@text='Find the right Mobile']");
    }

    @Override
    protected By getUniqueElement() {
        chkSamsung = By.xpath("//android.widget.TextView[@text='Samsung']");

        driver.scrollToExact("Samsung");

        return chkSamsung;
    }


    public ResultsPage selectBrandAndSubmit() {
        // first scroll to the checkbox
        driver.scrollToExact("Samsung");

        ((MobileElement) driver.findElement(chkSamsung)).tap(1, 1);

        driver.findElement(btnFindMobile).click();

        return new ResultsPage(driver);
    }
}
