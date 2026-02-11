package com.automationexercise.config;

import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        try (InputStream is = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (is == null) throw new RuntimeException("config.properties not found in src/test/resources");
            props.load(is);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String baseUrl() {
        return props.getProperty("base.url").trim();
    }

    public static String apiBaseUrl() {
        return props.getProperty("api.base.url").trim();
    }

    public static String browser() {
        return props.getProperty("browser", "chrome").trim();
    }

    public static boolean headless() {
        return Boolean.parseBoolean(props.getProperty("headless", "false"));
    }

    public static int timeoutSeconds() {
        return Integer.parseInt(props.getProperty("timeout.seconds", "12").trim());
    }
}
