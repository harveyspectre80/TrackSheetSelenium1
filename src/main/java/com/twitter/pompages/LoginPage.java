//package com.twitter.pompages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class LoginPage {
//
//
//    @FindBy(xpath="//a[@class='js-nav EdgeButton EdgeButton--medium EdgeButton--secondary StaticLoggedOutHomePage-buttonLogin']")
//    private WebElement clickLogin;
//
//    @FindBy(xpath = "//input[@placeholder='Phone, email or username']")
//    private WebElement addEmail;
//
//    @FindBy(xpath = "//div[@class='clearfix field']//input[@placeholder='Password']")
//    private WebElement addPassword;
//
//    @FindBy(xpath = "//*[@id=\"page-container\"]/div/div[1]/form/div[2]/button")
//    private  WebElement Login;
//
//    public LoginPage(WebDriver webDriver)
//    {
//
//        PageFactory.initElements(webDriver,this);
//    }
//
//    public  void setOnClickLogin()
//    {
//        clickLogin.click();
//    }
//
//    public void setUpLoginCriteria(String userName, String password)
//    {
//        addEmail.sendKeys(userName);
//        addPassword.sendKeys(password);
//    }
//
//    public void clickLogin()
//    {
//        Login.click();
//    }
//
//}
