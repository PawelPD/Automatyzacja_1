package com.shop.pages;

import com.shop.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Reporter;

import java.util.Random;

import static org.testng.Assert.fail;


public class ShoppingCart extends TestBase {


    Random odziezRandom = new Random();
    Random akcesoriaRandom = new Random();
    Random sztukaRandom = new Random();


    String odziezValue      = Integer.toString(odziezRandom.nextInt(2)+1);
    String akcesoriaValue   = "5";
    //= Integer.toString(akcesoriaRandom.nextInt(10)+1);
    String sztukaValue      = Integer.toString(sztukaRandom.nextInt(7)+1);

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

    @FindBy(xpath = "//*[@id='wrapper']/div/nav/ol/li[2]/a/span")
    public WebElement categoryName;

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

    public ShoppingCart goToCategoryOdziez(){
        try {
            waitForElement(categoryOdziez);
            categoryOdziez.click();
            Reporter.log("Wybrano kategorię 'Odzież'");
        }catch (Exception e){
            retryingFindClick(categoryOdziez);
        }
        return this;
    }

    public ShoppingCart goToCategoryAkcesoria(){
        try {
            waitForElement(categoryAkcesoria);
            categoryAkcesoria.click();
            Reporter.log("Wybrano kategorię 'Akcesoria'");
        }catch (Exception e){
            retryingFindClick(categoryAkcesoria);
        }
        return this;
    }


    public ShoppingCart goToCategorySztuka(){
        try {
            waitForElement(categorySztuka);
            categorySztuka.click();
            Reporter.log("Wybrano kategorię 'Sztuka'");
        }catch (Exception e){
            retryingFindClick(categorySztuka);
        }
        return this;
    }

    public ShoppingCart goToCategoryPersonalizowane(){
        try {
            waitForElement(categoryPersonalizowane);
            categoryPersonalizowane.click();
            Reporter.log("Wybrano kategorię 'Personalizowane'");
        }catch (Exception e){
            retryingFindClick(categoryPersonalizowane);
        }
        return this;
    }

    public ShoppingCart addTextMessageToPersonalizowane(){
        waitForElement(addTextMessage);
        addTextMessage.sendKeys("Tekst testowy 1.");
        Reporter.log("Wprowadzono dostosowany teks");
        try {
            waitForElement(addTextMessageButton);
            addTextMessageButton.click();
            Reporter.log("Wybrano losowy produkt");
        }catch (Exception e){
            retryingFindClick(categoryPersonalizowane);
        }
        return this;
    }


    public ShoppingCart addToCard(){
        try {
            waitForElement(addToCardButton);
            addToCardButton.click();
            Reporter.log("Dodano produkt do koszyka");
        }catch (Exception e){
            retryingFindClick(addToCardButton);
        }
        return this;
    }

    public ShoppingCart continueShopping(){
        try {
            waitForElement(continueShoppingButton);
            continueShoppingButton.click();
            Reporter.log("Wybrano przycisk 'Kontynuuj zakupy'");
        }catch (Exception e){
            retryingFindClick(continueShoppingButton);
        }
        return this;
    }

    public ShoppingCart endShopping(){
        try {
            waitForElement(endShoppingButton);
            endShoppingButton.click();
            Reporter.log("Wybrano przycisk 'Realizuj zamówienie'");
        }catch (Exception e){
            retryingFindClick(endShoppingButton);
        }
        return this;
    }

    public ShoppingCart changeProduct(){
        System.out.println("Uruchomiono zmianę produktu");
        System.out.println(categoryName.getText());
        Reporter.log("PRODUKT NIEDOSTEPNY W MAGAZYNIE, ROZPOCZETO ZMIANĘ PRODUKTU");
        captureScreenshot();
        if(categoryName.getText().equals("Odzież")){
            String odziezValueZmianaWartosci      = Integer.toString(odziezRandom.nextInt(2)+1);
            while (true){
                if(odziezValueZmianaWartosci.equals(odziezValue)){
                    odziezValueZmianaWartosci      = Integer.toString(odziezRandom.nextInt(2)+1);
                }
                else
                    System.out.println("przed break");
                    break;
            }
            odziezFinalXpath = odziezFirstText + odziezValueZmianaWartosci + odziezSecondText;
            goToCategoryOdziez();
            driver.findElement(By.xpath(odziezFinalXpath)).click();
        }
        if(categoryName.getText().equals("Akcesoria")){
            String akcesoriaValueZmianaWartosci      = Integer.toString(akcesoriaRandom.nextInt(10)+1);
            while (true){
                if(akcesoriaValueZmianaWartosci.equals(akcesoriaValue)){
                    akcesoriaValueZmianaWartosci      = Integer.toString(akcesoriaRandom.nextInt(10)+1);
                }
                else
                    System.out.println("przed break");
                    break;
            }
            akcesoriaFinalXpath = akcesoriaFirstText + akcesoriaValueZmianaWartosci + odakcesoriaSecondText;
            goToCategoryAkcesoria();
            driver.findElement(By.xpath(akcesoriaFinalXpath)).click();
        }
        if(categoryName.getText().equals("Sztuka")){

            String sztukaValueZmianaWartosci      = Integer.toString(sztukaRandom.nextInt(7)+1);
            while (true){
                if(sztukaValueZmianaWartosci.equals(sztukaValue)){
                    sztukaValueZmianaWartosci      = Integer.toString(sztukaRandom.nextInt(7)+1);
                }
                else
                    System.out.println("przed break");
                    break;
            }
            sztukaFinalXpath = sztukaFirstText + sztukaValueZmianaWartosci + sztukaSecondText;
            goToCategorySztuka();
            driver.findElement(By.xpath(sztukaFinalXpath)).click();
        }
        return this;
    }

    public ShoppingCart isEnable(WebElement we){
        boolean result = false;
        System.out.println("Blad klikniecia uruchomiono isEnable: " + we.toString());
        if(we.isEnabled()){
            try {
                we.click();
                result = true;
                Reporter.log("Dodano produkt do koszyka");

            } catch (Exception e) {
                captureScreenshot();
                Reporter.log("BŁĄD DODANIA PRODUKTU 1");
                e.printStackTrace();
            }
        }
        else {
            int licznikZmianProduktu = 0;
            while(licznikZmianProduktu < 5){
                changeProduct();
                if(addToCardButton.isEnabled()){
                    try {
                        we.click();
                        result = true;
                        Reporter.log("Dodano produkt do koszyka");
                        break;

                    } catch (Exception e) {
                        captureScreenshot();
                        Reporter.log("BŁĄD DODANIA PRODUKTU 1");
                        e.printStackTrace();
                    }
                }
            }
            if(result == false)
            {
                try {
                    captureScreenshot();
                    Reporter.log("BŁĄD DODANIA PRODUKTU");
                    //fail("bład 1");
                    throw new Exception("Błąd kliknięcia w wybrany element");

                }catch (Exception e) {
                    fail(e.toString());
                    e.printStackTrace();
                }
            }

        }

        return this;
    }

}
