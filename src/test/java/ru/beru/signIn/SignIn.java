package ru.beru.signIn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebDriverSettings;

public class SignIn extends WebDriverSettings {

    @Test
    public void signIn() {
//        todo ask why do we need PageFactory.initElements
//        HomePage home = new HomePage(driver);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.loginToAccount();

        PassportPage passportPage = PageFactory.initElements(driver, PassportPage.class);
        passportPage.fillLogin("lukashintest");
        passportPage.fillPassword("Parol1234");
        passportPage.checkSignInSuccess();
    }

}
