package com.shop.pages;

import com.shop.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public LoginPage doLogin(String user, String pass) throws Exception {
        System.out.println("doLogin");
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
        return this;
    }

    public String homePageTextAfterLogin(){
        waitForElement(homePageText);
        return homePageText.getText();
    }

    public LoginPage goToCookiesAccept() throws Exception {
        try {
            waitForElement(cookiesAccept);
            cookiesAccept.click();
        }catch (Exception e){
            retryingFindClick(cookiesAccept);
        }
        return this;
    }
}
