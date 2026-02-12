package com.automationexercise.pages;

import com.automationexercise.config.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Config.timeoutSeconds()));
    }

    protected WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement clickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator) {
        try {
            clickable(locator).click();
        } catch (StaleElementReferenceException e) {
            clickable(locator).click();
        } catch (ElementClickInterceptedException e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", visible(locator));
        }
    }


    protected void type(By locator, String text) {
        WebElement el = visible(locator);
        el.clear();
        el.sendKeys(text);
    }

    protected void closeAdsIfPresent() {
        try {
            By adClose = By.xpath("//div[@id='dismiss-button' or contains(@class,'close')]");
            driver.findElement(adClose).click();
        } catch (Exception ignored) {}
    }


    protected boolean isDisplayed(By locator) {
        try {
            return visible(locator).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void openHome() {
        driver.get("https://automationexercise.com");
    }
}
