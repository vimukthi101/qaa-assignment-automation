package com.qa.base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class UIBaseTest extends UIBasePage {

    @BeforeClass
    public void openBrowser() {
        initWebDriver();
        openPage();
        maximizeWindow();
    }

    @AfterClass
    public void closeBrowser() {
        quitWebDriver();
    }
}
