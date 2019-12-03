package ru.beru.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    //todo change the constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 50);
    }

    @FindBy(css = "[class=\"_2YHTmhZmt4\"]")
    private WebElement labelLeftForFreeShipment;

    @FindBy(css="[class=\"_1oBlNqVHPq\"]")
    private WebElement labelSummary;

    @FindBy(css="[class=\"_4qhIn2-ESi Pjv3h3YbYr THqSbzx07u _39B7yXQbvm _2W4X8tX6r0\"]")
    private WebElement buttonCheckout;

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[1]/div/div/div/input")
    private WebElement countField;

    //fixme Checkout page
    @FindBy(css="[class=\"_1e2FY_93Ro\"]")
    private WebElement yourOrder;

    @FindBy(xpath = "//div[@data-auto=\"DELIVERY\"]")
    private WebElement buttonCourierDelivery;

    @FindBy(xpath = "//div[@data-auto=\"total-delivery\"]//span[@data-auto=\"value\"]")
    private WebElement labelDeliveryPrice;

    @FindBy(xpath = "//span[@data-auto=\"change-link\"]")
    WebElement buttonChangeOrder;

    public void getFreeShipment() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(labelLeftForFreeShipment));
        String priceStr[] = labelLeftForFreeShipment.getText().split(" ");
        int leftForFree = Integer.parseInt(priceStr[0]);
        if (leftForFree < 10) {
            leftForFree *= 100;
            leftForFree += Integer.parseInt(priceStr[1]);
        }
        priceStr = labelSummary.getText().split(" ");
        int toothbrushPrice = Integer.parseInt(priceStr[0]) * 1000 + Integer.parseInt(priceStr[1]);

        //fixme checkout page
        buttonCheckout.click();
        wait.until(ExpectedConditions.visibilityOf(yourOrder));
        buttonCourierDelivery.click();
        priceStr = labelDeliveryPrice.getText().split(" ");
        int deliveryPrice = Integer.parseInt(priceStr[0]);
        priceStr = labelSummary.getText().split(" ");
        int sum = Integer.parseInt(priceStr[0]) * 1000 + Integer.parseInt(priceStr[1]);
        Assert.assertEquals(sum, deliveryPrice + toothbrushPrice);
        buttonChangeOrder.click();
        //fixme checkout page

        wait.until(ExpectedConditions.visibilityOf(buttonCheckout));
        int k = (int) Math.ceil(2999.0 / toothbrushPrice);
        countField.click();
        countField.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        countField.sendKeys(Integer.toString(k));

        Thread.sleep(100000);



    }
}
