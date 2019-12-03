package ru.beru.tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.beru.WebDriverSettings;
import ru.beru.pages.BeautyAndHygienePage;
import ru.beru.pages.CartPage;
import ru.beru.pages.ElectricalToothbrushesPage;
import ru.beru.pages.HomePage;

public class BuyToothbrushesTest extends WebDriverSettings {


    @Test
    public void buyToothBrushes() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.openCatalog();
        homePage.openBeautyAndHygiene();

        BeautyAndHygienePage beautyAndHygienePage = new BeautyAndHygienePage(driver);
        beautyAndHygienePage.openElectricalToothbrushes();

        ElectricalToothbrushesPage electricalToothbrushesPage = new ElectricalToothbrushesPage(driver);
        electricalToothbrushesPage.setStartPrice(999);
        electricalToothbrushesPage.setEndPrice(1999);
        electricalToothbrushesPage.checkPriceRangeCorrect(999, 1999);
        electricalToothbrushesPage.purchaseLast();
        electricalToothbrushesPage.gotoCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.getFreeShipment();

        Thread.sleep(5000);
    }
}