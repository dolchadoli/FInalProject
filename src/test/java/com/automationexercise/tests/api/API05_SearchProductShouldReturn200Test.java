package com.automationexercise.tests.api;

import com.automationexercise.api.AutomationExerciseApi;
import com.automationexercise.base.BaseApiTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;

public class API05_SearchProductShouldReturn200Test extends BaseApiTest {

    @Test
    public void searchProduct_shouldReturn200() {
        var res = AutomationExerciseApi.postSearchProduct("top");
        assertEquals(res.statusCode(), 200);
        res.then().body("products", notNullValue());
    }
}
