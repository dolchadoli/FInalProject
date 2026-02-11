package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupAccountInfoPage extends BasePage {

    // Minimal fields to complete registration
    private final By titleMr = By.id("id_gender1");
    private final By password = By.id("password");

    private final By days = By.id("days");
    private final By months = By.id("months");
    private final By years = By.id("years");

    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By address = By.id("address1");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile = By.id("mobile_number");

    private final By createAccountBtn = By.cssSelector("button[data-qa='create-account']");

    private final By accountCreated = By.xpath("//*[contains(text(),'ACCOUNT CREATED!')]");
    private final By continueBtn = By.cssSelector("a[data-qa='continue-button']");

    public SignupAccountInfoPage(WebDriver driver) {
        super(driver);
    }

    public void fillAccountInfoAndCreate(String pass) {
        click(titleMr);
        type(password, pass);

        // These dropdowns accept sendKeys as quick selection
        type(days, "10");
        type(months, "May");
        type(years, "1999");

        type(firstName, "Test");
        type(lastName, "User");
        type(address, "Tbilisi Address 1");
        type(state, "Tbilisi");
        type(city, "Tbilisi");
        type(zipcode, "0101");
        type(mobile, "555123123");

        click(createAccountBtn);
    }

    public boolean isAccountCreatedVisible() {
        return isDisplayed(accountCreated);
    }

    public void clickContinue() {
        click(continueBtn);
    }
}
