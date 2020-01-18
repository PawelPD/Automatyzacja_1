package com.shop.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class TestBase {
    public static WebDriver driver;

    /*
     * Zmienna odpowiedzialna za przekazywanie parametrów dla poszczególnych środowisk
     * */
    public static Properties prop;
    /*
     * Ustawienia time-outów podczas ładowania stron
     * */
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 5;
    public static final int WINDOW_SIZE_WIDTH = 1080;
    public static final int WINDOW_SIZE_HEIGHT = 1920;

    public static String todayStr;

    /*
     * Wczytanie ustawień z pliku properties
     * */
    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("src/config/shop.properties");
            prop.load(ip);
            /*System.out.println(prop.getProperty("url"));
            System.out.println(prop.getProperty("user"));
            System.out.println(prop.getProperty("pass"));*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * Inicjalizacja drivera ff, maksymalizacja okna przeglądarki, wyczyszczenie ciasteczek, wczytanie adresu strony
     * */

        public static void initialization() {
            System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
            //ChromeOptions options = new ChromeOptions();

            //options.addArguments("--window-size=1920,1080");
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            driver = new ChromeDriver();
            //driver.get(prop.getProperty("url"));
            setDriverDimGetURL();
        }

    private static void setDriverDimGetURL() {
        driver.manage().deleteAllCookies();
        //driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }


    public String getCurrentDate() {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    /*
     * Metoda odpowiedzialna za zrobienie zrzutu ekranu w momencie wystąpienia wyjątku w aplikacji
     * */
    public void captureScreenshot() {

        try {
            ((ChromeDriver) driver).executeScript("document.body.style.transform = 'scale(0.85)'");
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("screenshots/"+getCurrentDate()+".png"));
            System.out.println("Wykonano zrzut ekranu");
        } catch (Exception e) {
            System.out.println("Wystąpił wyjątek" + e.getMessage());
        }
    }





    public void waitForElement(String locator) {

        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

    }

    public void waitForElementVisivility(WebElement we) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(we));
    }

    public void waitForElement(WebElement we) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(we));
    }

    public void assertAndClick(String locator) {

        assertElementPresentByXpath(locator);
        driver.findElement(By.xpath(locator)).click();
    }

    public void assertAndType(String locator, String text) {

        assertElementPresentByXpath(locator);
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }

    public void assertElementPresentByXpath(String locator) {
        System.out.println("# Verifying element.");
        Assert.assertTrue(isElementPresent(locator), "Element " + locator + " not found.");
    }

    public void assertElementNotPresentByXpath(String locator) {
        System.out.println("# Verifying element.");
        Assert.assertFalse(isElementPresent(locator), "Element " + locator + " is found.");
    }

    public boolean isElementPresent(String locator) {
        try {
            driver.findElement(By.xpath(locator));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementVisible(String locator) {

        try {
            return driver.findElement(By.xpath(locator)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementVisible(WebElement we) {

        try {
            return we.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void assertElementVisible(String locator, boolean isVisible) {
        System.out.println("# Verifying element visibility.");

        if (isVisible)
            Assert.assertTrue(isElementVisible(locator), "Element " + locator + " should be visible.");
        else
            Assert.assertFalse(isElementVisible(locator),
                    "Element " + locator + " should not be visible.");
    }

    public void assertElementVisible(WebElement we, boolean isVisible) {
        System.out.println("# Verifying element visibility.");

        if (isVisible)
            Assert.assertTrue(isElementVisible(we), "WebElement " + " should be visible.");
        else
            Assert.assertFalse(isElementVisible(we),
                    "WevElement " + " should not be visible.");
    }

    public void waitForElementVisible(WebElement we) {

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(we));
    }

    public void waitForElementVisible(String locator) {

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementInVisible(String locator) {

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitForElementInVisible(WebElement we) {

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.invisibilityOf(we));
    }

    public WebElement getWebElement(String xpath) {

        return driver.findElement(By.xpath(xpath));

    }

    public boolean jestWybraneNarzedzie(WebElement we) {
        String aClass = we.getAttribute("class");
        return aClass.contains("wybrane-narzedzie") || aClass.contains("zaznacz-narzedzie");
    }

    public boolean retryingFindClick(By by) {
        boolean result = false;
        int attempts = 0;
        System.out.println("Blad klikniecia uruchomiono retryingFindClick");
        while (attempts < 3) {
            try {
                System.out.println("retryingFindClick proba: " + attempts);
                driver.findElement(by).click();
                result = true;
                break;
            } catch (Exception e) {
            }

            attempts++;
        }
        return result;
    }

    public boolean retryingFindClick(WebElement we){
        boolean result = false;
        int attempts = 0;
        System.out.println("Blad klikniecia uruchomiono retryingFindClick: " + we.toString());
        while (attempts < 3) {
            try {
                System.out.println("retryingFindClick proba: " + attempts);
                we.click();
                result = true;
                break;
            } catch (Exception e) {
            }

            attempts++;
            if (attempts == 3){
                try {
                    captureScreenshot();
                    throw new Exception("Błąd kliknięcia w wybrany element");
                } catch (Exception e) {
                    fail(e.toString());
                    e.printStackTrace();
                }

            }
        }
        return result;
    }


}
