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
    public void goToLoginPageTest() throws Exception {
        homePage = new HomePage();
        loginPage = new LoginPage();

        //Thread.sleep(1000);
        loginPage.goToCookiesAccept();
        //Thread.sleep(1000);
        homePage.goToLogin();
        //String loginText = homePage.validateLoginPageText();
        //Assert.assertEquals(loginText, "Zaloguj się do swojego konta");
    }

    @Test(priority = 2, description = "Logowania do konta klienta")
    public  void loginTest() throws Exception {
        loginPage = new LoginPage();
        //Thread.sleep(500);
        //String title2 = loginPage.validateLoginPageTitle();
        //Assert.assertEquals(title2, "Nazwa użytkowika");
        loginPage.doLogin(prop.getProperty("user"),prop.getProperty("pass"));
        //String title3 = loginPage.homePageTextAfterLogin();
        //Assert.assertEquals(title3, "Twoje konto");
    }

    @Test(priority = 3, description = "Tworzenie koszyka - kategoria odziez")
    public  void shoppingCartOdziezTest() throws Exception {
        shoppingCart = new ShoppingCart();
        //Thread.sleep(500);
        shoppingCart.goToCategoryOdziez();
        //String category = shoppingCart.categoryTextTest();
        //Assert.assertEquals(category, "ODZIEŻ");
        //Thread.sleep(500);
        driver.findElement(By.xpath(shoppingCart.odziezFinalXpath)).click();
        //Thread.sleep(500);
        shoppingCart.addToCard();
        //Thread.sleep(500);
        shoppingCart.continueShopping();
    }

    @Test(priority = 4, description = "Tworzenie koszyka - kategoria akcesoria")
    public  void shoppingCartAkcesoriaTest() throws Exception {
        shoppingCart = new ShoppingCart();
        //Thread.sleep(500);
        shoppingCart.goToCategoryAkcesoria();
        //String category = shoppingCart.categoryTextTest();
        //Assert.assertEquals(category, "AKCESORIA");
        //Thread.sleep(500);
        driver.findElement(By.xpath(shoppingCart.akcesoriaFinalXpath)).click();
        //Thread.sleep(500);
        shoppingCart.addToCard();
        //Thread.sleep(500);
        shoppingCart.continueShopping();
    }

    @Test(priority = 5, description = "Tworzenie koszyka - kategoria sztuka")
    public  void shoppingCartSztukaTest() throws Exception {
        shoppingCart = new ShoppingCart();
        //Thread.sleep(500);
        shoppingCart.goToCategorySztuka();
        //String category = shoppingCart.categoryTextTest();
        //Assert.assertEquals(category, "SZTUKA");
        //Thread.sleep(500);
        driver.findElement(By.xpath(shoppingCart.sztukaFinalXpath)).click();
        //Thread.sleep(500);
        shoppingCart.addToCard();
        //Thread.sleep(500);
        shoppingCart.continueShopping();
    }

    @Test(priority = 6, description = "Tworzenie koszyka - kategoria personalizowane")
    public  void shoppingCartPersonalizowaneTest() throws Exception {
        shoppingCart = new ShoppingCart();
        //Thread.sleep(500);
        shoppingCart.goToCategoryPersonalizowane();
        //String category = shoppingCart.categoryTextTest();
        //Assert.assertEquals(category, "PERSONALIZOWANE");
        //Thread.sleep(500);
        driver.findElement(By.xpath(shoppingCart.personalizowaneFinalXpath)).click();
        //Thread.sleep(500);
        shoppingCart.addTextMessageToPersonalizowane();
        //String message = shoppingCart.categoryTextTest();
        //Assert.assertEquals(message, "Twoje dostosowywanie: tekst testowy 1.");
        //Thread.sleep(500);
        shoppingCart.addToCard();
        //Thread.sleep(500);
        shoppingCart.endShopping();
    }

    @Test(priority = 7, description = "Test utworzonego korzyka")
    public  void shoppingCartCheckoutTest() throws Exception {
        cartCheckout = new CartCheckout();
        //String cartText = cartCheckout.cartCheckoutTextTest();
        //Assert.assertEquals(cartText, "KOSZYK");
        //String numberOfItems = cartCheckout.numberOfItemsTextTest();
        //Assert.assertEquals(numberOfItems, "4 sztuk");
        //String shippingCost = cartCheckout.cshippingCostTextTest();
        //Assert.assertEquals(shippingCost, "15,00 zł");
        //Thread.sleep(500);
        cartCheckout.endCheckoutButtonTest();
    }

    @Test(priority = 8, description = "Test podsumowania i platnosci")
    public  void shoppingPaymentTest() throws Exception {
        orderPage = new OrderPage();
        orderPage.editAddressButtonTest2();
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
        boolean flag2 = orderPage.validateOrderPageTite();
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