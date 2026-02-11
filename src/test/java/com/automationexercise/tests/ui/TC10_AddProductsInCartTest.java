package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseUiTest;
import com.automationexercise.base.DriverFactory;
import com.automationexercise.pages.CartPage;
import com.automationexercise.pages.NavBar;
import com.automationexercise.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_AddProductsInCartTest extends BaseUiTest {

    @Test
    public void addProductsToCart() {
        var driver = DriverFactory.getDriver();
        NavBar nav = new NavBar(driver);

        nav.goToProducts();
        ProductsPage products = new ProductsPage(driver);

        products.addFirstProductToCartAndViewCart();
        Assert.assertTrue(new CartPage(driver).isCartVisible(), "Cart page not visible after adding product");
    }
}
