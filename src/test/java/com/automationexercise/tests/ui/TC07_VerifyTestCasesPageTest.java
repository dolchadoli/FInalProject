package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseUiTest;
import com.automationexercise.base.DriverFactory;
import com.automationexercise.pages.NavBar;
import com.automationexercise.pages.TestCasesPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_VerifyTestCasesPageTest extends BaseUiTest {

    @Test
    public void verifyTestCasesPage() {
        var driver = DriverFactory.getDriver();
        NavBar nav = new NavBar(driver);

        nav.goToTestCases();
        Assert.assertTrue(new TestCasesPage(driver).isOpened(), "Test Cases page not opened");
    }
}
