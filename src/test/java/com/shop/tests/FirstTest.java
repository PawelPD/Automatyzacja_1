package com.shop.tests;

import com.shop.base.TestBase;
import com.shop.pages.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ShoppingCart shoppingCart;
    CartCheckout cartCheckout;
    OrderPage orderPage;


    /*
     * Funkcja wykonywana przed każdym testem
     * */
    @BeforeClass(description = "Uruchomienie przeglądarki, Przejście do strony sklepu")
    public void setUp() {

        initialization();
        homePage = new HomePage();
    }


    /*
     * Test polegający na sprawdzeniu dostępności logo strony głównej oraz tytułu wczytanej strony
     * */
    @Test(priority = 0, description = "Strona gllowna")
    public void homeTest() {
        //String title = homePage.validateHomePageTitle();
        //Assert.assertEquals(title, "Sklep Odzieżowy");
        boolean flag = homePage.validateHomePage();
        Assert.assertTrue(flag);
    }

    /*
     * Test przejscia do okna zalogowania"
     * */
    @Test(priority = 1, description = "Przejście do ekranu logowania")
    public void goToLoginPageTest() throws InterruptedException {
        homePage = new HomePage();
        loginPage = new LoginPage();
        Thread.sleep(5000);
        homePage.goToLogin();
        //String loginText = homePage.validateLoginPageText();
        //Assert.assertEquals(loginText, "Zaloguj się do swojego konta");
    }

    @Test(priority = 2, description = "Logowania do konta klienta")
    public  void loginTest(){
        loginPage = new LoginPage();
        //String title2 = loginPage.validateLoginPageTitle();
        //Assert.assertEquals(title2, "Nazwa użytkowika");
        loginPage.doLogin(prop.getProperty("user"),prop.getProperty("pass"));
        //String title3 = loginPage.homePageTextAfterLogin();
        //Assert.assertEquals(title3, "Twoje konto");
        loginPage.goToCookiesAccept();
    }

    @Test(priority = 3, description = "Tworzenie koszyka - kategoria odziez")
    public  void shoppingCartOdziezTest() throws InterruptedException {
        shoppingCart = new ShoppingCart();
        shoppingCart.goToCategoryOdziez();
        //String category = shoppingCart.categoryTextTest();
        //Assert.assertEquals(category, "ODZIEŻ");
        driver.findElement(By.xpath(shoppingCart.odziezFinalXpath)).click();
        shoppingCart.addToCard();
        shoppingCart.continueShopping();
    }

    @Test(priority = 4, description = "Tworzenie koszyka - kategoria akcesoria")
    public  void shoppingCartAkcesoriaTest() throws InterruptedException {
        shoppingCart = new ShoppingCart();
        shoppingCart.goToCategoryAkcesoria();
        //String category = shoppingCart.categoryTextTest();
        //Assert.assertEquals(category, "AKCESORIA");
        driver.findElement(By.xpath(shoppingCart.akcesoriaFinalXpath)).click();
        shoppingCart.addToCard();
        shoppingCart.continueShopping();
    }

    @Test(priority = 5, description = "Tworzenie koszyka - kategoria sztuka")
    public  void shoppingCartSztukaTest() throws InterruptedException {
        shoppingCart = new ShoppingCart();
        shoppingCart.goToCategorySztuka();
        //String category = shoppingCart.categoryTextTest();
        //Assert.assertEquals(category, "SZTUKA");
        driver.findElement(By.xpath(shoppingCart.sztukaFinalXpath)).click();
        shoppingCart.addToCard();
        shoppingCart.continueShopping();
    }

    @Test(priority = 6, description = "Tworzenie koszyka - kategoria personalizowane")
    public  void shoppingCartPersonalizowaneTest() throws InterruptedException {
        shoppingCart = new ShoppingCart();
        shoppingCart.goToCategoryPersonalizowane();
        //String category = shoppingCart.categoryTextTest();
        //Assert.assertEquals(category, "PERSONALIZOWANE");
        driver.findElement(By.xpath(shoppingCart.personalizowaneFinalXpath)).click();
        shoppingCart.addTextMessageToPersonalizowane();
        //String message = shoppingCart.categoryTextTest();
        //Assert.assertEquals(message, "Twoje dostosowywanie: tekst testowy 1.");
        shoppingCart.addToCard();
        shoppingCart.endShopping();
    }

    @Test(priority = 7, description = "Test utworzonego korzyka")
    public  void shoppingCartCheckoutTest() throws InterruptedException {
        cartCheckout = new CartCheckout();
        //String cartText = cartCheckout.cartCheckoutTextTest();
        //Assert.assertEquals(cartText, "KOSZYK");
        //String numberOfItems = cartCheckout.numberOfItemsTextTest();
        //Assert.assertEquals(numberOfItems, "4 sztuk");
        //String shippingCost = cartCheckout.cshippingCostTextTest();
        //Assert.assertEquals(shippingCost, "15,00 zł");
        cartCheckout.endCheckoutButtonTest();
    }

    @Test(priority = 8, description = "Test podsumowania i platnosci")
    public  void shoppingPaymentTest() throws InterruptedException {
        orderPage = new OrderPage();
        boolean flag1 = orderPage.validateOrderPageText();
        Assert.assertTrue(flag1);
        orderPage.editAddressButtonTest();
        orderPage.companyTextTest();
        orderPage.phoneTextTest();
        orderPage.vatnumberTextTest();
        orderPage.address1TextTest();
        orderPage.address2TextTest();
        orderPage.postcodeTekstTest();
        orderPage.cityTextTest();
        orderPage.confirmAddressButtonTest();
        orderPage.deliveryMessageTextTest();
        orderPage.confirmDeliveryButtonTest();
        orderPage.paymentoptionButtonTest();
        orderPage.termsCheckboxTest();
        orderPage.paymentconfirmationBittonTest();
        boolean flag2 = orderPage.validateConfirmOrderText();
        Assert.assertTrue(flag2);
    }


    /*
     * Funkcja wykonywana po zakończeniu testów - zgaszenie przeglądarki + robienie zrzutów z błędami
     * */
    @AfterMethod(description = "Wykonanie")
    public void getScreen(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                captureScreenshot();
                driver.quit();
            } catch (Exception e) {
            }
        }
    }

    /*Gaszenie przeglądarki po zakończeniu testów*/
    @AfterClass(description = "Zamknięcie przeglądarki")
    public void closeBrowser() {
        driver.quit();
    }
}