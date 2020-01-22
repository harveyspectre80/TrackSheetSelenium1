package com.twitter.tests;

import com.twitter.controller.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FileUploadPopUpHandling extends BaseClass {

    @Test
    public void testName()  throws AWTException, InterruptedException, IOException, IOException {
        driver.get("http://www.indeed.co.in");

        driver.findElement(By.className("icl-TextPromo-linkText")).click();
        driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/div/div/div/div[2]/div/div[1]/div/div[1]/button ")).click();

        //Store the location of the file in clipboard
        //Clipboard
        StringSelection strSel = new StringSelection("Neil-Gaiman.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);

        //Create an object for robot class
        Robot robot = new Robot();
        //Control key in the keyboard
        //Ctrl+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Dimension d1 = new Dimension(1200,1800);
        BufferedImage bufImage = robot.createScreenCapture(new Rectangle(d1));
        File f = new File("/home/admin1/Desktop/OnlineBookStore/Twitter/src/test/resources");
        ImageIO.write(bufImage,"jpg", f);
    }
}
