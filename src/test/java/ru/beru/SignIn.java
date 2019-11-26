package ru.beru;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.beru.WebDriverSettings;
import ru.beru.pages.HomePage;
import ru.beru.pages.PassportPage;

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
