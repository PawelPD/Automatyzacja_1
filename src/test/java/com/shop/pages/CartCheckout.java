package com.shop.pages;

import com.shop.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;


public class CartCheckout extends TestBase {

    @FindBy(className = "card-block")
    WebElement cartText;

    @FindBy(xpath = "//*[@id='cart-subtotal-products']/span[1]")
    WebElement numberOfItems;

    @FindBy(xpath = "//*[@id='cart-subtotal-shipping']/span[2]")
    WebElement shippingCost;

    @FindBy(xpath = "//*[@id='main']/div/div[2]/div/div[2]/div/a")
    WebElement endCheckoutButton;

    @FindBy(xpath = ".//*[contains(text(), 'Dalej')]")
    WebElement customerInfoButton;

    public CartCheckout() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }


    public String cartCheckoutTitleTest(){
        return driver.getTitle();
    }

    public String numberOfItemsTextTest(){
        waitForElement(numberOfItems);
        return numberOfItems.getText();
    }

    public String cshippingCostTextTest(){
        waitForElement(shippingCost);
        return shippingCost.getText();
    }

    public CartCheckout endCheckoutButtonTest(){
        try {
            waitForElement(endCheckoutButton);
            endCheckoutButton.click();
        }catch (Exception e){
            retryingFindClick(endCheckoutButton);
        }
        Reporter.log("Wybrano przycisk 'Realizuj zamówienie'");
        return this;
    }

    public CartCheckout customerInfoButtonTest(){
        try {
            waitForElement(customerInfoButton);
            customerInfoButton.click();
        }catch (Exception e){
            retryingFindClick(customerInfoButton);
        }
        return this;
    }

}
