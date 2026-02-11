package com.automationexercise.tests.ui;

import com.automationexercise.base.BaseUiTest;
import com.automationexercise.base.DriverFactory;
import com.automationexercise.pages.NavBar;
import com.automationexercise.pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09_SearchProductTest extends BaseUiTest {

    @Test
    public void searchProduct() {
        var driver = DriverFactory.getDriver();
        NavBar nav = new NavBar(driver);

        nav.goToProducts();
        ProductsPage products = new ProductsPage(driver);

        products.search("Top");
        Assert.assertTrue(products.isSearchedProductsVisible(), "Searched Products header not visible");
    }
}
