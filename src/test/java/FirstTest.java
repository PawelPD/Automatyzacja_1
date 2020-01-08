import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
        System.setProperty("webdriver.chrome.driver", "1\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
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
