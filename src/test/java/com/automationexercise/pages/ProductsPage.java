package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    private final By allProductsHeader = By.xpath("//*[contains(text(),'All Products')]");
    private final By firstProductView = By.cssSelector("a[href^='/product_details/']");

    private final By searchInput = By.id("search_product");
    private final By searchBtn = By.id("submit_search");
    private final By searchedProductsHeader = By.xpath("//*[contains(text(),'Searched Products')]");

    private final By firstAddToCart = By.cssSelector("a.add-to-cart");
    private final By continueShopping = By.xpath("//button[contains(text(),'Continue Shopping')]");
    private final By viewCart = By.xpath("//u[contains(text(),'View Cart')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAllProductsVisible() {
        return isDisplayed(allProductsHeader);
    }

    public void openFirstProductDetails() {
        click(firstProductView);
    }

    public void search(String query) {
        type(searchInput, query);
        click(searchBtn);
    }

    public boolean isSearchedProductsVisible() {
        return isDisplayed(searchedProductsHeader);
    }

    public void addFirstProductToCartAndContinue() {
        click(firstAddToCart);
        click(continueShopping);
    }

    public void addFirstProductToCartAndViewCart() {
        click(firstAddToCart);
        click(viewCart);
    }
}
