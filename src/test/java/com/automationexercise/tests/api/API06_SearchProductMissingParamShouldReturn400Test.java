package com.automationexercise.tests.api;

import com.automationexercise.api.AutomationExerciseApi;
import com.automationexercise.base.BaseApiTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class API06_SearchProductMissingParamShouldReturn400Test extends BaseApiTest {

    @Test
    public void searchMissingParam_shouldReturn400() {
        var res = AutomationExerciseApi.postSearchProductMissingParam();
        assertEquals(res.statusCode(), 400);
    }
}
