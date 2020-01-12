package com.shop.pages;

import com.shop.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CartCheckout extends TestBase {

    @FindBy(className = "card-block")
    WebElement cartText;

    @FindBy(xpath = "//*[@id='cart-subtotal-products']/span[1]")
    WebElement numberOfItems;

    @FindBy(xpath = "//*[@id='cart-subtotal-shipping']/span[2]")
    WebElement shippingCost;

    @FindBy(xpath = ".//*[contains(text(), 'Realizuj zamówienie')]")
    WebElement endCheckoutButton;

    public CartCheckout() {
        PageFactory.initElements(driver, this);
    }


    public String cartCheckoutTextTest(){
        waitForElement(cartText);
        return cartText.getText();
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
        return this;
    }

}
