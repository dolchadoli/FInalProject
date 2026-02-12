package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCasesPage extends BasePage {

    // The page has a "Test Cases" heading.
    // This locator is intentionally flexible to avoid brittle failures.
    private final By testCasesHeader =
            By.xpath("//*[self::h2 or self::h1][contains(normalize-space(.),'Test Cases')]"
                    + " | //b[normalize-space()='Test Cases']");

    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isOpened() {
        try {
            // Require BOTH: correct URL + visible header
            wait.until(ExpectedConditions.urlContains("/test_cases"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(testCasesHeader));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
