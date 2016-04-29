package com.demo.sotiAppiumDemo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

/**
 * Created by Sandeep on 4/28/2016.
 */
public class SignInPage extends BasePage {
    private By userMail, userPwd, btnLogin;

    public SignInPage(AppiumDriver driver) {
        super(driver);

        userMail = By.id("com.flipkart.android:id/mobile_login_signup_edit_text");
        userPwd = By.id("com.flipkart.android:id/etPass");
        btnLogin = By.id("com.flipkart.android:id/btn_mlogin");
    }

    @Override
    protected By getUniqueElement() {
        return By.id("com.flipkart.android:id/btn_mlogin");
    }

    public SignInPage enterCredentials(String email, String password) {
        enterText(email, (MobileElement) driver.findElement(userMail));
        enterText(password, (MobileElement) driver.findElement(userPwd));

        return this;
    }

    public AppMainPage submitLogin() {
        driver.findElement(btnLogin).click();

        return new AppMainPage(driver);
    }
}
