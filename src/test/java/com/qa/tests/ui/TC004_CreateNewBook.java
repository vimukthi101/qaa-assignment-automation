package com.qa.tests.ui;

import com.qa.base.UIBaseTest;
import com.qa.pages.BooksPage;
import com.qa.pages.CreateBookPage;
import com.qa.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qa.constants.Constants.NUMBER_ONE;
import static com.qa.constants.Constants.TITLE_ERROR_MESSAGE;
import static io.qameta.allure.SeverityLevel.CRITICAL;

public class TC004_CreateNewBook extends UIBaseTest {
    private static final String HOME_BODY_CONTENT = "Hello Test Automation Engineer!!";
    private static final String APPLICATION_TITLE = "Project name";
    private static final String BOOKS_PAGE_TITLE = "Books";
    private static final String CREATE_BOOKS_PAGE_TITLE = "Create Book";
    private static final String BOOK_TITLE_ONE = "Hello";
    private static final String BOOK_TITLE_TWO = "Hello World";
    private static final String BOOK_YEAR = "2022";
    HomePage homePage = new HomePage();
    BooksPage booksPage = new BooksPage();
    CreateBookPage createBookPage = new CreateBookPage();

    @Test
    @Description("Verify the Create Book flow")
    @Severity(CRITICAL)
    @Story("As a user, I should be able to create a new book")
    public void verifyCreateNewBookFlow() {
        verifyHomePageIsLoaded();
        clickBooksLink();
        verifyBooksPageIsLoaded();
        int countBefore = getTotalBookCount();
        clickCreateBookLink();
        verifyCreateBookPageIsLoaded();
        clickSaveButton();
        verifyErrorMessageIsVisible();
        createNewBook(BOOK_TITLE_ONE);
        verifyErrorMessageIsVisible();
        createNewBook(BOOK_TITLE_TWO);
        verifyBooksPageIsLoaded();
        int countAfter = getTotalBookCount();
        verifyBookCount(countBefore, countAfter);
    }

    private void verifyHomePageIsLoaded() {
        Assert.assertEquals(getHomePageContent(), HOME_BODY_CONTENT);
        verifyNavBarTitle();
    }

    private String getHomePageContent() {
        return homePage.getHomeBodyText();
    }

    private void verifyNavBarTitle() {
        Assert.assertEquals(getNavBarTitle(), APPLICATION_TITLE);
    }

    private String getNavBarTitle() {
        return homePage.getNavBar().getNavBarTitle();
    }

    private void clickBooksLink() {
        homePage.getLeftMenuPanel().clickBooksLink();
    }

    private void verifyBooksPageIsLoaded() {
        Assert.assertEquals(getBooksPageTitle(), BOOKS_PAGE_TITLE);
        verifyNavBarTitle();
    }

    private String getBooksPageTitle() {
        return booksPage.getPageTitle();
    }

    private int getTotalBookCount() {
        return booksPage.getTotalBookCount();
    }

    private void clickCreateBookLink() {
        booksPage.clickCreateBookLink();
    }

    private void verifyCreateBookPageIsLoaded() {
        Assert.assertEquals(createBookPage.getPageTitle(), CREATE_BOOKS_PAGE_TITLE);
    }

    private void clickSaveButton() {
        createBookPage.clickSaveButton();
    }

    private void verifyErrorMessageIsVisible() {
        Assert.assertEquals(createBookPage.getErrorMessage(), TITLE_ERROR_MESSAGE);
    }

    private void createNewBook(String bookTitleOne) {
        createBookPage.inputTitle(bookTitleOne).inputYear(BOOK_YEAR).clickSaveButton();
    }

    private void verifyBookCount(int countBefore, int countAfter) {
        Assert.assertEquals(countAfter, countBefore + NUMBER_ONE);
    }
}
