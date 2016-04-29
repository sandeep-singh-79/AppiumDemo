package com.demo.sotiAppiumDemo;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by Sandeep on 4/29/2016.
 */

public class ResultsPage extends BasePage {
    private By btnFilter;

    public ResultsPage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    protected By getUniqueElement() {
        btnFilter = By.id("com.flipkart.android:id/filter_button");

        driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"))
                .click();

        return btnFilter;
    }

    public void clickFilter() {
        driver.findElement(btnFilter).click();

    }
}
