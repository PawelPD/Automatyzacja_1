package com.shop.pages;

import com.shop.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;


public class OrderPage extends TestBase {

    @FindBy(xpath = ".//*[contains(text(),'Wybrany adres będzie stosowany zarówno jako adres osobisty (do faktury) i jako adres dostawy.')]")
    WebElement orderPageText;

    @FindBy(xpath = "Twoje zamówienie zostało potwierdzone")
    WebElement confirmOrderText;

    @FindBy(name = "company")
    WebElement companyText;

    @FindBy(name = "phone")
    WebElement phoneText;

    @FindBy(name = "vat_number")
    WebElement vatnumberText;

    @FindBy(name = "address1")
    WebElement address1Text;

    @FindBy(name = "address2")
    WebElement address2Text;

    @FindBy(name = "postcode")
    WebElement postcodeTekst;

    @FindBy(name = "city")
    WebElement cityText;

    @FindBy(name = "delivery_message")
    WebElement deliveryMessageText;

    @FindBy(name = "confirm-addresses")
    WebElement confirmAddressButton;

    @FindBy(name = "confirmDeliveryOption")
    WebElement confirmDeliveryButton;

    @FindBy(id = "payment-option-2")
    WebElement paymentoptionButton;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement termsCheckbox;

    @FindBy(xpath = "/html/body/section/div/section/div/div[1]/section[4]/div/div[3]/div[1]/button")
    WebElement paymentconfirmationButton;

    @FindBy(xpath = "//*[@id='id-address-delivery-address-4']/footer/a[1]")
    WebElement editAddressButton1;

    @FindBy(xpath = "//*[@id='id-address-delivery-address-5']/footer/a[1]")
    WebElement editAddressButton2;

    @FindBy(xpath = "//*[@id='id-address-delivery-address-6']/footer/a[1]")
    WebElement editAddressButton3;

    @FindBy(xpath = ".//*[contains(text(), 'Dalej')]")
    List<WebElement> editAdressButton;
    //WebElement editAddressButton4;


    @FindBy(xpath = ".//*[contains(text(), 'Dalej')]")
    WebElement customerInfoButton;



    public OrderPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }


    public boolean validateOrderPageText(){
        waitForElement(orderPageText);
        return orderPageText.isDisplayed();
    }

    public boolean validateConfirmOrderText(){
        waitForElement(confirmOrderText);
        return confirmOrderText.isDisplayed();
    }

    public OrderPage companyTextTest()
    {
        waitForElement(companyText);
        companyText.clear();
        companyText.sendKeys("Testowa nazwa firmy");
        return this;
    }

    public OrderPage phoneTextTest()
    {
        waitForElement(phoneText);
        phoneText.clear();
        phoneText.sendKeys("123456789");
        return this;
    }

    public OrderPage vatnumberTextTest()
    {
        waitForElement(vatnumberText);
        vatnumberText.clear();
        vatnumberText.sendKeys("0123456789");
        return this;
    }

    public OrderPage address1TextTest()
    {
        waitForElement(address1Text);
        address1Text.clear();
        address1Text.sendKeys("Adres testowy 1");
        return this;
    }

    public OrderPage address2TextTest()
    {
        waitForElement(address2Text);
        address2Text.clear();
        address2Text.sendKeys("Adres testowy 2");
        return this;
    }

    public OrderPage postcodeTekstTest()
    {
        waitForElement(postcodeTekst);
        postcodeTekst.clear();
        postcodeTekst.sendKeys("00-000");
        return this;
    }

    public OrderPage cityTextTest()
    {
        waitForElement(cityText);
        cityText.clear();
        cityText.sendKeys("Warszawa");
        return this;
    }

    public OrderPage deliveryMessageTextTest()
    {
        waitForElement(deliveryMessageText);
        deliveryMessageText.clear();
        deliveryMessageText.sendKeys("Tekst testowy dostawy");
        return this;
    }

    public OrderPage confirmAddressButtonTest() throws Exception {
        try {
            waitForElement(confirmAddressButton);
            confirmAddressButton.click();
        }catch (Exception e){
            retryingFindClick(confirmAddressButton);
        }
        return this;
    }

    public OrderPage confirmDeliveryButtonTest() throws Exception {
        try {
            waitForElement(confirmDeliveryButton);
            confirmDeliveryButton.click();
        }catch (Exception e){
            retryingFindClick(confirmDeliveryButton);
        }
        return this;
    }

    public OrderPage paymentoptionButtonTest() throws Exception {
        try {
            waitForElement(paymentoptionButton);
            paymentoptionButton.click();
        }catch (Exception e){
            retryingFindClick(paymentoptionButton);
        }
        return this;
    }

    public OrderPage termsCheckboxTest() throws Exception {
        try {
            waitForElement(termsCheckbox);
            termsCheckbox.click();
        }catch (Exception e){
            retryingFindClick(termsCheckbox);
        }
        return this;
    }

    public OrderPage paymentconfirmationBittonTest() throws Exception {
        try {
            waitForElement(paymentconfirmationButton);
            paymentconfirmationButton.click();
        }catch (Exception e){
            retryingFindClick(paymentconfirmationButton);
        }
        return this;
    }

    public OrderPage editAddressButtonTest() throws Exception {
        try {
            waitForElement(editAddressButton1);
            editAddressButton1.click();
        }catch (Exception e){
            try {
                editAddressButton2.click();
            }catch (Exception e2){
                try {
                    editAddressButton3.click();
                }catch (Exception e3){
                    retryingFindClick(editAddressButton3);
                }
            }
        }
        return this;
    }

    public OrderPage editAddressButtonTest2() throws Exception {
        try {
            waitForElement(editAdressButton.get(1));
            editAdressButton.get(1).click();
        }catch (Exception e){
            retryingFindClick(editAdressButton.get(1));
        }
        return this;
    }

    public OrderPage customerInfoButtonTest() throws Exception {
        try {
            waitForElement(customerInfoButton);
            customerInfoButton.click();
        }catch (Exception e){
            retryingFindClick(customerInfoButton);
        }
        return this;
    }


}
