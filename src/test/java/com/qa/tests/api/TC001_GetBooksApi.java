package com.qa.tests.api;

import com.qa.base.ApiBaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static com.qa.constants.Constants.ERROR_MESSAGE_405;
import static com.qa.constants.Constants.ERROR_TITLE_405;
import static com.qa.constants.Constants.FORWARD_SLASH;
import static com.qa.constants.Constants.STATUS_CODE_200;
import static com.qa.constants.Constants.STATUS_CODE_405;
import static com.qa.constants.Constants.WAR_AND_PEACE_BOOK_TITLE;
import static com.qa.constants.Constants.WAR_AND_PEACE_BOOK_YEAR;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.hamcrest.core.IsEqual.equalTo;

public class TC001_GetBooksApi extends ApiBaseTest {

    @Test
    @Description("Verify the Get Books success API flow")
    @Severity(BLOCKER)
    @Story("As a user, I should be able to get book list via GET API call")
    public void verifySuccessFlow() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
                .get(FORWARD_SLASH)
                .then()
                .log().ifError()
                .contentType(ContentType.JSON)
                .body("[0].title", equalTo(WAR_AND_PEACE_BOOK_TITLE))
                .body("[0].year", equalTo(WAR_AND_PEACE_BOOK_YEAR))
                .statusCode(STATUS_CODE_200);
    }

    @Test
    @Description("Verify the Get Books error API flow for wrong HTTP method")
    @Severity(CRITICAL)
    @Story("As a user, I should be able to get error for API with wrong HTTP method")
    public void verifyWrongHttpMethodFlow() {
        RestAssured
                .given().log().ifValidationFails()
                .when()
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
