package com.demo.sotiAppiumDemo;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

/**
 * Created by Sandeep on 4/28/2016.
 */
public class ExistingUserPage extends BasePage {
    private By existingUser;

    public ExistingUserPage(AppiumDriver driver) {
        super(driver);

        existingUser = By.xpath("//android.widget.TextView[@text='Existing user? Log in']");
    }

    @Override
    protected By getUniqueElement() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return By.xpath("//android.widget.TextView[@text='Existing user? Log in']");
    }

    public SignInPage clickExistingUser() {
        driver.findElement(existingUser).click();

        return new SignInPage(driver);
    }
}
