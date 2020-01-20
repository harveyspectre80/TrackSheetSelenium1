package com.twitter.pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HomePage {


    public HomePage(WebDriver webDriver)
    {

        PageFactory.initElements(webDriver,this);
    }


    @FindBy(xpath="//div/div/div/div[3]/a/div")
    private WebElement addTweet;

    @FindBy(xpath = "//*[@id=\"react-root\"]//div[2]/div[1]/div/div/div/div/div/div/div/div[1]/div[1]/div/div/div/div[2]/div/div/div/div")
    private WebElement writeText;

    @FindBy(xpath = "//div[@aria-label='Add photos or video' and @role='button' and @data-focusable=\"true\"]")
    private WebElement addImage;

    @FindBy(xpath = "/html[1]//div/div[1]/div[1]/div/div/div[2]/div[2]/div[1]/div[1]/div[2]/div[4]/div[1]/span[1]")
    //@FindBy(xpath = "//div[@data-testid='tweetButton']")
    private WebElement postTweet;

    @FindBy(xpath = "/html[1]//header[1]//nav[1]/div[1]/div[1]")
    private  WebElement moreOptions;

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    private  WebElement Logout;

    public void setAddTweet()
    {
        addTweet.click();
    }

    public void setPostTweetCriteria(String message) throws AWTException {
        Robot robot = new Robot();
        writeText.sendKeys(message);
        addImage.click();
        robot.setAutoDelay(2200);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.setAutoDelay(2200);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.setAutoDelay(KeyEvent.VK_ENTER);
        postTweet.click();
    }

    public void setLogoutCriteria()
    {
        moreOptions.click();
        Logout.click();
    }
}
