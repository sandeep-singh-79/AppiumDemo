package com.demo.sotiAppiumDemo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

/**
 * Created by Sandeep on 4/27/2016.
 */

public abstract class BasePage {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        // defining WebDriverWait class instance for explicit waits
        // setting the max timeout to 30 secs
        // and the poll time to 10 ms
        this.wait = (new WebDriverWait(driver, 30, 10));
        isLoaded();
    }

    // Each page object must implement this method to return the identifier of a unique WebElement on that page.
    // The presence of this unique element will be used to assert that the expected page has finished loading
    protected abstract By getUniqueElement();

    /**
     * isLoaded method tries to find unique element(s) in the page. It asserts the size of the element list
     * is at least 1. In case the element(s) are not found, the assertion fails and error message is displayed.
     * In the next step we wait for the unique element(s) to be displayed on the screen.
     */
    protected void isLoaded() throws Error {
        //Define a list of WebElements that match the unique element locator for the page
        List<WebElement> uniqueElement = driver.findElements(getUniqueElement());

        // Assert that the unique element is present in the DOM
        Assert.assertTrue((uniqueElement.size() > 0),
                "Unique Element \'" + getUniqueElement().toString() + "\' not found for " + this.getClass().getSimpleName());

        // Wait until the unique element is visible in the browser and ready to use. This helps make sure the page is
        // loaded before the next step of the tests continue.
        wait.until(ExpectedConditions.visibilityOfElementLocated(getUniqueElement()));
    }

    protected void enterText(String txtToEnter, MobileElement element) {
        element.click();
        element.clear();

        element.sendKeys(txtToEnter);
    }

}
