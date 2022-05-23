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

import static com.qa.constants.Constants.TITLE_ERROR_MESSAGE;
import static io.qameta.allure.SeverityLevel.MINOR;

public class TC005_ClearButtonAtCreateBookPage extends UIBaseTest {
    private static final String HOME_BODY_CONTENT = "Hello Test Automation Engineer!!";
    private static final String APPLICATION_TITLE = "Project name";
    private static final String BOOKS_PAGE_TITLE = "Books";
    private static final String CREATE_BOOKS_PAGE_TITLE = "Create Book";
    private static final String BOOK_TITLE_ONE = "Hello World";
    private static final String BOOK_YEAR = "2022";
    HomePage homePage = new HomePage();
    BooksPage booksPage = new BooksPage();
    CreateBookPage createBookPage = new CreateBookPage();

    @Test
    @Description("Verify the Clear button at Create Book")
    @Severity(MINOR)
    @Story("As a user, I should be able to clear the inputs in create book page")
    public void verifyClearButtonAtCreatePage() {
        verifyHomePageIsLoaded();
        clickBooksLink();
        verifyBooksPageIsLoaded();
        clickCreateBookLink();
        verifyCreateBookPageIsLoaded();
        inputTitleAndYear();
        clickClearButton();
        clickSaveButton();
        verifyErrorMessageIsVisible();
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

    private void clickCreateBookLink() {
        booksPage.clickCreateBookLink();
    }

    private void verifyCreateBookPageIsLoaded() {
        Assert.assertEquals(createBookPage.getPageTitle(), CREATE_BOOKS_PAGE_TITLE);
    }

    private void inputTitleAndYear() {
        createBookPage.inputTitle(BOOK_TITLE_ONE).inputYear(BOOK_YEAR);
    }

    private void clickClearButton() {
        createBookPage.clickClearButton();
    }

    private void clickSaveButton() {
        createBookPage.clickSaveButton();
    }

    private void verifyErrorMessageIsVisible() {
        Assert.assertEquals(createBookPage.getErrorMessage(), TITLE_ERROR_MESSAGE);
    }
}
