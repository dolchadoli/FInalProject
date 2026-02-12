package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By cartTable =
            By.id("cart_info_table");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartVisible() {
        return isDisplayed(cartTable);
    }
}
