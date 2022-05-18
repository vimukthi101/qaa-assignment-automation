package com.qa.blocks;

import com.qa.controller.Controller;
import org.openqa.selenium.By;

public class NavBar extends Controller {
    private static final By NAV_BAR_TITLE = By.xpath("//a[@class=\"navbar-brand\"]");
    private static final By SEARCH_INPUT = By.xpath("//input[@id=\"searchID\"]");
    private static final By SEARCH_BUTTON = By.xpath("//button[@class=\"btn btn-default\"]");
    private static final By HOME_NAV_LINK = By.xpath("//ul[@class=\"nav navbar-nav navbar-right\"]/li/a[@href=\"/\"]");
    private static final By BOOKS_NAV_LINK = By.xpath("//ul[@class=\"nav navbar-nav navbar-right\"]/li/a[@href=\"/books\"]");
    private static final By AUTHORS_NAV_LINK = By.xpath("//ul[@class=\"nav navbar-nav navbar-right\"]/li/a[@href=\"/authors\"]");

    public String getNavBarTitle() {
        return getTextFromElement(NAV_BAR_TITLE);
    }

    public NavBar clickNavBarTitle() {
        clickElement(NAV_BAR_TITLE);
        return this;
    }

    public NavBar inputTextToSearchField(String text) {
        typeText(SEARCH_INPUT, text);
        return this;
    }

    public NavBar clickSearchButton() {
        clickElement(SEARCH_BUTTON);
        return this;
    }

    public NavBar clickHomeLink() {
        clickElement(HOME_NAV_LINK);
        return this;
    }

    public NavBar clickBooksLink() {
        clickElement(BOOKS_NAV_LINK);
        return this;
    }

    public NavBar clickAuthorsLink() {
        clickElement(AUTHORS_NAV_LINK);
        return this;
    }
}
