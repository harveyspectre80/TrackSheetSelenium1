package com.twitter.screenshot;


import com.twitter.controller.BaseClass;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class TakeScreenshot extends BaseClass {

    public static void captureScreenshot(WebDriver driver,String image) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/home/admin1/Desktop/OnlineBookStore/Twitter/Drivers/chromedriver");
        driver.manage().window().maximize();
        TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
        System.out.println("Driver:"+driver);
        File source = takeScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("/home/admin1/Desktop/OnlineBookStore/Twitter/src/main/resources/" +image + "__actiTIMELoginPage.png");
        FileUtils.copyFile(source,destFile);
    }
}
