package com.qa.constants;

public class Constants {
    //200
    public static final int STATUS_CODE_200 = 200;

    //400
    public static final int STATUS_CODE_400 = 400;
    public static final String ERROR_TITLE_400 = "Bad Request";
    public static final String ERROR_MESSAGE_400 = "Required String parameter 'title' is not present";

    //404
    public static final int STATUS_CODE_404 = 404;

    //405
    public static final int STATUS_CODE_405 = 405;
    public static final String ERROR_TITLE_405 = "Method Not Allowed";
    public static final String ERROR_MESSAGE_405 = "Request method 'DELETE' not supported";

    //books
    public static final String WAR_AND_PEACE_BOOK_TITLE = "War and Peace";
    public static final int WAR_AND_PEACE_BOOK_ID = 1;
    public static final String WAR_AND_PEACE_BOOK_YEAR = "1867";

    //error messages
    public static final String BOOK_NOT_FOUND_EXCEPTION = "Book not found exception";
    public static final String WHITELABEL_ERROR_MESSAGE = "Whitelabel Error Page";
    public static final String TITLE_ERROR_MESSAGE = "Title should have at least 8 characters";

    //endpoints
    public static final String GATEWAY_ENDPOINT = "gateway";

    //other
    public static final String FORWARD_SLASH = "/";
    public static final String EMPTY_STRING = "";

    //numbers
    public static final int NUMBER_ZERO = 0;
    public static final int NUMBER_ONE = 1;
    public static final int NUMBER_TWO = 2;
    public static final int NUMBER_THREE = 3;
    public static final int NUMBER_TEN = 10;
}
