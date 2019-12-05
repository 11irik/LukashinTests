package ru.beru.tests;
import org.testng.annotations.Test;
import ru.beru.WebDriverSettings;
import ru.beru.pages.*;

public class BuyToothbrushesTest extends WebDriverSettings {


    @Test
    public void buyToothBrushes() throws InterruptedException {
        int minPrice = 999;
        int maxPrice = 1999;

        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.openElectricalToothbrushesPage();

        ElectricalToothbrushesPage electricalToothbrushesPage = new ElectricalToothbrushesPage(driver);
        electricalToothbrushesPage.setMinPrice(minPrice);
        electricalToothbrushesPage.setMaxPrice(maxPrice);
        electricalToothbrushesPage.checkPriceRangeCorrect(minPrice, maxPrice);
        electricalToothbrushesPage.purchaseLast();
        electricalToothbrushesPage.gotoCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.checkFreeShipment();
        cartPage.openCheckout();

        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.checkTotalCostCorrection();
        checkoutPage.openCart();

        cartPage.increaseTotalTo(2999);
        cartPage.openCheckout();

        checkoutPage.checkTotalCostCorrection();
    }
}
