package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavBar extends BasePage {

    private final By productsLink = By.cssSelector("a[href='/products']");
    private final By testCasesLink = By.cssSelector("a[href='/test_cases']");
    private final By signupLoginLink = By.cssSelector("a[href='/login']");
    private final By contactUsLink = By.cssSelector("a[href='/contact_us']");
    private final By logoutLink = By.cssSelector("a[href='/logout']");

    // When logged in, site shows "Logged in as <name>"
    private final By loggedInLabel =
            By.xpath("//*[contains(normalize-space(.),'Logged in as')]");

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public void goToProducts() {
        click(productsLink);
        wait.until(ExpectedConditions.urlContains("/products"));
    }

    public void goToTestCases() {
        click(testCasesLink);
        wait.until(ExpectedConditions.urlContains("/test_cases"));
    }

    public void goToSignupLogin() {
        click(signupLoginLink);
        wait.until(ExpectedConditions.urlContains("/login"));
    }

    public void goToContactUs() {
        click(contactUsLink);
        wait.until(ExpectedConditions.urlContains("/contact_us"));
    }

    public boolean isLoggedInLabelVisible() {
        return isDisplayed(loggedInLabel);
    }

    public void logout() {
        click(logoutLink);
        wait.until(ExpectedConditions.urlContains("/login"));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loggedInLabel));
    }
}
