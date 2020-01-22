package com.twitter.tests;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class OtpHandleTests {

        private static final String ACOUNT_SID = "AC0da5e5b22cefb3d106bd8ada0cf6275e";
        private static final String AUT_TOKEN = "dd895cfde90989ccee929be02c96cea6";
        WebDriver driver;

        @BeforeMethod
        public void setUp() {
            System.setProperty("webdriver.chrome.driver", "/home/admin1/Desktop/OnlineBookStore/Twitter/Drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        @Test
        public void forOTPNumber() throws InterruptedException {
            driver.get("https://www.amazon.in/");
            driver.findElement(By.id("nav-link-accountList")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//a[@class='nav-a' and @rel='nofollow']")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("ap_customer_name")).sendKeys("hemilturakhia@gmail.com");
            Thread.sleep(3000);
            driver.findElement(By.className("a-dropdown-prompt")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("auth-country-picker_90")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("ap_phone_number")).sendKeys("4016220124");
            Thread.sleep(2000);
            driver.findElement(By.id("ap_password")).sendKeys("bridgelabz1234");
            Thread.sleep(2000);
            driver.findElement(By.id("continue")).click();
            Thread.sleep(2000);
            Twilio.init(ACOUNT_SID, AUT_TOKEN);
            String smsBody = getMessage();
            System.out.println(smsBody);
            String OTPNumber = smsBody.replaceAll("[^-? 0-9]", " ");
            System.out.println(OTPNumber);
            driver.findElement(By.id("auth-pv-enter-code")).sendKeys(OTPNumber);
            // driver.findElement(By.id("continue")).click();
        }

        public static String getMessage() {
            return getMessages()
                    .filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                    .filter(m -> m.getTo().equals("+14016220124"))
                    .map(Message::getBody)
                    .findFirst()
                    .orElseThrow(IllegalStateException::new);
        }

        private static Stream<Message> getMessages() {
            ResourceSet<Message> message = Message.reader(ACOUNT_SID).read();
            return StreamSupport.stream(message.spliterator(), false);
        }
    }
