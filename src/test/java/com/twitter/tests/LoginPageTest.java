package com.twitter.tests;

import com.twitter.controller.BaseClass;
import com.twitter.screenshot.ItemListener;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

@Listeners(ItemListener.class)
public class LoginPageTest extends BaseClass {

    @Test
    public void loginTwitterTest() throws InterruptedException, AWTException {
        Robot robot = new Robot();
        driver.get("https://twitter.com");
        WebElement Login = driver.findElement(By.xpath("//a[@class='js-nav EdgeButton EdgeButton--medium EdgeButton--secondary StaticLoggedOutHomePage-buttonLogin']"));
        Login.click();
        Thread.sleep(500);
        WebElement emailid = driver.findElement(By.xpath("//input[@placeholder='Phone, email or username']"));
        emailid.sendKeys("meghshah50@yahoo.com");
        WebElement pass = driver.findElement(By.xpath("//div[@class='clearfix field']//input[@placeholder='Password']"));
        pass.sendKeys("787898");
        WebElement login1 = driver.findElement(By.xpath("//*[@id=\"page-container\"]/div/div[1]/form/div[2]/button"));
        login1.click();
        WebElement moreOptions = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[1]/div[1]/div[1]/div[2]/nav[1]/div[1]/div[1]"));
        moreOptions.click();
        Thread.sleep(3000);
        WebElement Logout = driver.findElement(By.xpath("//span[contains(text(),'Log out')]"));
        Logout.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"react-root\"]//div[3]/div[2]"));
    }
    }
