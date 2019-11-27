package ru.beru.tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.beru.WebDriverSettings;
import ru.beru.pages.HomePage;
import ru.beru.pages.PassportPage;

import java.io.IOException;

public class SignInTest extends WebDriverSettings {

    @Test
    public void signIn() throws InterruptedException, IOException {
//        todo ask why do we need PageFactory.initElements
//        HomePage homePage = new HomePage(driver);
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.openSignInPage();

        PassportPage passportPage = PageFactory.initElements(driver, PassportPage.class);
        passportPage.fillLogin("lukashintest");
        passportPage.fillPassword("Parol1234");
        passportPage.checkSignInSuccess();
    }

}
