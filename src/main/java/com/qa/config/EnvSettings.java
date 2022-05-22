package com.qa.config;

import java.io.IOException;
import java.util.Properties;

public class EnvSettings {
    private static EnvSettings instance;
    private static Properties envProperties;
    private static final String APPLICATION_HOST_PROP_KEY = "application.host";
    private static final String APPLICATION_SELENIUM_DRIVER_PROP_KEY = "application.selenium.driver";
    private static final String API_BASE_END_POINT = "api.base";

    public static EnvSettings getInstance() {
        if (instance == null) {
            instance = new EnvSettings();
            loadFileByPath("application.properties");
        }
        return instance;
    }

    private static void loadFileByPath(String filePath) {
        if (envProperties == null) {
            envProperties = new Properties();
        }
        try {
            envProperties.load(EnvSettings.class.getResourceAsStream("/properties/" + filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't load properties file by path [/properties/" + filePath + "]");
        }
    }

    public String getHost() {
        return envProperties.getProperty(APPLICATION_HOST_PROP_KEY);
    }

    public String getBrowser() {
        return envProperties.getProperty(APPLICATION_SELENIUM_DRIVER_PROP_KEY);
    }

    public String getApiBaseEndPoint() {
        return envProperties.getProperty(API_BASE_END_POINT);
    }
}
