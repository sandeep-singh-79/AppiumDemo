package com.demo.sotiAppiumDemo.test;

import com.demo.sotiAppiumDemo.AppMainPage;
import com.demo.sotiAppiumDemo.PermissionDialogPage;
import com.demo.sotiAppiumDemo.ResultsPage;
import org.testng.annotations.Test;

/**
 * Created by Sandeep on 4/28/2016.
 */
public class ApplyFiltersToMobileSearchResultsTest extends BaseTest {
    AppMainPage mainPage;

    private void loadApplication() throws InterruptedException {
        this.mainPage = new PermissionDialogPage(driver)
                .allow()
                .clickExistingUser()
                .enterCredentials("leouragan@googlemail.com", "WPVwAwy9")
                .submitLogin();
    }

    @Test
    public void testNavigateToMobilesPage() {
        try {
            loadApplication();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ResultsPage resultsPage = mainPage
                .displayHamburgerMenu()
                .mobilesClick()
                .selectBrandAndSubmit();
    }
}
