package ru.beru.tests;

import org.testng.annotations.Test;
import ru.beru.WebDriverSettings;
import ru.beru.pages.HomePage;
import ru.beru.pages.PassportPage;

public class SignInTest extends WebDriverSettings {

    @Test
    public void signIn() {
        String login = "lukashintest";
        String password = "Parol1234";
        String buttonText = "Мой профиль";

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.openPassportPage();

        PassportPage passportPage = new PassportPage(driver);
        passportPage.fillLoginAndEnter(login);
        passportPage.fillPasswordAndEnter(password);
        homePage.checkSignInButtonText(buttonText);
    }

}
