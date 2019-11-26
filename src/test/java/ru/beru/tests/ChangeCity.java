package ru.beru.tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.beru.WebDriverSettings;
import ru.beru.pages.SettingsPage;
import ru.beru.pages.HomePage;
import ru.beru.pages.PassportPage;


public class ChangeCity extends WebDriverSettings {

    @Test
    public void changeCity() throws InterruptedException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();

        homePage.checkCity("Саратов");

        homePage.changeCity("Хвалынск");

        homePage.checkCity("Хвалынск");

        homePage.loginToAccount();

        PassportPage passportPage = PageFactory.initElements(driver, PassportPage.class);
        passportPage.fillLogin("lukashintest");
        passportPage.fillPassword("Parol1234");
        passportPage.checkSignInSuccess();

        homePage.openSettings();

        SettingsPage settingsPage = PageFactory.initElements(driver, SettingsPage.class);
        settingsPage.checkCityCorrect();

        for(int i = 0; i < 100000; ++i) {
            System.out.println("");
        }
    }


}
