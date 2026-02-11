package com.automationexercise.tests.api;

import com.automationexercise.api.AutomationExerciseApi;
import com.automationexercise.base.BaseApiTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;

public class API03_GetAllBrandsListTest extends BaseApiTest {

    @Test
    public void getBrands_shouldReturn200() {
        var res = AutomationExerciseApi.getBrandsList();
        assertEquals(res.statusCode(), 200);
        res.then().body("brands", notNullValue());
    }
}
