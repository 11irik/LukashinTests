package ru.beru;

import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

public class SeleniumListener implements WebDriverEventListener {

    @Attachment(value = "Screenshot")
    public static byte[] takeScreenshot(String name, WebDriver driver) throws IOException {
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShotFile, new File("./target/screenshots/" + name + ".png"));
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Screenshot")
    public static byte[] takeScreenshot(WebElement webElement, WebDriver driver, String name) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", webElement);
        // added sleep to give little time for browser to respond
        try {
            Thread.sleep(200);
        }catch (Exception e) {
            System.out.println(e);
        }
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenShotFile, new File("./target/screenshots/" + name + ".png"));
        } catch (Exception e) {
            System.out.println(e);
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {

    }

    public void afterNavigateTo(String s, WebDriver webDriver) {

    }

    public void beforeNavigateBack(WebDriver webDriver) {

    }

    public void afterNavigateBack(WebDriver webDriver) {

    }

    public void beforeNavigateForward(WebDriver webDriver) {

    }

    public void afterNavigateForward(WebDriver webDriver) {

    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
//        takeScreenshot(webElement, webDriver, webElement.getTagName());
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        takeScreenshot(webElement, webDriver, webElement.getTagName());
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {

    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        try {
            takeScreenshot("fail", webDriver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
