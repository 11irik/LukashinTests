package ru.beru.signIn;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PassportPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public PassportPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    private By fieldLogin = By.id("passp-field-login");
    private By fieldPassword = By.id("passp-field-passwd");
    private By buttonEnter = By.cssSelector("button[type=\"submit\"]");
    //todo correct locator
    private By buttonPassword = By.cssSelector("#root > div > div > div.passp-flex-wrapper " +
            "> div > div.passp-auth > div.passp-auth-content > div.passp-route-forward > div > div > form > " +
            "div.passp-button.passp-sign-in-button" +
            " > button.control.button2.button2_view_classic.button2_size_l.button2_theme_action.button2_width_max.button2_type_submit.passp-form-button");

    private By buttonMyProfile = By.cssSelector("button[class=\"_1FEpprw_Km\"]");
    public void open() {
        driver.get("https://passport.yandex.ru/auth?origin=beru_sber&retpath=https%3A%2F%2Fberu.ru%2Fauth-redir%3Fretpath%3D%252F%253Floggedin%253D1");
    }

    public void fillLogin(String login) {
        driver.findElement(fieldLogin).sendKeys(login);
        driver.findElement(buttonEnter).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldPassword));
    }

    public void fillPassword(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
        driver.findElement(buttonPassword).click();
    }


    //todo button locator page
    public void checkSignInSuccess() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonMyProfile));
        Assert.assertEquals(driver.findElement(buttonMyProfile).getText(), "Мой профиль");
    }

}
