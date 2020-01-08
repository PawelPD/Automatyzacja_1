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
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://pdsklep.e-kei.pl/");
        driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"category\"]")).click();
        driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[1]/div/div[2]/div/div[1]/button")).click();
        driver.get("https://pdsklep.e-kei.pl/6-akcesoria?order=product.price.asc");
        driver.close();
    }

    @Test(priority = 3)
    void teardown()
    {
        System.out.println("close");
    }


}
