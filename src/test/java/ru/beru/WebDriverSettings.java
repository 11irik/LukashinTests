package ru.beru;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class WebDriverSettings {
    public ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/kirill/Documents/Workspace/IDEa/LukashinTests/src/main/resources/drivers/chromedriver78");
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
    }

//    @After
//    public void close() {
//        driver.quit();
//    }

    @Rule
    public TestWatcher watchman = new TestWatcher() {
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

        public void takeScreenshot(String name) throws IOException {
            File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenShotFile, new File("./Screenshots/" + name + ".png"));
        }
    };
}
