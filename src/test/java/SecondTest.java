import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


public class SecondTest {

    @Test(priority = 1)
    void setup()
    {

        System.out.println("Opening Browser second class");

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
        System.out.println("Przeglądarka otworzona Second class");
		driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        driver.close();
    }

	@Test(priority = 3)
    void teardown()
    {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("jakas strona second class");
        driver.get("https://df")
		System.out.println("po second class");
    }


}
