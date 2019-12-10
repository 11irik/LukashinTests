package ru.beru.pages;

//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebDriverSettings;

public class CartPage extends WebDriverSettings {
    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @FindBy(css = "[class=\"_2YHTmhZmt4\"]")
    private WebElement labelLeftForFreeShipment;

    @FindBy(css="[class=\"_1oBlNqVHPq\"]")
    private WebElement labelTotal;

    @FindBy(css="[class=\"bLjj5ddV9I\"]")
    private WebElement buttonCheckout;

    @FindBy(xpath = "//div[@class=\"_3MqS53YE3Q\"]//div[@class=\"_1u3j_pk1db\"]")
    private WebElement labelToothbrushPrice;

    //fixme xpath
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div[3]/div/div/div/div/div/div/div[2]/div/div/div/div[1]/div/div[3]/div/div/div/div/div/div/div/div/div/div/div/div/div[1]/div[2]/div[2]/div/div/div/div/div/div/div/input")
    private WebElement fieldCount;

    By locatorCheckoutPage = By.className("_1e2FY_93Ro");

    public void checkFreeShipment() {
        wait.until(ExpectedConditions.visibilityOf(labelLeftForFreeShipment));
        String[] priceStr = labelLeftForFreeShipment.getText().split(" ");
        int leftForFree = Integer.parseInt(priceStr[0]);
        if (leftForFree < 10) {
            leftForFree *= 100;
            leftForFree += Integer.parseInt(priceStr[1]);
        }

        System.out.println(leftForFree);
    }

    public void openCheckout() {
        buttonCheckout.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(locatorCheckoutPage));
    }

    public void increaseTotalTo(double price) {
        String[] nums = labelToothbrushPrice.getText().split("\\D+");
        int toothbrushPrice = Integer.parseInt(nums[0]);
        if (nums.length > 1) {
            toothbrushPrice *= 1000;
            toothbrushPrice += Integer.parseInt(nums[1]);
        }

        int k = (int) Math.ceil(price / toothbrushPrice);
        fieldCount.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        fieldCount.sendKeys(Integer.toString(k));
        wait.until(ExpectedConditions.visibilityOf(labelTotal));
        wait.until(ExpectedConditions.elementToBeClickable(buttonCheckout));
    }

    public void clearCart() {

    }
}
