package com.automationexercise.base;

import com.automationexercise.config.Config;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass(alwaysRun = true)
    public void apiSetup() {
        RestAssured.baseURI = Config.apiBaseUrl();
        RestAssured.filters(new AllureRestAssured()); // attaches request/response to Allure
    }
}
