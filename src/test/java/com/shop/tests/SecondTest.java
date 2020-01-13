package com.shop.tests;

import com.shop.base.TestBase;
import com.shop.pages.*;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTest extends TestBase {

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
        Thread.sleep(1000);
        homePage.goToCookiesAccept();
        Thread.sleep(1000);
        homePage.goToLogin();
        //String loginText = homePage.validateLoginPageText();
        //Assert.assertEquals(loginText, "Zaloguj się do swojego konta");
    }

    @Test(priority = 2, description = "Logowania do konta klienta")
    public  void loginTest() throws Exception {
        loginPage = new LoginPage();
        Thread.sleep(500);
        //String title2 = loginPage.validateLoginPageTitle();
        //Assert.assertEquals(title2, "Nazwa użytkowika");
        loginPage.doLogin(prop.getProperty("user"),prop.getProperty("pass"));
        //String title3 = loginPage.homePageTextAfterLogin();
        //Assert.assertEquals(title3, "Twoje konto");
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