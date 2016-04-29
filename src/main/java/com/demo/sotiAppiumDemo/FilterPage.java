package com.demo.sotiAppiumDemo;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by Sandeep on 4/29/2016.
 */

public class FilterPage extends BasePage {
    private By ramFilter;
    private By twoGBRam;
    private By applyFilter;

    public FilterPage(AppiumDriver driver) {
        super(driver);

        ramFilter = By.xpath("//com.flipkart.android:id/filter_button[@text='Ram']");
        twoGBRam = By.xpath("//com.flipkart.android:id/text[@text='2 GB (2 results)']");
        applyFilter = By.id("com.flipkart.android:id/apply_filters");
    }

    @Override
    protected By getUniqueElement() {
        return By.xpath("//com.flipkart.android:id/filter_button[@text='Sub-category']");
    }

    public void applyRamFilter() {
        driver.findElement(ramFilter).click();

        // select the value for 2GB
        driver.findElement(twoGBRam).click();

        driver.findElement(applyFilter).click();

        // return to ResultsPage
    }
}
