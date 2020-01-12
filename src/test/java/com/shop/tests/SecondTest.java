package com.shop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SecondTest {

    @Test
    public void run()
    {
        try {
            Assert.assertTrue(true);
            System.out.println("bez błędu second");
        } catch (Error e) {
            System.out.println("błąd second");
            Reporter.log("Error : " + e.getLocalizedMessage());
        }

    }
}
