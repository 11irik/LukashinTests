package ru.beru.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebDriverSettings;

public class HomePage extends WebDriverSettings {
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[class=\"_1r1GkezLi0\"]")
    private WebElement buttonBeru;

    @FindBy(css = "[class=\"_3odNv2Dw2n\"]")
    private WebElement buttonAuth;

    @FindBy(xpath = "//span[contains(@data-auto,'region-form-opener')]//span[2]")
    private WebElement cityButton;

    @FindBy(css = "[class=\"_1U2ErCeoqP\"]")
    private WebElement popUpcity;

    @FindBy(xpath = "//div[contains(@data-auto,'region-popup')] //input[contains(@class,'_2JDvXzYsUI')]")
    private WebElement cityField;

    @FindBy(id = "react-autowhatever-region")
    private WebElement listboxCities;

    @FindBy(css = "[class=\"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u\"]")
    private WebElement buttonOk;

    @FindBy(css = "[class=\"_1FEpprw_Km\"]")
    private WebElement buttonMyProfile;

    @FindBy(css = "[href=\"/my/settings?track=menu\"]")
    private WebElement buttonSettings;

    @FindBy(css = "[class=\"_3RM4_n5whA\"]")
    private WebElement buttonCatalog;

    @FindBy(css = "[class=\"_3JUsAgML4w\"]")
    private WebElement catalog;

    @FindBy(css = "[title=\"Красота и гигиена\"]")
    private WebElement buttonBeautyAndHygiene;

    private By firstCityOfList = By.className("_229JDbp_Z8");
    private By authPageLocator = By.id("passp-field-login");
    private By settingsPageLocator = By.className("_38iDpDiSsi");
    private By beautyAndHygienePageLocator = By.className("_2dcblmamIS");

    @Step("Open homepage")
    public void open() {

        driver.get("https://beru.ru/");
        wait.until(ExpectedConditions.visibilityOf(buttonBeru));
    }

    @Step("Open sign-in page")
    public void openSignInPage() {
        buttonAuth.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(authPageLocator));
    }

    @Step("Check that current city is {cityName}")
    public void checkCity(String cityName) {
        Assert.assertEquals(cityName, cityButton.getText());
    }

    @Step("Change current city to {cityName}")
    public void changeCity(String cityName) {
        cityButton.click();
        wait.until(ExpectedConditions.visibilityOf(popUpcity));
        cityField.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        cityField.sendKeys(cityName);
        wait.until(ExpectedConditions.visibilityOf(listboxCities));
        WebElement firstCity = listboxCities.findElement(firstCityOfList);
        //fixme sometimes fail because of typing speed
        Assert.assertEquals(cityName, firstCity.getText());
        firstCity.click();
        wait.until(ExpectedConditions.visibilityOf(buttonOk));
        buttonOk.click();
        open();
    }

    @Step("Check signIn button text = {text}")
    public void checkSignInButtonText(String text) {
        Assert.assertEquals(text, buttonAuth.getText());
    }

    @Step("Open settings")
    public void openSettings() {
        buttonAuth.click();
        wait.until(ExpectedConditions.visibilityOf(buttonSettings));
        buttonSettings.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(settingsPageLocator));
    }

    @Step("Open catalog")
    public void openCatalog() {
        buttonCatalog.click();
        wait.until(ExpectedConditions.visibilityOf(catalog));
    }

    @Step("Open beauty-and-hygiene page")
    public void openBeautyAndHygiene() {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(buttonBeautyAndHygiene).perform();
        buttonBeautyAndHygiene.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(beautyAndHygienePageLocator));
    }


}
