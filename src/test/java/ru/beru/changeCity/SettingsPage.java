package ru.beru.changeCity;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SettingsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "[data-auto=\"region-form-opener\"] [class=\"_2XJ6yiRp5w\"]")
    private WebElement buttonCity;

    @FindBy(css = "#region > div > div > div > span > span > span")
    private WebElement buttonYourCity;

    public void checkCityCorrect() {
        Assert.assertEquals(buttonCity.getText(), buttonYourCity.getText());
    }
}
