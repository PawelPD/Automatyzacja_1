package com.shop.pages;

import com.shop.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.Random;


public class ShoppingCart extends TestBase {

    //WebDriverWait wait = new WebDriverWait(driver, 10);

    Random odziezRandom = new Random();
    Random akcesoriaRandom = new Random();
    Random sztukaRandom = new Random();


    String odziezValue          = Integer.toString(odziezRandom.nextInt(1)+1);
    String akcesoriaValue       = Integer.toString(akcesoriaRandom.nextInt(9)+1);
    String sztukaValue          = Integer.toString(sztukaRandom.nextInt(6)+1);

    String odziezFirstText = "//*[@id='js-product-list']/div[1]/article[";
    String odziezSecondText = "]";
    public String odziezFinalXpath = odziezFirstText + odziezValue + odziezSecondText;

    String akcesoriaFirstText = "//*[@id='js-product-list']/div[1]/article[";
    String odakcesoriaSecondText = "]";
    public String akcesoriaFinalXpath = akcesoriaFirstText + akcesoriaValue + odakcesoriaSecondText;

    String sztukaFirstText = "//*[@id='js-product-list']/div[1]/article[";
    String sztukaSecondText = "]";
    public String sztukaFinalXpath = sztukaFirstText + sztukaValue + sztukaSecondText;

    public String personalizowaneFinalXpath = "//*[@id='js-product-list']/div[1]/article[1]";


    @FindBy(xpath = "//*[@id='js-product-list-header']/div/h1")
    public WebElement categoryText;

    @FindBy(className = "customization-message")
    public WebElement messageText;

    @FindBy(id = "category-3")
    WebElement categoryOdziez;

    @FindBy(id = "category-6")
    WebElement categoryAkcesoria;

    @FindBy(id = "category-9")
    WebElement categorySztuka;

    @FindBy(id = "category-10")
    WebElement categoryPersonalizowane;

    @FindBy(className = "product-message")
    public WebElement addTextMessage;

    @FindBy(name = "submitCustomizedData")
    public WebElement addTextMessageButton;

    @FindBy(className = "add-to-cart")
    public WebElement addToCardButton;

    @FindBy(xpath = ".//*[contains(text(), 'Kontynuuj zakupy')]")
    public WebElement continueShoppingButton;

    @FindBy(xpath = "//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a")
    WebElement endShoppingButton;

    public ShoppingCart() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }

    public String categoryTextTest(){
        waitForElement(categoryText);
        return categoryText.getText();
    }

    public String messageTextTest(){
        waitForElement(messageText);
        return messageText.getText();
    }

    public ShoppingCart goToCategoryOdziez() throws Exception {
        try {
            waitForElement(categoryOdziez);
            categoryOdziez.click();
        }catch (Exception e){
            retryingFindClick(categoryOdziez);
        }
        return new ShoppingCart();
    }

    public ShoppingCart goToCategoryAkcesoria() throws Exception {
        try {
            waitForElement(categoryAkcesoria);
            categoryAkcesoria.click();
        }catch (Exception e){
            retryingFindClick(categoryAkcesoria);
        }
        return new ShoppingCart();
    }


    public ShoppingCart goToCategorySztuka() throws Exception {
        try {
            waitForElement(categorySztuka);
            categorySztuka.click();
        }catch (Exception e){
            retryingFindClick(categorySztuka);
        }
        return new ShoppingCart();
    }

    public ShoppingCart goToCategoryPersonalizowane() throws Exception {
        try {
            waitForElement(categoryPersonalizowane);
            categoryPersonalizowane.click();
        }catch (Exception e){
            retryingFindClick(categoryPersonalizowane);
        }
        return new ShoppingCart();
    }

    public ShoppingCart addTextMessageToPersonalizowane() throws Exception {
        waitForElement(addTextMessage);
        addTextMessage.sendKeys("Tekst testowy 1.");
        try {
            waitForElement(addTextMessageButton);
            addTextMessageButton.click();
        }catch (Exception e){
            retryingFindClick(categoryPersonalizowane);
        }
        return new ShoppingCart();
    }


    public ShoppingCart addToCard() throws Exception {
        try {
            waitForElement(addToCardButton);
            addToCardButton.click();
        }catch (Exception e){
            retryingFindClick(addToCardButton);
        }
        return this;
    }

    public ShoppingCart continueShopping() throws Exception {
        try {
            waitForElement(continueShoppingButton);
            continueShoppingButton.click();
        }catch (Exception e){
            retryingFindClick(continueShoppingButton);
        }
        return this;
    }

    public ShoppingCart endShopping() throws Exception {
        try {
            waitForElement(endShoppingButton);
            endShoppingButton.click();
        }catch (Exception e){
            retryingFindClick(endShoppingButton);
        }
        return this;
    }

}