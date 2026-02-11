package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavBar extends BasePage {
    private final By signupLogin = By.cssSelector("a[href='/login']");
    private final By testCases = By.cssSelector("a[href='/test_cases']");
    private final By products = By.cssSelector("a[href='/products']");
    private final By cart = By.cssSelector("a[href='/view_cart']");
    private final By contactUs = By.cssSelector("a[href='/contact_us']");
    private final By logout = By.cssSelector("a[href='/logout']");
    private final By loggedInAs = By.xpath("//*[contains(text(),'Logged in as')]");

    public NavBar(WebDriver driver) {
        super(driver);
    }

    public void goToSignupLogin() { click(signupLogin); }
    public void goToTestCases() { click(testCases); }
    public void goToProducts() { click(products); }
    public void goToCart() { click(cart); }
    public void goToContactUs() { click(contactUs); }
    public void logout() { click(logout); }
    public boolean isLoggedInLabelVisible() { return isDisplayed(loggedInAs); }
}
