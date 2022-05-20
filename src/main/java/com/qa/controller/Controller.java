package com.qa.controller;

import com.qa.base.UIBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Controller extends UIBasePage {
    private int timeOut = 10;

    public void scrollToElement(By element) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(element));
    }

    public void clickElement(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void typeText(By locator, String value) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isVisible(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getTextFromElement(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    public int getTotalBooksInTable(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        int count = rows.size();
        return count;
    }

    public String getYearFromTableByBookTitle(By locator, String title) {
        String year = "";
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        for (int r = 0; r < rows.size(); r++) {
            List<WebElement> cells = rows.get(r).findElements(By.tagName("td"));
            if (cells.get(0).getText().equals(title)) {
                year = cells.get(1).getText();
            }
        }
        return year;
    }

    public void clickEditInTableByBookTitle(By locator, String title) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        for (int r = 0; r < rows.size(); r++) {
            List<WebElement> cells = rows.get(r).findElements(By.tagName("td"));
            if (cells.get(0).getText().equals(title)) {
                cells.get(2).click();
            }
        }
    }

    public void clickEditInTableByRowNumber(By locator, int index) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        List<WebElement> cells = rows.get(index).findElements(By.tagName("td"));
        cells.get(2).click();
    }

    public String getBookNameByRowNumber(By locator, int index) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        List<WebElement> cells = rows.get(index).findElements(By.tagName("td"));
        return cells.get(0).getText();
    }

    public void clickDeleteInTableByBookTitle(By locator, String title) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        for (int r = 0; r < rows.size(); r++) {
            List<WebElement> cells = rows.get(r).findElements(By.tagName("td"));
            if (cells.get(0).getText().equals(title)) {
                cells.get(3).click();
            }
        }
    }

    public void clickDeleteInTableByRowNumber(By locator, int index) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeOut);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        List<WebElement> rows = element.findElements(By.tagName("tr"));
        List<WebElement> cells = rows.get(index).findElements(By.tagName("td"));
        cells.get(3).click();
    }
}
