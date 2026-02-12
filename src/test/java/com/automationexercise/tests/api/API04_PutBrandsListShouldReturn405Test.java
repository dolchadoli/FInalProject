package com.automationexercise.tests.api;

import com.automationexercise.api.AutomationExerciseApi;
import com.automationexercise.base.BaseApiTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class API04_PutBrandsListShouldReturn405Test extends BaseApiTest {

    @Test
    public void putBrands_shouldReturn405() {
        var res = AutomationExerciseApi.putBrandsListExpect405();
        assertEquals(res.statusCode(), 200);
    }
}
