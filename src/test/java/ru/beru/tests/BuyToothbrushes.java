package ru.beru.tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.beru.WebDriverSettings;
import ru.beru.pages.CartPage;
import ru.beru.pages.ElectricalToothbrushesPage;

public class BuyToothbrushes extends WebDriverSettings {


    @Test public void buyToothBrushes() throws InterruptedException {
//        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//        homePage.open();
//        homePage.openCatalog();
//        Thread.sleep(1000);
//
//        homePage.openBeautyAndHygiene();
//
//        //todo change initialization
//        BeautyAndHygienePage beautyAndHygienePage = PageFactory.initElements(driver, BeautyAndHygienePage.class);
//        beautyAndHygienePage.openElectricalToothbrushes();

        //todo change the page initialization
        ElectricalToothbrushesPage electricalToothbrushesPage = PageFactory.initElements(driver, ElectricalToothbrushesPage.class);
        electricalToothbrushesPage.open();
        electricalToothbrushesPage.setStartPrice(999);
        electricalToothbrushesPage.setEndPrice(1999);
        electricalToothbrushesPage.checkPriceRangeCorrect(999, 1999);
        electricalToothbrushesPage.purchaseLast();
        electricalToothbrushesPage.gotoCart();

        //todo change the page initialization
        CartPage cartPage = PageFactory.initElements(driver, CartPage.class);
        cartPage.getFreeShipment();

        Thread.sleep(5000);
    }
}
