package com.qa.base;

import com.qa.config.EnvSettings;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class UIBasePage {
    private static WebDriver driver;
    private static final String BROWSER = EnvSettings.getInstance().getBrowser();
    private static final String URL = EnvSettings.getInstance().getHost();

    public void initWebDriver() {
        if (BROWSER.equals("chrome")) {
            ChromeDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (BROWSER.equals("firefox")) {
            FirefoxDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return UIBasePage.driver;
    }

    public void openPage() {
        driver.get(URL);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void waitSomeSeconds(int t) {
        driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
    }
}
