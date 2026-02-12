package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SignupAccountInfoPage extends BasePage {

    // Minimal fields to complete registration
    private final By titleMr = By.id("id_gender1");
    private final By passwordInput = By.id("password");

    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");

    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By address = By.id("address1");
    private final By country = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile = By.id("mobile_number");

    private final By createAccountBtn = By.cssSelector("button[data-qa='create-account']");

    // "ACCOUNT CREATED!" banner
    private final By accountCreated = By.cssSelector("h2[data-qa='account-created'] b, #form h2 b");
    private final By continueBtn = By.cssSelector("a[data-qa='continue-button']");

    public SignupAccountInfoPage(WebDriver driver) {
        super(driver);
    }

    public void fillAccountInfoAndCreate(String pass) {
        click(titleMr);
        type(passwordInput, pass);

        new Select(visible(days)).selectByVisibleText("10");
        new Select(visible(months)).selectByVisibleText("May");
        new Select(visible(years)).selectByValue("1999");

        type(firstName, "Test");
        type(lastName, "User");
        type(address, "Tbilisi Address 1");
        new Select(visible(country)).selectByVisibleText("India");

        type(state, "Tbilisi");
        type(city, "Tbilisi");
        type(zipcode, "0101");
        type(mobile, "555123123");

        click(createAccountBtn);

        // Wait until the success banner appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreated));
    }

    public boolean isAccountCreatedVisible() {
        // safe boolean check (no thrown timeout)
        return isDisplayed(accountCreated);
    }

    public void clickContinue() {
        click(continueBtn);

        // after Continue, site usually navigates back to home
        wait.until(ExpectedConditions.urlContains("/"));
    }
}
