package ru.beru.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
    }

    @FindBy(css = "[data-apiary-widget-name=\"@marketplace/Auth\"]")
    private WebElement authButton;

    @FindBy(css = "[data-auto=\"region-form-opener\"] [class=\"_2XJ6yiRp5w\"]")
    private WebElement cityButton;

    @FindBy(id = "react-autowhatever-region")
    private WebElement listCities;
    //todo check the element name

    @FindBy(xpath = "/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/input")
    private WebElement cityField;

    @FindBy(css = "button[class=\"_1FEpprw_Km\"]")
    private WebElement buttonMyProfile;

    @FindBy(css = "[href=\"/my/settings?track=menu\"]")
    private WebElement buttonSettings;

    @FindBy(css = "body > div.main > div:nth-child(2) > div:nth-child(1) > div > div > div > div > div > div > div > div > div._1SEkJje5GJ > div._2BUQxcqKF7 > div > div._1QpP2zubQ8 > div._301_b-LBxR > div > div > span > button")
    private WebElement buttonCatalog;

    @FindBy(css = "body > div:nth-child(10) > div > div:nth-child(1) > div > div > div > div > div._3JUsAgML4w")
    private WebElement catalog;

    @FindBy(css = "body > div:nth-child(10) > div > div:nth-child(1) > div > div > div > div > div._3JUsAgML4w > ul > li:nth-child(12) > div > a")
    private WebElement locatorBeautyAndHygiene;

    @FindBy(xpath = "/html/body/div[6]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[2]/ul/li[1]")
    private WebElement boxFirstCity;

    @FindBy(css = "body > div:nth-child(7) > div > div > div._2EtOppZGBN._95Uzi20DUT._1RM9WlpHMC > div > div > div > div._1U2ErCeoqP > div > div > div > div > div > div > div > div._1w_nQg2pMI > div:nth-child(2) > button")
    private WebElement buttonOk;

    private By nextPageLocator = By.id("passp-field-login");


    //Methods
    public void open() {
        driver.get("https://beru.ru/");
    }

    public void openSignInPage() {
        authButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(nextPageLocator));
    }

    @Step("Type {cityName}")
    public void checkCity(String cityName) {
        open();
        Assert.assertEquals(cityName, cityButton.getText());
    }

    @Step("Type {cityName}")
    public void changeCity(String cityName) throws InterruptedException {
        cityButton.click();
        Thread.sleep(2000);
//        wait.until(ExpectedConditions.visibilityOf(cityField));
        cityField.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        cityField.sendKeys(cityName);

        wait.until(ExpectedConditions.visibilityOf(listCities));

        Thread.sleep(4000);

        //Assert.assertEquals(cityName, boxFirstCity.getText());

       // boxFirstCity.click();

//        wait.until(ExpectedConditions.visibilityOf(buttonOk));
//
//        buttonOk.click();
    }

    public void openSettings() {
        //buttonMyProfile.findElement(buttonSettings).click();
        buttonMyProfile.click();
        wait.until(ExpectedConditions.visibilityOf(buttonSettings));
        buttonSettings.click();
    }

    public void openCatalog() {
        buttonCatalog.click();
        //wait.until(ExpectedConditions.visibilityOf(catalog)); //todo change visibility element
    }

    public void openBeautyAndHygiene() { ;
        locatorBeautyAndHygiene.click();
    }


}
