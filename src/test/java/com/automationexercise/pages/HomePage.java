package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By homeLogo = By.cssSelector("div.logo");
    private final By subscriptionEmail = By.id("susbscribe_email");
    private final By subscriptionBtn = By.id("subscribe");
    private final By subscriptionSuccess = By.xpath("//*[contains(text(),'You have been successfully subscribed')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isHomeVisible() {
        return isDisplayed(homeLogo);
    }

    public void subscribe(String email) {
        type(subscriptionEmail, email);
        click(subscriptionBtn);
    }

    public boolean isSubscriptionSuccessVisible() {
        return isDisplayed(subscriptionSuccess);
    }
}
