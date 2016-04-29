package com.demo.sotiAppiumDemo.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by Sandeep on 4/27/2016.
 */

public abstract class BaseTest {

    protected static final String EMAIL = "leouragan@googlemail.com";
    protected static final String PASSWORD = "test1234";
    private static final String SELENIUM_HOST = "localhost";
    private static final int SELENIUM_PORT = 4723;
    private static final String UDID = "HT4AJJT00196";
    private static final String DEVICE_NAME = "Nexus_9";
    protected static AppiumDriver driver;
    private PLATFORM platform = PLATFORM.ANDROID;

    @BeforeClass(alwaysRun = true)
    public void setupWebDriver() throws MalformedURLException {
        setupAppiumDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private void setupAppiumDriver() {
        File appDir = new File(System.getProperty("user.dir") + "/src/test/resources");

        if (platform == PLATFORM.ANDROID) {
            File app = new File(appDir, "com_flipkart_android-680400.apk");

            DesiredCapabilities desiredCaps = getAndroidDesiredCapabilities(app);

            // appium will wait for 300 secs in case there is no new command before
            // killing the connection to the device
            desiredCaps.setCapability("newCommandTimeout", "300");

            try {
                driver = new AndroidDriver(new URL("http://" + SELENIUM_HOST + ":" + SELENIUM_PORT + "/wd/hub"), desiredCaps);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }

    }

    private DesiredCapabilities getAndroidDesiredCapabilities(File app) {
        DesiredCapabilities desiredCaps = new DesiredCapabilities();

        desiredCaps.setCapability("automationName", "Appium");

        desiredCaps.setCapability("device", "Android");
        //mandatory capabilities
        // deviceName capability is currently ignored for Android
        desiredCaps.setCapability("deviceName", DEVICE_NAME);
        desiredCaps.setCapability("platformName", "Android");
        desiredCaps.setCapability("udid", UDID);
        // wait for 120 secs for the device to be ready to accept commands
        desiredCaps.setCapability("deviceReadyTimeout", "120");
        desiredCaps.setCapability("appWaitActivity", "com.flipkart.android.SplashActivity");

        //other caps
        desiredCaps.setCapability("app", app.getAbsolutePath());
        return desiredCaps;
    }

    @AfterClass(alwaysRun = true)
    public void suiteTearDown() {
        driver.quit();
    }

    private enum PLATFORM {IOS, ANDROID}

}
