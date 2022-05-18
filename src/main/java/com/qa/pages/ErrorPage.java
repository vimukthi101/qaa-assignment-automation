package com.qa.pages;

import com.qa.controller.Controller;
import org.openqa.selenium.By;

public class ErrorPage extends Controller {
    private static final By ERROR_TITLE = By.xpath("//h1");

    public String getErrorMessage() {
        return getTextFromElement(ERROR_TITLE);
    }
}
