package com.automationexercise.tests.api;

import com.automationexercise.api.AutomationExerciseApi;
import com.automationexercise.base.BaseApiTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class API09_DeleteVerifyLoginShouldReturn405Test extends BaseApiTest {

    @Test
    public void deleteVerifyLogin_shouldReturn405() {
        var res = AutomationExerciseApi.deleteVerifyLoginExpect405();
        assertEquals(res.statusCode(), 200);
    }
}
