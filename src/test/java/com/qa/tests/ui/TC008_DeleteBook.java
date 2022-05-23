package com.qa.tests.ui;

import com.qa.base.UIBaseTest;
import com.qa.pages.BooksPage;
import com.qa.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.qa.constants.Constants.NUMBER_ONE;
import static com.qa.constants.Constants.NUMBER_THREE;
import static io.qameta.allure.SeverityLevel.NORMAL;

public class TC008_DeleteBook extends UIBaseTest {
    private static final String HOME_BODY_CONTENT = "Hello Test Automation Engineer!!";
    private static final String APPLICATION_TITLE = "Project name";
    private static final String BOOKS_PAGE_TITLE = "Books";
    HomePage homePage = new HomePage();
    BooksPage booksPage = new BooksPage();

    @Test
    @Description("Verify the Delete option for book")
    @Severity(NORMAL)
    @Story("As a user, I should be able to delete a book")
    public void verifyDeleteBookFlow() {
        verifyHomePageIsLoaded();
        clickBooksLink();
        verifyBooksPageIsLoaded();
        int countBefore = getTotalBookCount();
        clickDeleteLink();
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

    private void clickDeleteLink() {
        booksPage.clickDeleteLinkForGivenBookByRowNumber(NUMBER_THREE);
    }

    private void verifyBookCount(int countBefore, int countAfter) {
        Assert.assertEquals(countAfter, countBefore - NUMBER_ONE);
    }
}
