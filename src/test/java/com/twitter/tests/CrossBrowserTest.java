package com.twitter.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CrossBrowserTest {

    @Test
    public void crossBrowserTest() {
        System.setProperty("webdriver.chrome.driver", "/home/admin1/Desktop/OnlineBookStore/Twitter/Drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:9018");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://facebook.com");
    }
}