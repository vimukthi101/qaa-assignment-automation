package com.qa.pages;

import com.qa.blocks.LeftMenuPanel;
import com.qa.blocks.NavBar;
import com.qa.controller.Controller;
import org.openqa.selenium.By;

public class BooksPage extends Controller {
    private static final By BOOKS_PAGE_TITLE = By.xpath("//h1[@class=\"page-header\"]");
    private static final By BOOKS_TABLE = By.xpath("//table[@class=\"table table-striped\"]");
    private static final By CREATE_BOOK_LINK = By.xpath("//a[@href=\"/books/create\"]");

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
        return getTextFromElement(BOOKS_PAGE_TITLE);
    }

    public int getTotalBookCount() {
        return getTotalBooksInTable(BOOKS_TABLE);
    }

    public String getYearForBookFromTableTitle(String title) {
        return getYearFromTableByBookTitle(BOOKS_TABLE, title);
    }

    public BooksPage clickEditLinkForGivenBookByTitle(String title) {
        clickEditInTableByBookTitle(BOOKS_TABLE, title);
        return this;
    }

    public BooksPage clickEditLinkForGivenBookByRowNumber(int index) {
        clickEditInTableByRowNumber(BOOKS_TABLE, index);
        return this;
    }

    public String getBookTitleByRowNumber(int index) {
        return getBookNameByRowNumber(BOOKS_TABLE, index);
    }

    public BooksPage clickDeleteLinkForGivenBookByTitle(String title) {
        clickDeleteInTableByBookTitle(BOOKS_TABLE, title);
        return this;
    }

    public BooksPage clickDeleteLinkForGivenBookByRowNumber(int index) {
        clickDeleteInTableByRowNumber(BOOKS_TABLE, index);
        return this;
    }

    public BooksPage clickCreateBookLink() {
        clickElement(CREATE_BOOK_LINK);
        return this;
    }
}
