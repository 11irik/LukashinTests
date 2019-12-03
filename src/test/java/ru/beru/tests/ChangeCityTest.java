package ru.beru.tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.beru.WebDriverSettings;
import ru.beru.pages.HomePage;
import ru.beru.pages.PassportPage;
import ru.beru.pages.SettingsPage;


public class ChangeCityTest extends WebDriverSettings {

    @Test
    public void changeCity() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.checkCity("Саратов");
        homePage.changeCity("Хвалынск");
        //fixme wait for update
        homePage.checkCity("Хвалынск");
        homePage.openSignInPage();

        PassportPage passportPage = new PassportPage(driver);
        passportPage.fillLoginAndEnter("lukashintest");
        passportPage.fillPasswordAndEnter("Parol1234");
        homePage.checkSignInButtonText("Мой профиль");
        homePage.openSettings();

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.checkCityMatches();
    }


}
