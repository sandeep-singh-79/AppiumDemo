package com.demo.sotiAppiumDemo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Sandeep on 4/28/2016.
 */
public class PermissionDialogPage extends BasePage {
    private By allowBtn;

    public PermissionDialogPage(AppiumDriver driver) {
        super(driver);

        allowBtn = By.id("com.android.packageinstaller:id/permission_allow_button");
    }

    @Override
    protected By getUniqueElement() {
        return By.id("com.android.packageinstaller:id/permission_allow_button");
    }

    public ExistingUserPage allow() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(allowBtn));
        //System.out.println(btnAllow.toString());

        //Thread.sleep(2000);
        ((MobileElement) driver.findElement(allowBtn)).tap(1, 1);
        //Thread.sleep(2000);

        return new ExistingUserPage(driver);
    }
}
