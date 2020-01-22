package com.twitter.tests;

import com.twitter.controller.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FileUploadpopupTest extends BaseClass {

    @Test
    public void testName() throws InterruptedException{
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("/home/admin1/Desktop/OnlineBookStore/Twitter/src/main/resources/ImageMon Jan 20 10:30:59 IST 2020__actiTIMELoginPage.png");
        Thread.sleep(8000);
    }
}
