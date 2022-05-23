package com.qa.tests.api;

import com.qa.base.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static com.qa.constants.Constants.BOOK_NOT_FOUND_EXCEPTION;
import static com.qa.constants.Constants.ERROR_MESSAGE_405;
import static com.qa.constants.Constants.ERROR_TITLE_400;
import static com.qa.constants.Constants.ERROR_TITLE_405;
import static com.qa.constants.Constants.FORWARD_SLASH;
import static com.qa.constants.Constants.GATEWAY_ENDPOINT;
import static com.qa.constants.Constants.NUMBER_ONE;
import static com.qa.constants.Constants.STATUS_CODE_200;
import static com.qa.constants.Constants.STATUS_CODE_400;
import static com.qa.constants.Constants.STATUS_CODE_404;
import static com.qa.constants.Constants.STATUS_CODE_405;
import static com.qa.constants.Constants.WAR_AND_PEACE_BOOK_ID;
import static com.qa.constants.Constants.WAR_AND_PEACE_BOOK_TITLE;
import static com.qa.constants.Constants.WAR_AND_PEACE_BOOK_YEAR;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static org.hamcrest.core.IsEqual.equalTo;

public class TC004_GetGateway extends ApiBaseTest {

    @Test
    @Description("Verify the Get Books By id success API flow")
    @Severity(BLOCKER)
    @Story("As a user, I should be able to search by book ID")
    public void verifySuccessFlow() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .get(FORWARD_SLASH + WAR_AND_PEACE_BOOK_ID + FORWARD_SLASH + GATEWAY_ENDPOINT)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("title", equalTo(WAR_AND_PEACE_BOOK_TITLE))
                .body("year", equalTo(WAR_AND_PEACE_BOOK_YEAR))
                .statusCode(STATUS_CODE_200);
    }

    @Test
    @Description("Verify the Get Books By id API Book not found scenario")
    @Severity(CRITICAL)
    @Story("As a user, I should be able to get error message when the book is not found")
    public void verifyBookNotFoundScenario() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .get(FORWARD_SLASH + 123 + FORWARD_SLASH + GATEWAY_ENDPOINT)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("message", equalTo(BOOK_NOT_FOUND_EXCEPTION))
                .body("code", equalTo(NUMBER_ONE))
                .statusCode(STATUS_CODE_404);
    }

    @Test
    @Description("Verify the Get Books By id API with String ID")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get error message when a String was sent as an ID")
    public void verifyWithStringId() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .get(FORWARD_SLASH + "abc" + FORWARD_SLASH + GATEWAY_ENDPOINT)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_400))
                .body("error", equalTo(ERROR_TITLE_400))
                .statusCode(STATUS_CODE_400);
    }

    @Test
    @Description("Verify the Get Books By id API with different HTTP method")
    @Severity(NORMAL)
    @Story("As a user, I should be able to get error message for a different HTTP method")
    public void verifyWithDifferentHttpMethod() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .delete(FORWARD_SLASH + WAR_AND_PEACE_BOOK_ID + FORWARD_SLASH + GATEWAY_ENDPOINT)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("status", equalTo(STATUS_CODE_405))
                .body("error", equalTo(ERROR_TITLE_405))
                .body("message", equalTo(ERROR_MESSAGE_405))
                .statusCode(STATUS_CODE_405);
    }
}
