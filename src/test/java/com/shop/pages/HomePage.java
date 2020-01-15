package com.shop.pages;


import com.shop.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;


public class HomePage extends TestBase {

    @FindBy(id = "_desktop_logo")
    WebElement homePageLogo;

    @FindBy(xpath = "//*[@id='_desktop_user_info']/div/a/span")
    WebElement loginButton;

    @FindBy(xpath="//*[@id='main']/header/h1")
    WebElement loginScreen;

    @FindBy(xpath = "//*[@id='__cp']/a")
    WebElement cookiesAccept;


    public HomePage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }


    public boolean validateHomePageLogo() {
        return homePageLogo.isDisplayed();
    }

    public String validateHomePageTitle() {
        return driver.getTitle();
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }


    public HomePage goToLogin(){
        try {
            loginButton.click();
            Reporter.log("Wybrano przycisk 'Zaloguj się'");
        }catch (Exception e){
            retryingFindClick(loginButton);
        }

        return this;
    }

    public HomePage goToCookiesAccept(){
        try {
            waitForElement(cookiesAccept);
            cookiesAccept.click();
        }catch (Exception e){
            retryingFindClick(cookiesAccept);
        }
        return this;
    }

    public String validateLoginPageText() {
        return loginScreen.getText();
    }

}