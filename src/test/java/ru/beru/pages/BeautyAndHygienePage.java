package ru.beru.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeautyAndHygienePage {
    WebDriver driver;
    WebDriverWait wait;

    //todo change constructor
    public BeautyAndHygienePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div/div[1]/div/div/div/div[17]/div[2]/div/a/span")
    private WebElement buttonElectricalToothbrushes;

    private By electricalToothbrushesPageLocator = By.className("ZsTILNLaud");

    @Step("Open electrical toothbrushes page")
    public void openElectricalToothbrushes() throws InterruptedException {
        buttonElectricalToothbrushes.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(electricalToothbrushesPageLocator));
    }
}
