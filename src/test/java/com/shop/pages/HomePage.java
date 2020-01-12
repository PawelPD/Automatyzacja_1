package com.shop.pages;


import com.shop.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {

    @FindBy(id = "_desktop_logo")
    WebElement homePageLogo;

    @FindBy(xpath="//*[@title='Zaloguj się do swojego konta klienta']")
    WebElement loginButton;

    @FindBy(xpath="//*[@id='main']/header/h1")
    WebElement loginScreen;


    @FindBy(id = "category-3")
    WebElement categoryOdziez;

    @FindBy(id = "category-6")
    WebElement categoryAkcesoria;

    @FindBy(id = "category-7")
    WebElement categorySztuka;

    @FindBy(id = "category-10")
    WebElement categoryPersonalizowane;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }


    public boolean validateHomePage() {
        return homePageLogo.isDisplayed();
    }

    public String validateHomePageTitle() {
        return driver.getTitle();
    }


    public HomePage goToLogin() {
        try {
            loginButton.click();
        }catch (Exception e){
            retryingFindClick(loginButton);
        }

        return this;
    }

    public String validateLoginPageText() {
        return loginScreen.getText();
    }

}