package com.qa.tests.ui;

import com.qa.base.UIBaseTest;
import com.qa.pages.BooksPage;
import com.qa.pages.EditBookPage;
import com.qa.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qa.constants.Constants.NUMBER_THREE;
import static com.qa.constants.Constants.TITLE_ERROR_MESSAGE;
import static io.qameta.allure.SeverityLevel.MINOR;

public class TC007_ClearButtonAtEditBook extends UIBaseTest {
    private static final String HOME_BODY_CONTENT = "Hello Test Automation Engineer!!";
    private static final String APPLICATION_TITLE = "Project name";
    private static final String BOOKS_PAGE_TITLE = "Books";
    private static final String EDIT_BOOKS_PAGE_TITLE = "Edit Book";
    private static final String NEW_BOOK_TITLE = "Updated Book Title";
    private static final String BOOK_YEAR = "2022";
    HomePage homePage = new HomePage();
    BooksPage booksPage = new BooksPage();
    EditBookPage editBookPage = new EditBookPage();

    @Test
    @Description("Verify the Clear button at Edit Book")
    @Severity(MINOR)
    @Story("As a user, I should be able to clear the inputs at edit books page")
    public void verifyClearButtonAtEditPage() {
        verifyHomePageIsLoaded();
        clickBooksLink();
        verifyBooksPageIsLoaded();
        clickEditLinkOfBook();
        verifyEditBookPageIsLoaded();
        editBook();
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

    private void clickEditLinkOfBook() {
        booksPage.clickEditLinkForGivenBookByRowNumber(NUMBER_THREE);
    }

    private void verifyEditBookPageIsLoaded() {
        Assert.assertEquals(editBookPage.getPageTitle(), EDIT_BOOKS_PAGE_TITLE);
    }

    private void editBook() {
        editBookPage.inputTitle(NEW_BOOK_TITLE).inputYear(BOOK_YEAR);
    }

    private void clickClearButton() {
        editBookPage.clickClearButton();
    }

    private void clickSaveButton() {
        editBookPage.clickSaveButton();
    }

    private void verifyErrorMessageIsVisible() {
        Assert.assertEquals(editBookPage.getErrorMessage(), TITLE_ERROR_MESSAGE);
    }
}
