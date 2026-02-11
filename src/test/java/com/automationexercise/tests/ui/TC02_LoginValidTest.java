package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseUiTest;
import com.automationexercise.base.DriverFactory;
import com.automationexercise.pages.*;
import com.automationexercise.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_LoginValidTest extends BaseUiTest {

    @Test
    public void loginWithCorrectCredentials() {
        var driver = DriverFactory.getDriver();
        NavBar nav = new NavBar(driver);

        // First create a user (simple approach for reliable login)
        nav.goToSignupLogin();
        String email = TestData.uniqueEmail();
        new LoginSignupPage(driver).signupStart(TestData.name(), email);
        SignupAccountInfoPage signup = new SignupAccountInfoPage(driver);
        signup.fillAccountInfoAndCreate(TestData.password());
        signup.clickContinue();

        Assert.assertTrue(nav.isLoggedInLabelVisible(), "Should be logged in after registration");

        nav.logout();
        Assert.assertFalse(nav.isLoggedInLabelVisible(), "Logged in label should disappear after logout");

        nav.goToSignupLogin();
        new LoginSignupPage(driver).login(email, TestData.password());

        Assert.assertTrue(nav.isLoggedInLabelVisible(), "Login failed with correct credentials");
    }
}
