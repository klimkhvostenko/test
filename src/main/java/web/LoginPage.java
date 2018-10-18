package web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

/**
 * Created by Клим on 18.10.2018.
 */
public class LoginPage {
    WebDriver driver;

    LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public LoginPage open() {
        driver.get("https://www.pdffiller.com/en/login.htm");
        return this;
    }

    private void login() {
//        System.setProperty("webdriver.gecko.driver", "E:\\test3\\test\\geckodriver.exe");
//        driver = new FirefoxDriver();
//        driver.get("https://www.pdffiller.com/en/login.htm");
        open();
        WebElement logIn = driver.findElement(By.id("form-login-email"));
        logIn.sendKeys("testtestpdf@meta.ua");
        WebElement password = driver.findElement(By.id("form-login-password"));
        password.sendKeys("testtest");
        WebElement submit = driver.findElement(By.id("form-login-submit"));
        submit.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.pdffiller.com/en/forms.htm"));
//        closePopUp();
    }

}
