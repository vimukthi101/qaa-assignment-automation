package com.qa.base;

import com.qa.config.EnvSettings;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBaseTest {

    private static final String API_HOST = EnvSettings.getInstance().getHost();
    private static final String BASE_PATH = EnvSettings.getInstance().getApiBaseEndPoint();

    @BeforeClass
    public static void setup() {
        String basePath = System.getProperty("server.base");
        if (basePath == null) {
            basePath = BASE_PATH;
        }
        RestAssured.basePath = basePath;
        String baseHost = System.getProperty("server.host");
        if (baseHost == null) {
            baseHost = API_HOST;
        }
        RestAssured.baseURI = baseHost;
    }
}
