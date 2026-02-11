package com.automationexercise.utils;

import java.time.Instant;

public class TestData {
    public static String uniqueEmail() {
        return "nika_" + Instant.now().toEpochMilli() + "@testmail.com";
    }

    public static String password() {
        return "Pass12345!";
    }

    public static String name() {
        return "Test User";
    }
}
