package ru.beru;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.EventListener;

public class WebDriverSettings {
    public static ChromeDriver chromeDriver;
    public static EventFiringWebDriver driver;
    public static WebDriverWait wait;
    public static SeleniumListener listener;
    @BeforeMethod
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver78.exe");
        chromeDriver = new ChromeDriver();
        driver = new EventFiringWebDriver(chromeDriver);
        listener = new SeleniumListener();
        wait = new WebDriverWait(chromeDriver, 10);
        driver.register(listener);
        driver.manage().window().fullscreen();
    }
    @AfterMethod
    protected void finish() {
        chromeDriver.quit();
    }

    @AfterMethod
    public void catchFailure(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            takeScreenshot(result.getName().toString());
        }
    }





    @Attachment(value = "Screenshot")
    public byte[] takeScreenshot(String name) throws IOException {
        File screenShotFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(".\\target\\screenshots\\" + name + ".png"));
        return ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Screenshot")
    public byte[] takeScreenshot(WebElement webElement, String name) {
        JavascriptExecutor jse = (JavascriptExecutor) chromeDriver;
        jse.executeScript("arguments[0].style.border='3px solid red'", webElement);
        // added sleep to give little time for browser to respond
        try {
            Thread.sleep(300);
        }catch (Exception e) {
            System.out.println(e);
        }
        File screenShotFile = ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(".\\target\\screenshots\\" + name + ".png"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ((TakesScreenshot) chromeDriver).getScreenshotAs(OutputType.BYTES);
    }
}
