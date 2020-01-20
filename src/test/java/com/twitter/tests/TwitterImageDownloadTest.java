package com.twitter.tests;

import com.twitter.controller.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TwitterImageDownloadTest extends BaseClass {

    @Test
    public void imageDownloadTest() throws AWTException, InterruptedException {
        Actions actions = new Actions(driver);
        Robot robot = new Robot();
//         driver.findElement(By.xpath("/html[1]//div[2]//a[1]/div[1]/div[2]/div[1]/img[1]"));
         actions.contextClick( driver.findElement(By.xpath("//div[@class=\"ProfileCanopy-header u-bgUserColor\"]"))).perform();
         Thread.sleep(1000);
         robot.keyPress(KeyEvent.VK_DOWN);
         robot.keyRelease(KeyEvent.VK_DOWN);
         Thread.sleep(2500);
         robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
        Thread.sleep(2000);
         robot.keyPress(KeyEvent.VK_DOWN);
        robot.keyRelease(KeyEvent.VK_DOWN);
         Thread.sleep(1000);
         robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
         Thread.sleep(2000);
         robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(5000);

    }
}
