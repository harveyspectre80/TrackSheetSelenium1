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
        Alert alert = driver.switchTo().alert();
        alert.accept();
        // alert.dismiss(); // is for cancel button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("C:\\Users\\user\\Desktop\\getandpost.png");
        Thread.sleep(5000);
    }
}
