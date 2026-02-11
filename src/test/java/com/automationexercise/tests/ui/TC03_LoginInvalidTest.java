package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseUiTest;
import com.automationexercise.base.DriverFactory;
import com.automationexercise.pages.LoginSignupPage;
import com.automationexercise.pages.NavBar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_LoginInvalidTest extends BaseUiTest {

    @Test
    public void loginWithIncorrectCredentials() {
        var driver = DriverFactory.getDriver();
        NavBar nav = new NavBar(driver);

        nav.goToSignupLogin();
        LoginSignupPage page = new LoginSignupPage(driver);

        page.login("wrong@test.com", "wrongpass");
        Assert.assertTrue(page.isLoginErrorVisible(), "Expected login error message not visible");
    }
}
