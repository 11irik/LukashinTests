package ru.beru.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebDriverSettings;

public class SettingsPage extends WebDriverSettings {

    public SettingsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@data-auto,'region-form-opener')]//span[2]")
    private WebElement buttonCity;

    @FindBy(xpath = "//span[contains(@data-auto,'region')]//span[1]//span[1]")
    private WebElement buttonYourCity;

    @Step("Check that the city name in the settings matches the name in the title")
    public void checkCityMatches() {
        Assert.assertEquals(buttonCity.getText(), buttonYourCity.getText());
    }
}
