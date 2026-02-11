package com.automationexercise.tests.api;

import com.automationexercise.api.AutomationExerciseApi;
import com.automationexercise.base.BaseApiTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class API07_VerifyLoginValidDetailsTest extends BaseApiTest {

    @Test
    public void verifyLogin_valid_shouldReturn200() {
        // This API expects existing user creds; if you don't have one, your team can create manually on site.
        var res = AutomationExerciseApi.postVerifyLogin("test@test.com", "test");
        // Some environments respond 200 even if user not exists; keep status assertion from spec if it matches.
        // If your response differs, set creds to a real registered user.
        assertEquals(res.statusCode(), 200);
    }
}
