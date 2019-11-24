package ru.beru.toothBrush;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectricalToothbrushesPage {
    WebDriver driver;
    WebDriverWait wait;

    public ElectricalToothbrushesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "body > div.main > div > div:nth-child(5) > div > div > div > div > div._1nix18j-st._1zYszmgEzn > div > div:nth-child(2) > div > div > div > div > div > div:nth-child(1) > fieldset > div > span:nth-child(1) > div")
    private WebElement fieldPriceStart;

    @FindBy(id = "textfield8003521453")
    private WebElement fieldPriceStart2;

    @FindBy(css = "<label class=\"UGIRui44wf\" data-tid=\"37e0ab2d\">25 490</label>")
    private WebElement fieldPriceEnd;

    public void open() {
        driver.get("https://beru.ru/catalog/elektricheskie-zubnye-shchetki-v-saratove/80961/list?hid=278374&track=fr_ctlg");
    }

    public void setStartPrice(int price) {
        wait.until(ExpectedConditions.visibilityOf(fieldPriceStart));
        fieldPriceStart.click();
        fieldPriceStart2.sendKeys();
        for ( int i = 0; i < 100000; ++i) {
            System.out.print(" ");
        }
    }
}
