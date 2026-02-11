package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseUiTest;
import com.automationexercise.base.DriverFactory;
import com.automationexercise.pages.*;
import com.automationexercise.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_RegisterExistingEmailTest extends BaseUiTest {

    @Test
    public void registerWithExistingEmail() {
        var driver = DriverFactory.getDriver();
        NavBar nav = new NavBar(driver);

        // Create user
        nav.goToSignupLogin();
        String email = TestData.uniqueEmail();
        new LoginSignupPage(driver).signupStart(TestData.name(), email);
        SignupAccountInfoPage signup = new SignupAccountInfoPage(driver);
        signup.fillAccountInfoAndCreate(TestData.password());
        signup.clickContinue();

        // Logout then attempt to sign up with same email again
        nav.logout();
        nav.goToSignupLogin();

        LoginSignupPage page = new LoginSignupPage(driver);
        page.signupStart("Another Name", email);

        Assert.assertTrue(page.isSignupExistingEmailError(), "Expected 'Email Address already exist' error not visible");
    }
}
