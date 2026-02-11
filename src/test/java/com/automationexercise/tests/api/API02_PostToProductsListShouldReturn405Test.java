package com.automationexercise.tests.api;

import com.automationexercise.api.AutomationExerciseApi;
import com.automationexercise.base.BaseApiTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class API02_PostToProductsListShouldReturn405Test extends BaseApiTest {

    @Test
    public void postToProductsList_shouldReturn405() {
        var res = AutomationExerciseApi.postProductsListExpect405();
        assertEquals(res.statusCode(), 405);
    }
}
