package com.qa.blocks;

import com.qa.controller.Controller;
import org.openqa.selenium.By;

public class LeftMenuPanel extends Controller {
    private static final By HOME_NAV_LINK = By.xpath("//ul[@class=\"nav nav-sidebar\"]/li/a[@href=\"/\"]");
    private static final By BOOKS_NAV_LINK = By.xpath("//ul[@class=\"nav nav-sidebar\"]/li/a[@href=\"/books\"]");
    private static final By AUTHORS_NAV_LINK = By.xpath("//ul[@class=\"nav nav-sidebar\"]/li/a[@href=\"/authors\"]");

    public LeftMenuPanel clickHomeLink() {
        clickElement(HOME_NAV_LINK);
        return this;
    }

    public LeftMenuPanel clickBooksLink() {
        clickElement(BOOKS_NAV_LINK);
        return this;
    }

    public LeftMenuPanel clickAuthorsLink() {
        clickElement(AUTHORS_NAV_LINK);
        return this;
    }
}
