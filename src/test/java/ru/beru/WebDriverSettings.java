package ru.beru;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {
    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver78.exe");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @After
    public void close() {
        driver.quit();
    }
}
