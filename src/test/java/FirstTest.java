import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class FirstTest {

    @Test(priority = 1)
    void setup()
    {

        System.out.println("Opening Browser");

    }

    @Test(priority = 2)
    void test()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://pdsklep.e-kei.pl/");
        System.out.println("Przeglądarka otworzona");
        driver.close();
    }

    @Test(priority = 3)
    void teardown()
    {
        System.out.println("close");
    }


}
