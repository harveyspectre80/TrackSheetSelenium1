package com.twitter.controller;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.twitter.controller.IAutoConstant.*;

public class BaseClass  {

    public static WebDriver driver;
    Library library = new Library();


    @BeforeMethod
    public void openApplication() {
        String browser = library.getProperty(CONFIG_PATH, "browser");
        if (browser.equalsIgnoreCase("mozilla")) {
            System.setProperty(MOZILLA_KEY,MOZILLA_VALUE);
            driver = new FirefoxDriver();
            String url = library.getProperty(CONFIG_PATH, "URL1");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.get(url);
        } else if (browser.equals("chrome")) {
       System.setProperty(CHROME_KEY,CHROME_VALUE);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = library.getProperty(CONFIG_PATH, "URL1");
        driver.get(url);
        String implicitTimeOut = library.getProperty(CONFIG_PATH,"ImplicitTimeOut");
        int timeoutPeriod = Integer.parseInt(implicitTimeOut);
        driver.manage().timeouts().implicitlyWait(timeoutPeriod, TimeUnit.SECONDS);
        }
    }

    @AfterMethod
    public void closeApplication()
    {
        driver.close();
    }
}
