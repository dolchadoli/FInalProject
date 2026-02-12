package com.automationexercise.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    // Headers
    private final By allProductsHeader =
            By.xpath("//h2[text()='All Products']");

    private final By searchedProductsHeader =
            By.xpath("//h2[contains(text(),'Searched Products')]");

    // Product container
    private final By firstProductContainer =
            By.cssSelector(".product-image-wrapper");

    // Product details
    private final By firstProductDetails =
            By.xpath("(//a[contains(@href,'/product_details/')])[1]");

    // Add to cart button (first product only)
    private final By firstAddToCart =
            By.xpath("(//a[@class='btn btn-default add-to-cart'])[1]");

    // Search
    private final By searchInput = By.id("search_product");
    private final By searchBtn = By.id("submit_search");

    // Cart modal
    private final By cartModal = By.id("cartModal");

    // IMPORTANT: click the parent <a>, NOT the <u>
    private final By viewCartBtn =
            By.xpath("//div[@id='cartModal']//a[contains(@href,'view_cart')]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAllProductsVisible() {
        return isDisplayed(allProductsHeader);
    }

    // ---------- PRODUCT DETAILS ----------

    public void openFirstProductDetails() {

        WebElement product = visible(firstProductContainer);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", product);

        click(firstProductDetails);

        wait.until(ExpectedConditions.urlContains("product_details"));
    }

    // ---------- SEARCH ----------

    public void search(String query) {
        type(searchInput, query);
        click(searchBtn);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchedProductsHeader));
    }

    public boolean isSearchedProductsVisible() {
        return isDisplayed(searchedProductsHeader);
    }

    // ---------- ADD TO CART ----------

    public void addFirstProductToCartAndViewCart() {

        WebElement product = visible(firstProductContainer);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", product);

        click(firstAddToCart);

        // Wait for modal to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartModal));

        // Small stabilization wait for modal animation
        wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));

        try {
            driver.findElement(viewCartBtn).click();
        } catch (Exception e) {
            WebElement btn = driver.findElement(viewCartBtn);
            ((JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", btn);
        }

        wait.until(ExpectedConditions.urlContains("view_cart"));
    }
}
