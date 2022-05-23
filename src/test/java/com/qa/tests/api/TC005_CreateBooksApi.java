package com.qa.tests.api;

import com.qa.base.ApiBaseTest;
import com.qa.constants.Category;
import com.qa.dto.BookDTO;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static com.qa.constants.Constants.EMPTY_STRING;
import static com.qa.constants.Constants.ERROR_MESSAGE_405;
import static com.qa.constants.Constants.ERROR_TITLE_400;
import static com.qa.constants.Constants.ERROR_TITLE_405;
import static com.qa.constants.Constants.FORWARD_SLASH;
import static com.qa.constants.Constants.NUMBER_ONE;
import static com.qa.constants.Constants.STATUS_CODE_200;
import static com.qa.constants.Constants.STATUS_CODE_400;
import static com.qa.constants.Constants.STATUS_CODE_405;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.hamcrest.core.IsEqual.equalTo;

public class TC005_CreateBooksApi extends ApiBaseTest {
    private static int authorId;
    private static final int BOOK_AUTHOR_ID = NUMBER_ONE;
    private static final String BOOK_TITLE = "My test book 1";
    private static final String BOOK_YEAR = "2022";
    private static final String BOOK_CATEGORY = Category.COMEDY.getCategory();
    BookDTO bookDTO = new BookDTO(BOOK_TITLE, BOOK_YEAR, BOOK_AUTHOR_ID, BOOK_CATEGORY);
    BookDTO bookDTO_withoutTitle = new BookDTO(BOOK_YEAR, BOOK_AUTHOR_ID, BOOK_CATEGORY);
    BookDTO bookDTO_withoutAuthorId = new BookDTO(BOOK_TITLE, BOOK_YEAR, BOOK_CATEGORY);
    BookDTO bookDTO_withoutCategory = new BookDTO(BOOK_TITLE, BOOK_YEAR, BOOK_AUTHOR_ID);
    BookDTO bookDTO_withEmptyTitle = new BookDTO(EMPTY_STRING, BOOK_YEAR, BOOK_AUTHOR_ID, BOOK_CATEGORY);
    BookDTO bookDTO_withEmptyYear = new BookDTO(BOOK_TITLE, EMPTY_STRING, BOOK_AUTHOR_ID, BOOK_CATEGORY);
    BookDTO bookDTO_withEmptyAuthorId = new BookDTO(BOOK_TITLE, BOOK_YEAR, authorId, BOOK_CATEGORY);
    BookDTO bookDTO_withEmptyCategory = new BookDTO(BOOK_TITLE, BOOK_YEAR, BOOK_AUTHOR_ID, EMPTY_STRING);
    BookDTO bookDTO_withInvalidCategory = new BookDTO(BOOK_TITLE, BOOK_YEAR, BOOK_AUTHOR_ID, "HELLO");

    @Test
    @Description("Verify the Create Books API success flow")
    @Severity(BLOCKER)
    @Story("As a user, I should be able to create a new book")
    public void verifySuccessFlow() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .body(bookDTO)
                .header("Content-Type", "application/json")
                .post(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("title", equalTo(BOOK_TITLE))
                .body("year", equalTo(BOOK_YEAR))
                .statusCode(STATUS_CODE_200);
    }

    @Test
    @Description("Verify the Create Books API without Mandatory Param Title")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get an error message when Title is missing")
    public void verifyTitleMissing() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .body(bookDTO_withoutTitle)
                .header("Content-Type", "application/json")
                .post(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_400))
                .body("error", equalTo(ERROR_TITLE_400))
                .statusCode(STATUS_CODE_400);
    }

    @Test
    @Description("Verify the Create Books API without Mandatory Param AuthorId")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get an error message when AuthorId is missing")
    public void verifyAuthorIdMissing() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .body(bookDTO_withoutAuthorId)
                .header("Content-Type", "application/json")
                .post(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_400))
                .body("error", equalTo(ERROR_TITLE_400))
                .statusCode(STATUS_CODE_400);
    }

    @Test
    @Description("Verify the Create Books API without Mandatory Param Category")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get an error message when Category is missing")
    public void verifyCategoryMissing() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .body(bookDTO_withoutCategory)
                .header("Content-Type", "application/json")
                .post(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_400))
                .body("error", equalTo(ERROR_TITLE_400))
                .statusCode(STATUS_CODE_400);
    }

    @Test
    @Description("Verify the Create Books API with empty Title")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get an error message when Title is empty")
    public void verifyEmptyTitle() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .body(bookDTO_withEmptyTitle)
                .header("Content-Type", "application/json")
                .post(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_400))
                .body("error", equalTo(ERROR_TITLE_400))
                .statusCode(STATUS_CODE_400);
    }

    @Test
    @Description("Verify the Create Books API with empty Year")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get an error message when Year is empty")
    public void verifyEmptyYear() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .body(bookDTO_withEmptyYear)
                .header("Content-Type", "application/json")
                .post(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("title", equalTo(BOOK_TITLE))
                .body("category", equalTo(BOOK_CATEGORY))
                .statusCode(STATUS_CODE_200);
    }

    @Test
    @Description("Verify the Create Books API with empty AuthorId")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get an error message when AuthorId is empty")
    public void verifyEmptyAuthorId() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .body(bookDTO_withEmptyAuthorId)
                .header("Content-Type", "application/json")
                .post(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_400))
                .body("error", equalTo(ERROR_TITLE_400))
                .statusCode(STATUS_CODE_400);
    }

    @Test
    @Description("Verify the Create Books API with empty Category")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get an error message when Category is empty")
    public void verifyEmptyCategory() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .body(bookDTO_withEmptyCategory)
                .header("Content-Type", "application/json")
                .post(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_400))
                .body("error", equalTo(ERROR_TITLE_400))
                .statusCode(STATUS_CODE_400);
    }

    @Test
    @Description("Verify the Create Books API with Invalid Category")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get an error message when Category is Invalid")
    public void verifyInvalidCategory() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .body(bookDTO_withInvalidCategory)
                .header("Content-Type", "application/json")
                .post(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_400))
                .body("error", equalTo(ERROR_TITLE_400))
                .statusCode(STATUS_CODE_400);
    }

    @Test
    @Description("Verify the Create Books API with different HTTP method")
    @Severity(BLOCKER)
    @Story("As a user, I should be able to get an error message when HTTP method is different")
    public void verifyDifferentHttpMethod() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .body(bookDTO)
                .header("Content-Type", "application/json")
                .delete(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_405))
                .body("error", equalTo(ERROR_TITLE_405))
                .body("message", equalTo(ERROR_MESSAGE_405))
                .statusCode(STATUS_CODE_405);
    }
}
