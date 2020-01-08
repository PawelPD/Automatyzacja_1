import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest {

    public static void main(String[] args) throws InterruptedException {


//System.setProperty("webdriver.chromedriver","C:\\Users\\Pawel_VM\\IdeaProjects\\automatyzacja-testow\\src\\main\\resources\\drivers\\chromedriver.exe");
//WebDriver driver = new ChromeDriver();

System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
WebDriver driver = new ChromeDriver();

driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

driver.get("https://pdsklep.e-kei.pl/");
driver.findElement(By.xpath("/html/body/main/header/div[2]/div/div[1]/div[2]/div[1]/ul/li[2]/a")).click();
driver.findElement(By.xpath("//*[@id=\"category\"]")).click();
driver.findElement(By.xpath("/html/body/main/section/div/div[2]/section/section/div[1]/div/div[2]/div/div[1]/button")).click();
driver.get("https://pdsklep.e-kei.pl/6-akcesoria?order=product.price.asc");
Thread.sleep(5000);
driver.close();

    }
}
