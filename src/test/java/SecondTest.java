import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;


public class SecondTest {

    @Test(priority = 1)
    void setup()
    {

        System.out.println("Opening Browser second class");

    }

    @Test(priority = 2)
    void test() throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //ChromeOptions options = new ChromeOptions();
       // options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://pdsklep.e-kei.pl/");
        System.out.println("Przeglądarka otworzona Second class");
		driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
        driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[3]/div/div[1]/article[1]/div/div[1]/h2/a")).click();
        driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/button")).click();
        //driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[2]/div/div/a")).click();
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshot.png"));
        sleep(5000);
        driver.close();
    }

    @Test(priority = 3)
    void teardown()
    {
        System.out.println("close second class");
    }


}
