package com.qa.base;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class UIBaseTest extends UIBasePage {

    @BeforeTest
    public void openBrowser() {
        initWebDriver();
        openPage();
        maximizeWindow();
    }

    @AfterTest
    public void closeBrowser() {
        quitWebDriver();
    }
}
