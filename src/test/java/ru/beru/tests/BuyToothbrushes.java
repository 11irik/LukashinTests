package ru.beru.tests;

import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import ru.beru.WebDriverSettings;
import ru.beru.pages.ElectricalToothbrushesPage;

public class BuyToothbrushes extends WebDriverSettings {

    @Test public void buyToothBrushes() {
//        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
//        homePage.open();
//        homePage.openCatalog();
//        homePage.openBeautyAndHygiene();

//        BeautyAndHygienePage beautyAndHygienePage = PageFactory.initElements(driver, BeautyAndHygienePage.class);
//        beautyAndHygienePage.openElecticalToothbrushes();

        ElectricalToothbrushesPage electricalToothbrushesPage = PageFactory.initElements(driver, ElectricalToothbrushesPage.class);
        electricalToothbrushesPage.open();
        electricalToothbrushesPage.setStartPrice(1000);


//        for(int i = 0; i < 100000; ++i) {
//            System.out.print(" ");
//        }
    }
}
