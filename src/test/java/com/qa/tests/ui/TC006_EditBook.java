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
import static io.qameta.allure.SeverityLevel.NORMAL;

public class TC006_EditBook extends UIBaseTest {
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
    @Description("Verify the Edit option for book")
    @Severity(NORMAL)
    @Story("As a user, I should be able to edit the book")
    public void verifyEditBookFlow() {
        verifyHomePageIsLoaded();
        clickBooksLink();
        verifyBooksPageIsLoaded();
        int countBefore = getTotalBookCount();
        clickEditLinkOfBook();
        verifyEditBookPageIsLoaded();
        editBook();
        int countAfter = getTotalBookCount();
        verifyBookTitleIsUpdated();
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

    private void clickEditLinkOfBook() {
        booksPage.clickEditLinkForGivenBookByRowNumber(NUMBER_THREE);
    }

    private void verifyEditBookPageIsLoaded() {
        Assert.assertEquals(editBookPage.getPageTitle(), EDIT_BOOKS_PAGE_TITLE);
    }

    private void editBook() {
        editBookPage.inputTitle(NEW_BOOK_TITLE).inputYear(BOOK_YEAR).clickSaveButton();
    }

    private String getTitleFromTable(int index) {
        return booksPage.getBookTitleByRowNumber(index);
    }

    private void verifyBookTitleIsUpdated() {
        Assert.assertEquals(getTitleFromTable(NUMBER_THREE), NEW_BOOK_TITLE);
    }

    private void verifyBookCount(int countBefore, int countAfter) {
        Assert.assertEquals(countAfter, countBefore);
    }
}
