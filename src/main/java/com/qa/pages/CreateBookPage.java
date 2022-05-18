package com.qa.pages;

import com.qa.blocks.LeftMenuPanel;
import com.qa.blocks.NavBar;
import com.qa.controller.Controller;
import org.openqa.selenium.By;

public class CreateBookPage extends Controller {
    private static final By CREATE_BOOK_PAGE_TITLE = By.xpath("//h1[@class=\"page-header\"]");
    private static final By TITLE_INPUT = By.xpath("//input[@id=\"title\"]");
    private static final By YEAR_INPUT = By.xpath("//input[@id=\"year\"]");
    private static final By SAVE_BUTTON = By.xpath("//button[@class=\"btn btn-success\"]");
    private static final By CLEAR_BUTTON = By.xpath("//button[@class=\"btn btn-danger\"]");
    private static final By ERROR_LABEL = By.xpath("//div[@class=\"form-group\"]/b");

    public NavBar getNavBar() {
        return new NavBar();
    }

    public LeftMenuPanel getLeftMenuPanel() {
        return new LeftMenuPanel();
    }

    public String verifyTabTitle() {
        return getTitle();
    }

    public String getPageTitle() {
        return getTextFromElement(CREATE_BOOK_PAGE_TITLE);
    }

    public CreateBookPage inputTitle(String title) {
        typeText(TITLE_INPUT, title);
        return this;
    }

    public CreateBookPage inputYear(String year) {
        typeText(YEAR_INPUT, year);
        return this;
    }

    public CreateBookPage clickSaveButton() {
        clickElement(SAVE_BUTTON);
        return this;
    }

    public CreateBookPage clickClearButton() {
        clickElement(CLEAR_BUTTON);
        return this;
    }

    public boolean isErrorMessageVisible() {
        return isVisible(ERROR_LABEL);
    }

    public String getErrorMessage() {
        return getTextFromElement(ERROR_LABEL);
    }
}
