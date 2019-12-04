package ru.beru;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public class WebDriverSettings {
    public static ChromeDriver driver;
    public static WebDriverWait wait;
    @BeforeTest
    public void start() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver78.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 50);
        driver.manage().window().fullscreen();
    }
    @AfterTest
    protected void finish() {
        driver.quit();
    }

    @AfterMethod
    public void catchFailure(ITestResult result) throws IOException {
        if (!result.isSuccess()) {
            takeScreenshot(result.getName().toString());
        }
    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver78.exe");
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 50);
            driver.manage().window().fullscreen();
        }

        @Override
        protected void failed(Throwable e, Description description) {
            try {
                takeScreenshot(description.getClassName() + ":" + description.getMethodName());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        protected void finished(Description description) {
            driver.quit();
        }
    };
    @Attachment(value = "Screenshot")
    public byte[] takeScreenshot(String name) throws IOException {
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File(".\\target\\screenshots\\" + name + ".png"));
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Screenshot")
    public byte[] takeScreenshot(WebElement webElement, String name) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", webElement);
        // added sleep to give little time for browser to respond
        try {
            Thread.sleep(300);
        }catch (Exception e) {
            System.out.println(e);
        }
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File(".\\target\\screenshots\\" + name + ".png"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
