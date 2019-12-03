package ru.beru.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebDriverSettings;

public class BeautyAndHygienePage extends WebDriverSettings {
    public BeautyAndHygienePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //fixme
    @FindBy(xpath = "/html/body/div[1]/div/div[3]/div/div/div/div/div[1]/div/div/div/div[17]/div[2]/div/a/span")
    private WebElement buttonElectricalToothbrushes;

    private By electricalToothbrushesPageLocator = By.className("ZsTILNLaud");

    @Step("Open electrical toothbrushes page")
    public void openElectricalToothbrushes() {
        buttonElectricalToothbrushes.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(electricalToothbrushesPageLocator));
    }
}
