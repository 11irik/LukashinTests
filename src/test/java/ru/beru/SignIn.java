package ru.beru;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignIn extends WebDriverSettings {

    @Test
    public void signIn() throws InterruptedException {
        driver.get("https://beru.ru/");

        driver.manage().window().fullscreen();

        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Маркетплейс Беру - большой ассортимент товаров из интернет-магазинов " +
                "с быстрой доставкой и по выгодным ценам"));

        WebElement authButton = driver.findElement(By.cssSelector("[data-apiary-widget-name=\"@marketplace/Auth\"]"));
        authButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-login")));

        driver.findElement(By.id("passp-field-login")).sendKeys("lukashintest");

        driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passp-field-passwd")));

        driver.findElement(By.id("passp-field-passwd")).sendKeys("qwerty100");

        driver.findElement(By.cssSelector("#root > div > div > div.passp-flex-wrapper > div > div.passp-auth > div.passp-auth-content > div.passp-route-forward > div > div > form > div.passp-button.passp-sign-in-button > button.control.button2.button2_view_classic.button2_size_l.button2_theme_action.button2_width_max.button2_type_submit.passp-form-button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class=\"_1FEpprw_Km\"]")));

        //Assert.assertEquals(authButton.getText(), "Мой профиль");


        //TODO secondary finding???
        authButton = driver.findElement(By.cssSelector("[data-apiary-widget-name=\"@marketplace/Auth\"]"));
        //System.out.println(authButton.getText().toString());
        Assert.assertEquals(authButton.getText(), "Мой профиль");

    }

}
