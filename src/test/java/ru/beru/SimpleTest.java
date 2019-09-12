package ru.beru;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTest {
    @Test
    public void Test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kirill\\Share\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://beru.ru/");

        String title = driver.getTitle();
        Assert.assertEquals("Маркетплейс Беру - большой ассортимент товаров из интернет-магазинов с быстрой доставкой и по выгодным ценам", title);

        driver.quit();
    }
}