package com.automationexercise.tests.api;

import com.automationexercise.api.AutomationExerciseApi;
import com.automationexercise.base.BaseApiTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class API08_VerifyLoginMissingEmailShouldReturn400Test extends BaseApiTest {

    @Test
    public void verifyLogin_missingEmail_shouldReturn400() {
        var res = AutomationExerciseApi.postVerifyLoginMissingEmail("whatever");
        assertEquals(res.statusCode(), 400);
    }
}
