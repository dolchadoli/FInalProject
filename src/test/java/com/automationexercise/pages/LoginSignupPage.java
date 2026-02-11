package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginSignupPage extends BasePage {

    // Signup
    private final By signupName = By.name("name");
    private final By signupEmail = By.cssSelector("form[action='/signup'] input[name='email']");
    private final By signupBtn = By.cssSelector("form[action='/signup'] button");

    private final By signupErrorExisting = By.xpath("//*[contains(text(),'Email Address already exist')]");

    // Login
    private final By loginEmail = By.cssSelector("form[action='/login'] input[name='email']");
    private final By loginPassword = By.name("password");
    private final By loginBtn = By.cssSelector("form[action='/login'] button");
    private final By loginError = By.xpath("//*[contains(text(),'Your email or password is incorrect')]");

    public LoginSignupPage(WebDriver driver) {
        super(driver);
    }

    public void signupStart(String name, String email) {
        type(signupName, name);
        type(signupEmail, email);
        click(signupBtn);
    }

    public boolean isSignupExistingEmailError() {
        return isDisplayed(signupErrorExisting);
    }

    public void login(String email, String password) {
        type(loginEmail, email);
        type(loginPassword, password);
        click(loginBtn);
    }

    public boolean isLoginErrorVisible() {
        return isDisplayed(loginError);
    }
}
