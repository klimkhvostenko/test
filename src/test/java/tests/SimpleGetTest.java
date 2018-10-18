package tests;

/**
 * Created by Клим on 18.10.2018.
 */

import api.methods.Get;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.FormPage;
import web.LoginPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SimpleGetTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "E:\\test3\\test\\geckodriver.exe");
        driver = new FirefoxDriver();

    }

    @Test
    public void main() throws IOException {
        String url = "https://api.pdffiller.com/v1/document";
        String token = "VvPROjVXfQJQVe04BPc05DyQe9NpW03F1XhV4UcB";
        String responseBody = Get.getWithAuth(url,token);
        JSONObject obj = new JSONObject(responseBody);
        JSONArray arr = obj.getJSONArray("items");
        List<String> apiListOfNames = new ArrayList<String>() ;
        for(int i = 0; i < arr.length(); i++){
            String name = arr.getJSONObject(i).getString("name").replaceAll(".pdf","");
            apiListOfNames.add(name);
        }
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        FormPage formPage = loginPage.login();
        List<String> webListOfNames = formPage.getListOfDocuments();

        Assert.assertTrue(webListOfNames.equals(apiListOfNames));
    }

    @AfterMethod
    public void tearDown() throws Exception {
        driver.close();
    }
}