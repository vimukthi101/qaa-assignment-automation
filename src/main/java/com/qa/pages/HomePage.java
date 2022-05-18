package com.qa.pages;

import com.qa.blocks.LeftMenuPanel;
import com.qa.blocks.NavBar;
import com.qa.controller.Controller;
import org.openqa.selenium.By;

public class HomePage extends Controller {
    private static final By HOME_BODY_TEXT = By.xpath("//div[@class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\"]");

    public NavBar getNavBar() {
        return new NavBar();
    }

    public LeftMenuPanel getLeftMenuPanel() {
        return new LeftMenuPanel();
    }

    public String verifyTabTitle() {
        return getTitle();
    }

    public String getHomeBodyText() {
        return getTextFromElement(HOME_BODY_TEXT);
    }
}
