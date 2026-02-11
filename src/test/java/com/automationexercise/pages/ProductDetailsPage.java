package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    private final By productName = By.cssSelector("div.product-information h2");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductNameVisible() {
        return isDisplayed(productName);
    }
}
