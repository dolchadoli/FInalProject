package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseUiTest;
import com.automationexercise.base.DriverFactory;
import com.automationexercise.pages.*;
import com.automationexercise.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_LogoutTest extends BaseUiTest {

    @Test
    public void logoutUser() {
        var driver = DriverFactory.getDriver();
        NavBar nav = new NavBar(driver);

        nav.goToSignupLogin();
        String email = TestData.uniqueEmail();
        new LoginSignupPage(driver).signupStart(TestData.name(), email);
        SignupAccountInfoPage signup = new SignupAccountInfoPage(driver);
        signup.fillAccountInfoAndCreate(TestData.password());
        signup.clickContinue();

        Assert.assertTrue(nav.isLoggedInLabelVisible(), "Not logged in before logout");

        nav.logout();
        Assert.assertFalse(nav.isLoggedInLabelVisible(), "Still shows logged in after logout");
    }
}
