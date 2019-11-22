package ru.beru.signIn;

import org.openqa.selenium.By;
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
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "[data-apiary-widget-name=\"@marketplace/Auth\"]")
    private WebElement authButton;

    private By fieldLogin = By.id("passp-field-login");

    public void open() {
        driver.get("https://beru.ru/");
    }

    public void loginToAccount() {
        authButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldLogin));
    }
}
