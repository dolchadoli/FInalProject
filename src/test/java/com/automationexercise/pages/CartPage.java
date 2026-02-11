package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    private final By cartHeader = By.xpath("//*[contains(text(),'Shopping Cart')]");
    private final By cartTable = By.cssSelector("table.table");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartVisible() {
        return isDisplayed(cartHeader) || isDisplayed(cartTable);
    }
}
