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

    @FindBy(xpath = "//a[@href=\"/catalog/elektricheskie-zubnye-shchetki-v-saratove/80961/list?hid=278374&track=fr_ctlg\"]")
    private WebElement buttonElectricalToothbrushes;

    private By electricalToothbrushesPageLocator = By.className("ZsTILNLaud");

    @Step("Open electrical toothbrushes page")
    public void openElectricalToothbrushes() {
        buttonElectricalToothbrushes.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(electricalToothbrushesPageLocator));
    }
}
