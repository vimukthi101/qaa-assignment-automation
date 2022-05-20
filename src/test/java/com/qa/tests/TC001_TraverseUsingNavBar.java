package com.qa.tests;

import com.qa.base.UIBaseTest;
import com.qa.pages.BooksPage;
import com.qa.pages.ErrorPage;
import com.qa.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;

public class TC001_TraverseUsingNavBar extends UIBaseTest {
    private static final String HOME_BODY_CONTENT = "Hello Test Automation Engineer!!";
    private static final String APPLICATION_TITLE = "Project name";
    private static final String BOOKS_PAGE_TITLE = "Books";
    private static final String ERROR_MESSAGE = "Whitelabel Error Page";
    HomePage homePage = new HomePage();
    BooksPage booksPage = new BooksPage();
    ErrorPage errorPage = new ErrorPage();

    @Test
    @Description("Verify the nav bar items")
    @Severity(BLOCKER)
    @Story("As a user, I should be able to traverse between pages using the options in nav bar")
    public void verifyNavBar() {
        verifyHomePageIsLoaded();
        clickBooksLink();
        verifyBooksPageIsLoaded();
        clickNavBarTitle();
        verifyHomePageIsLoaded();
        clickAuthorsLink();
        verifyErrorPageIsLoaded();
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
        homePage.getNavBar().clickBooksLink();
    }

    private void verifyBooksPageIsLoaded() {
        Assert.assertEquals(getBooksPageTitle(), BOOKS_PAGE_TITLE);
        verifyNavBarTitle();
    }

    private String getBooksPageTitle() {
        return booksPage.getPageTitle();
    }

    private void clickNavBarTitle() {
        booksPage.getNavBar().clickNavBarTitle();
    }

    private void clickAuthorsLink() {
        homePage.getNavBar().clickAuthorsLink();
    }

    private void verifyErrorPageIsLoaded() {
        Assert.assertEquals(errorPage.getErrorMessage(), ERROR_MESSAGE);
    }
}
