package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseUiTest;
import com.automationexercise.base.DriverFactory;
import com.automationexercise.pages.ContactUsPage;
import com.automationexercise.pages.NavBar;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_ContactUsFormTest extends BaseUiTest {

    @Test
    public void contactUsForm() {
        var driver = DriverFactory.getDriver();
        NavBar nav = new NavBar(driver);

        nav.goToContactUs();

        ContactUsPage contact = new ContactUsPage(driver);
        Assert.assertTrue(contact.isOpened(), "Contact Us page not opened");

        contact.submitForm("Test User", "test@test.com", "Subject", "Hello from automated test");
        Assert.assertTrue(contact.isSuccessVisible(), "Success message not visible after contact submission");
    }
}
