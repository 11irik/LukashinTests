package ru.beru.changeCity;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.beru.WebDriverSettings;

import java.util.ConcurrentModificationException;
import java.util.concurrent.TimeUnit;


public class ChangeCity extends WebDriverSettings {

    @Test
    public void changeCity() throws InterruptedException {
        driver.get("https://beru.ru/");
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);




        WebDriverWait wait = new WebDriverWait(driver, 5);

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Маркетплейс Беру - большой ассортимент товаров из интернет-магазинов " +
                "с быстрой доставкой и по выгодным ценам"));

        WebElement cityButton = driver.findElement(By.cssSelector("[data-auto=\"region-form-opener\"] [class=\"_2XJ6yiRp5w\"]"));
        Assert.assertEquals(cityButton.getText(), "Саратов");
        cityButton.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/input")));

        WebElement cityField = driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div/div/div/div/div[1]/div/div/input"));


        String cityName = "Хвалынск";
        cityField.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        cityField.sendKeys(cityName);

//      for (int i = 0; i < cityName.length(); ++i) {
//          cityField.sendKeys(Character.toString(cityName.charAt(i)));
//      }
//          cityField.sendKeys(" ");

        //cityField.clear();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("._2u0xR0Dk5k")));

        Assert.assertEquals(driver.findElement(By.cssSelector("._229JDbp_Z8")).getText(), cityName);

        driver.findElement(By.cssSelector("._229JDbp_Z8")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/button")));
        driver.findElement(By.xpath("/html/body/div[7]/div/div/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div/div[2]/div[2]/button")).click();


        driver.get("https://beru.ru/");

        cityButton = driver.findElement(By.cssSelector("[data-auto=\"region-form-opener\"] [class=\"_2XJ6yiRp5w\"]"));

        Assert.assertEquals(cityButton.getText(), cityName);


        //cityField.sendKeys("Хвалынск");

        WebElement authButton = driver.findElement(By.cssSelector("[data-apiary-widget-name=\"@marketplace/Auth\"]"));
        authButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-login")));

        driver.findElement(By.id("passp-field-login")).sendKeys("lukashintest");

        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-passwd")));

        driver.findElement(By.id("passp-field-passwd")).sendKeys("Parol1234");

        driver.findElement(By.cssSelector("#root > div > div > div.passp-flex-wrapper > div > div.passp-auth > div.passp-auth-content > div.passp-route-forward > div > div > form > div.passp-button.passp-sign-in-button > button.control.button2.button2_view_classic.button2_size_l.button2_theme_action.button2_width_max.button2_type_submit.passp-form-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class=\"_1FEpprw_Km\"]")));



        authButton = driver.findElement(By.cssSelector("[data-apiary-widget-name=\"@marketplace/Auth\"]"));
        //System.out.println(authButton.getText().toString());
        authButton.click();

        driver.findElement(By.cssSelector("[href=\"/my/settings?track=menu\"]")).click();


        Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[1]/div/div/div/div/span/span/span")).getText(), driver.findElement(By.cssSelector("[data-auto=\"region-form-opener\"] [class=\"_2XJ6yiRp5w\"]")).getText());


        Thread.sleep(1000);

//
//        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("textfield2474819466")));
////
////
//        cityField.sendKeys("Хвалынск");




    }
}
