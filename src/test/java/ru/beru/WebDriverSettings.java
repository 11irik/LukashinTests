package ru.beru;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class WebDriverSettings {
    public static ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/kirill/Documents/Workspace/IDEa/LukashinTests/src/main/resources/drivers/chromedriver78");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

    @After
    public void close() {
        driver.quit();
    }

    public static void captureScreenshot(String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;

        
    }
}
