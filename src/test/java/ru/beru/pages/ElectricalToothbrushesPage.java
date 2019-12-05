package ru.beru.pages;

import io.qameta.allure.Step;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import ru.beru.WebDriverSettings;

public class ElectricalToothbrushesPage extends WebDriverSettings {
    public ElectricalToothbrushesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@data-auto=\"filter-range-glprice\"]//span[@data-auto=\"filter-range-min\"]//input")
    private WebElement fieldPriceMin;

    @FindBy(xpath = "//div[@data-auto=\"filter-range-glprice\"]//span[@data-auto=\"filter-range-max\"]//input")
    private WebElement fieldPriceMax;

    @FindBy(css = "[class=\"_3GNV1gy3cc\"]")
    private WebElement labelPriceRange;

    //fixme
    @FindBy(xpath = "//div[@class=\"_1uhsh_io8o\"]//div[@class=\"_3rWYRsam78\"][last()]/div[last()]//div[@class=\"_1RjY7YIluf _1zYszmgEzn\"][last()-1]//span[@class=\"_2w0qPDYwej\"]")
    private WebElement penultimateToothbrush;

    @FindBy(css = "[class=\"_3ioN70chUh QFR-8bfWr4 _3Uc73lzxcf\"]")
    private WebElement buttonGotoCart;

    private By locatorFoundedGoods = By.className("_3rWu3-6RDl qpgDgmh6Hn _11QbuC0gtX _1zxBwSfbGK _1mXFu6EZpv >wrItvb7JRv");
    private By locatorCartPage = By.className("wn9mZbgWbv");


    @Step("Open electrical toothbrushes page")
    public void open() {
        driver.get("https://beru.ru/catalog/elektricheskie-zubnye-shchetki-v-saratove/80961/list?hid=278374&track=fr_ctlg");
        wait.until(ExpectedConditions.visibilityOf(fieldPriceMin));
    }

    @Step("Set start price")
    public void setMinPrice(int price) {
        fieldPriceMin.sendKeys(Integer.toString(price));
    }

    @Step("Set minimal price")
    public void setMaxPrice(int price) {
        fieldPriceMax.sendKeys(Integer.toString(price));
    }

    @Step("Check the price range is correct")
    public void checkPriceRangeCorrect(int low, int max) throws InterruptedException {
        //fixme there WERE some problems with wait...
        wait.until(ExpectedConditions.visibilityOf(labelPriceRange));
        Thread.sleep(2000);
        String priceRange = low + " — " + max + " ₽";
        Assert.assertEquals(priceRange, labelPriceRange.getText());
    }

    @Step("Purchasing penultimate toothbrush")
    public void purchaseLast() {
        wait.until(ExpectedConditions.elementToBeClickable(penultimateToothbrush));
        penultimateToothbrush.click();
        wait.until(ExpectedConditions.textToBePresentInElement(penultimateToothbrush, "В корзине"));
    }

    @Step("Go to cart")
    public void gotoCart() {
        penultimateToothbrush.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorCartPage));
    }


}
