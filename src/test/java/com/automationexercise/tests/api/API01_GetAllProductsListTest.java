package com.automationexercise.tests.api;

import com.automationexercise.api.AutomationExerciseApi;
import com.automationexercise.base.BaseApiTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

public class API01_GetAllProductsListTest extends BaseApiTest {

    @Test
    public void getAllProducts_shouldReturn200() {
        var res = AutomationExerciseApi.getProductsList();
        assertEquals(res.statusCode(), 200);
        res.then().body("products", notNullValue());
    }
}
