package com.qa.tests.api;

import com.qa.base.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.collection.IsCollectionWithSize;
import org.testng.annotations.Test;

import static com.qa.constants.Constants.EMPTY_STRING;
import static com.qa.constants.Constants.ERROR_MESSAGE_400;
import static com.qa.constants.Constants.ERROR_MESSAGE_405;
import static com.qa.constants.Constants.ERROR_TITLE_400;
import static com.qa.constants.Constants.ERROR_TITLE_405;
import static com.qa.constants.Constants.STATUS_CODE_200;
import static com.qa.constants.Constants.STATUS_CODE_400;
import static com.qa.constants.Constants.STATUS_CODE_405;
import static com.qa.constants.Constants.WAR_AND_PEACE_BOOK_TITLE;
import static com.qa.constants.Constants.WAR_AND_PEACE_BOOK_YEAR;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.hamcrest.core.IsEqual.equalTo;

public class TC002_GetBookByTitleApi extends ApiBaseTest {
    private static final String TITLE_PARAM_KEY = "title";
    private static final String YEAR_PARAM_KEY = "year";

    @Test
    @Description("Verify the Get Books By Title success API flow")
    @Severity(BLOCKER)
    @Story("As a user, I should be able to search by book title")
    public void verifySuccessFlow() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .queryParam(TITLE_PARAM_KEY, WAR_AND_PEACE_BOOK_TITLE)
                .get()
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("[0].title", equalTo(WAR_AND_PEACE_BOOK_TITLE))
                .body("[0].year", equalTo(WAR_AND_PEACE_BOOK_YEAR))
                .statusCode(STATUS_CODE_200);
    }

    @Test
    @Description("Verify the Get Books By Title API with empty search String")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get all the books for empty title")
    public void verifyWithEmptySearchValue() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .queryParam(TITLE_PARAM_KEY, (Object) null)
                .get()
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("[0].title", equalTo(WAR_AND_PEACE_BOOK_TITLE))
                .body("[0].year", equalTo(WAR_AND_PEACE_BOOK_YEAR))
                .statusCode(STATUS_CODE_200);
    }

    @Test
    @Description("Verify the Get Books By Title API with non matching search String")
    @Severity(CRITICAL)
    @Story("As a user, I should be able to get empty result for non matching title")
    public void verifyWithNonMatchingSearchValue() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .queryParam(TITLE_PARAM_KEY, "xyz")
                .get()
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body(TITLE_PARAM_KEY, IsCollectionWithSize.hasSize(0))
                .statusCode(STATUS_CODE_200);
    }

    @Test
    @Description("Verify the Get Books By Title API without the search key")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get error when send the request without the search key")
    public void verifySendingTheRequestWithoutKey() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .queryParam(EMPTY_STRING, EMPTY_STRING)
                .get()
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_400))
                .body("error", equalTo(ERROR_TITLE_400))
                .body("message", equalTo(ERROR_MESSAGE_400))
                .statusCode(STATUS_CODE_400);
    }

    @Test
    @Description("Verify the Get Books By Title API with invalid search key")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get error when send the request with an invalid search key")
    public void verifySendingTheRequestWithInvalidKey() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .queryParam(YEAR_PARAM_KEY, WAR_AND_PEACE_BOOK_TITLE)
                .get()
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_400))
                .body("error", equalTo(ERROR_TITLE_400))
                .body("message", equalTo(ERROR_MESSAGE_400))
                .statusCode(STATUS_CODE_400);
    }

    @Test
    @Description("Verify the Get Books By Title API with wrong HTTP method")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get error when send the request with wrong HTTP method")
    public void verifySendingTheRequestWithDifferentHttpMethod() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .queryParam(TITLE_PARAM_KEY, WAR_AND_PEACE_BOOK_TITLE)
                .delete()
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_405))
                .body("error", equalTo(ERROR_TITLE_405))
                .body("message", equalTo(ERROR_MESSAGE_405))
                .statusCode(STATUS_CODE_405);
    }
}
