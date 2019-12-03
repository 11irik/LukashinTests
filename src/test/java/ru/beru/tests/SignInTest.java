package ru.beru.tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.beru.WebDriverSettings;
import ru.beru.pages.HomePage;
import ru.beru.pages.PassportPage;

import java.io.IOException;

public class SignInTest extends WebDriverSettings {

    @Test
    public void signIn() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.openSignInPage();

        PassportPage passportPage = new PassportPage(driver);
        passportPage.fillLoginAndEnter("lukashintest");
        passportPage.fillPasswordAndEnter("Parol1234");
        homePage.open();
        homePage.checkSignInButtonText("Мой профиль");
    }

}
