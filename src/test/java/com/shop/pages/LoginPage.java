package com.shop.pages;

import com.shop.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;


public class LoginPage extends TestBase {

    @FindBy(name = "email")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(id = "submit-login")
    WebElement submit;

    @FindBy(xpath = "//*[@id='main']/header/h1")
    WebElement homePageText;

    @FindBy(xpath = "//*[@id='__cp']/a")
    WebElement cookiesAccept;

    public LoginPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }

    public String validatePageAfterLoginTitle() {
        return driver.getTitle();
    }

    public LoginPage doLogin(String user, String pass){
        waitForElement(username);
        waitForElement(password);
        username.clear();
        password.clear();
        username.sendKeys(user);
        password.sendKeys(pass);
        try {
            waitForElement(submit);
            submit.click();
        }catch (Exception e){
            retryingFindClick(submit);
        }
        Reporter.log("Wprowadzono dane logowania i wybrano przycisk 'Zaloguj się'");
        return this;
    }

    public String homePageTextAfterLogin(){
        waitForElement(homePageText);
        return homePageText.getText();
    }

}
