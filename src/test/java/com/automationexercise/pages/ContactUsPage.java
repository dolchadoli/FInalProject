package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage {
    private final By contactHeader = By.xpath("//*[contains(text(),'Get In Touch')]");
    private final By name = By.name("name");
    private final By email = By.name("email");
    private final By subject = By.name("subject");
    private final By message = By.id("message");
    private final By submit = By.name("submit");

    private final By successMsg = By.xpath("//*[contains(text(),'Success!') and contains(text(),'Your details have been submitted successfully')]");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isDisplayed(contactHeader);
    }

    public void submitForm(String n, String e, String s, String m) {
        type(name, n);
        type(email, e);
        type(subject, s);
        type(message, m);
        click(submit);

        // site sometimes shows alert confirm
        try {
            driver.switchTo().alert().accept();
        } catch (Exception ignored) {}
    }

    public boolean isSuccessVisible() {
        return isDisplayed(successMsg);
    }
}
