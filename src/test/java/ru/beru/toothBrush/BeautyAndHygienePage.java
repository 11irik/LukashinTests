package ru.beru.toothBrush;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeautyAndHygienePage {
    WebDriver driver;
    WebDriverWait wait;

    public BeautyAndHygienePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "body > div.main > div > div > div:nth-child(3) > div > div > div > div > div._3VatZYzt9O._1zYszmgEzn > div > div > div > div:nth-child(17) > div:nth-child(3) > div > a > span")
    private WebElement buttonElectricalToothbrushes;

    public void openElecticalToothbrushes() {
        buttonElectricalToothbrushes.click();
    }
}
