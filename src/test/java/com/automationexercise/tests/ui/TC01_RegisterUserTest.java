package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseUiTest;
import com.automationexercise.base.DriverFactory;
import com.automationexercise.pages.*;
import com.automationexercise.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_RegisterUserTest extends BaseUiTest {

    @Test
    public void registerUser() {
        var driver = DriverFactory.getDriver();
        HomePage home = new HomePage(driver);
        NavBar nav = new NavBar(driver);

        Assert.assertTrue(home.isHomeVisible(), "Home page is not visible");

        nav.goToSignupLogin();

        String email = TestData.uniqueEmail();
        new LoginSignupPage(driver).signupStart(TestData.name(), email);

        SignupAccountInfoPage signup = new SignupAccountInfoPage(driver);
        signup.fillAccountInfoAndCreate(TestData.password());

        Assert.assertTrue(signup.isAccountCreatedVisible(), "Account not created");
        signup.clickContinue();

        Assert.assertTrue(nav.isLoggedInLabelVisible(), "Logged in label not visible after registration");
    }
}
