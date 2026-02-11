package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseUiTest;
import com.automationexercise.base.DriverFactory;
import com.automationexercise.pages.NavBar;
import com.automationexercise.pages.ProductDetailsPage;
import com.automationexercise.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08_VerifyAllProductsAndDetailsTest extends BaseUiTest {

    @Test
    public void verifyProductsAndDetailsPage() {
        var driver = DriverFactory.getDriver();
        NavBar nav = new NavBar(driver);

        nav.goToProducts();
        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.isAllProductsVisible(), "All Products page not visible");

        products.openFirstProductDetails();
        Assert.assertTrue(new ProductDetailsPage(driver).isProductNameVisible(), "Product details page not visible");
    }
}
