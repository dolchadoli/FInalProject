package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage {
    private final By header = By.xpath("//*[contains(text(),'Test Cases')]");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        return isDisplayed(header);
    }
}
