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

        private static final String ACOUNT_SID = "ACae78145d496524e13dd1c21778db5477";
        private static final String AUT_TOKEN = "bb586f1cb58e116d21692d846933b947";
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
            Thread.sleep(2000);
            driver.findElement(By.xpath("//div[@class='nav-signin-tooltip-footer']//a[@class='nav-a'][contains(text(),'Start here.')]")).click();
            Thread.sleep(2000);
//                    driver.findElement(By.xpath("//a[@class='nav-a' and @rel='nofollow']")).click();
//            Thread.sleep(2000);
            driver.findElement(By.id("ap_customer_name")).sendKeys("hemilturakhia@gmail.com");
            Thread.sleep(3000);
            driver.findElement(By.className("a-dropdown-prompt")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[@data-value='{\"stringVal\":\"US\"}']")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("ap_phone_number")).sendKeys("9082645538");
            Thread.sleep(2000);
            driver.findElement(By.id("ap_password")).sendKeys("Itachi@123");
            Thread.sleep(2000);
            driver.findElement(By.id("continue")).click();
            Thread.sleep(2000);
            Twilio.init(ACOUNT_SID, AUT_TOKEN);
            String smsBody = getMessage();
            System.out.println(smsBody);
            String OTPNumber = smsBody.replaceAll("[^-? 0-9]", " ");
            System.out.println(OTPNumber);
            driver.findElement(By.id("auth-pv-enter-code")).sendKeys(OTPNumber);
            }

        public static String getMessage() {
            return getMessages()
                    .filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
                    .filter(m -> m.getTo().equals("+19082645538"))
                    .map(Message::getBody)
                    .findFirst()
                    .orElseThrow(IllegalStateException::new);
        }

        private static Stream<Message> getMessages() {
            ResourceSet<Message> message = Message.reader(ACOUNT_SID).read();
            return StreamSupport.stream(message.spliterator(), false);
        }
    }
