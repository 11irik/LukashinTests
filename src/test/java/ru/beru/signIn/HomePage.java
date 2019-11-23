package ru.beru.signIn;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "[data-apiary-widget-name=\"@marketplace/Auth\"]")
    private WebElement authButton;

    @FindBy(css = "[data-auto=\"region-form-opener\"] [class=\"_2XJ6yiRp5w\"]")
    private WebElement cityButton;

    @FindBy(xpath = "/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/input")
    private WebElement smt;
    //todo check the element name

    @FindBy(xpath = "/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/input")
    private WebElement cityField;

    @FindBy(css = "button[class=\"_1FEpprw_Km\"]")
    private WebElement buttonMyProfile;

    @FindBy(css = "[href=\"/my/settings?track=menu\"]")
    private WebElement buttonSettings;

    //todo ask about locator from another page
    private By fieldLogin = By.id("passp-field-login");

    public void open() {
        driver.get("https://beru.ru/");
    }

    public void loginToAccount() {
        authButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldLogin));
    }

    public void checkCity(String cityName) {
        open();
        Assert.assertEquals(cityName, cityButton.getText());
    }

    public void changeCity(String cityName) {
        cityButton.click();
        wait.until(ExpectedConditions.visibilityOf(smt));
        cityField.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        cityField.sendKeys(cityName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._2u0xR0Dk5k")));
        //todo check the element

        Assert.assertEquals(driver.findElement(By.cssSelector("._229JDbp_Z8")).getText(), cityName);

        driver.findElement(By.cssSelector("._229JDbp_Z8")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/button")));
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/button")).click();
    }

    public void openSettings() {
        //buttonMyProfile.findElement(buttonSettings).click();
        buttonMyProfile.click();
        wait.until(ExpectedConditions.visibilityOf(buttonSettings));
        buttonSettings.click();

    }


}
