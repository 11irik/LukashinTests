package ru.beru.tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.beru.WebDriverSettings;
import ru.beru.pages.HomePage;
import ru.beru.pages.PassportPage;
import ru.beru.pages.SettingsPage;


public class ChangeCityTest extends WebDriverSettings {

    @Test
    public void changeCity() throws InterruptedException {
        //todo change initialization after changing class constructor
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.checkCity("Саратов");
        homePage.changeCity("Хвалынск");
        //fixme wait for update
        homePage.checkCity("Хвалынск");

        homePage.openSignInPage();
        //todo change initialization after changing class constructor
        PassportPage passportPage = PageFactory.initElements(driver, PassportPage.class);
        passportPage.fillLoginAndEnter("lukashintest");
        passportPage.fillPasswordAndEnter("Parol1234");
        homePage.checkSignInButtonText("Мой профиль");

        homePage.openSettings();
        //todo change initialization after changing class constructor
        SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);
        settingsPage.checkCityMatches();
    }


}
