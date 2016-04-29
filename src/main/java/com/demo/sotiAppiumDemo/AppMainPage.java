package com.demo.sotiAppiumDemo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Sandeep on 4/27/2016.
 */
public class AppMainPage extends BasePage {
    // the flipkart icon also acts as hamburger menu link
    private By hamburgerLink;
    private By mobiles;

    private By btnSecureYourAccTxtViewSkip;

    public AppMainPage(AppiumDriver driver) {
        super(driver);
        hamburgerLink = By.xpath("//android.widget.ImageButton[@index=0]");/* and @content-desc='Open Drawer'*/
        mobiles = By.xpath("//android.widget.TextView[@text='Mobiles']");

        // locator to bypass Secure your account text view
        btnSecureYourAccTxtViewSkip = By.id("com.flipkart.android:id/btn_skip");

        // this navigates past the 'Secure your account' text view
        driver.findElement(btnSecureYourAccTxtViewSkip).click();
    }

    @Override
    protected By getUniqueElement() {
        return By.id("com.flipkart.android:id/btn_skip");
    }

    public AppMainPage displayHamburgerMenu() {
        ((MobileElement) driver.findElement(hamburgerLink)).tap(1, 1);

        return this;
    }

    public MobilesPage mobilesClick() {
        wait.until(ExpectedConditions.presenceOfElementLocated(mobiles));
        ((MobileElement) driver.findElement(mobiles)).tap(1, 1);

        return new MobilesPage(driver);
    }
}
