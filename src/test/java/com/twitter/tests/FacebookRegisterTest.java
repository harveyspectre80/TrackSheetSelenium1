package com.twitter.tests;

import com.twitter.controller.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static com.twitter.controller.IAutoConstant.CHROME_KEY;
import static com.twitter.controller.IAutoConstant.CHROME_VALUE;

public class FacebookRegisterTest extends BaseClass {

    @Test
    public void facebookRegisterTest() throws InterruptedException {
        driver.findElement(By.xpath("//input[@data-type='text' and @name='firstname']")).sendKeys("Hemil");
        driver.findElement(By.xpath("//input[ @name='lastname']")).sendKeys("Turakhia");
        driver.findElement(By.xpath("//input[ @name=\"reg_email__\"]")).sendKeys("hemilturakhia@gmail.com");
        driver.findElement(By.xpath("//input[ @name=\"reg_email_confirmation__\"]")).sendKeys("hemilturakhia@gmail.com");
        driver.findElement(By.xpath("//input[ @data-type=\"password\"]")).sendKeys("UchihaMadara@123");
        driver.findElement(By.xpath("//select[ @name=\"birthday_day\"]")).sendKeys("23");
        driver.findElement(By.xpath("//select[ @name=\"birthday_month\"]")).sendKeys("Oct");
        driver.findElement(By.xpath("//select[ @name=\"birthday_year\"]")).sendKeys("1997");
        driver.findElement(By.xpath("//input[ @type=\"radio\" and @value=\"2\"]")).click();
        driver.findElement(By.xpath("//button[ @type=\"submit\" and  @name=\"websubmit\"]")).click();
        Thread.sleep(8000);

    }
}
