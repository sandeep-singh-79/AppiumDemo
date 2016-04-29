package com.demo.sotiAppiumDemo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * Created by Sandeep on 4/29/2016.
 */

public class ResultsPage extends BasePage {
    private By btnFilter;

    public ResultsPage(AppiumDriver driver) {
        super(driver);

        btnFilter = By.id("com.flipkart.android:id/filter_image");
    }

    @Override
    protected By getUniqueElement() {
        return By.xpath("//android.widget.TextView[@text='FILTERS']");
    }

    public FilterPage clickFilter() {
        ((MobileElement) driver.findElement(btnFilter)).tap(1, 1);

        return new FilterPage(driver);
    }
}
