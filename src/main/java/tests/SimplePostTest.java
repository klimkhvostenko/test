package tests;

import api.methods.Post;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import web.FormPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Клим on 16.10.2018.
 */
public class SimplePostTest {
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
        List<NameValuePair> params = new ArrayList<NameValuePair>(3);
        params.add(new BasicNameValuePair("file", "https://www.irs.gov/pub/irs-pdf/fw9.pdf"));
        params.add(new BasicNameValuePair("name", "fw9.pdf"));
        params.add(new BasicNameValuePair("folder_id", "0"));
        Post.postWithAuth(url,token,params);
        FormPage formPage = new FormPage();
        String lastAddedDocumentsNameOnWeb = formPage.getLastAddedDocumentsName();
        Assert.assertTrue(lastAddedDocumentsNameOnWeb.contains("fw9"));
    }

    @AfterMethod
    public void tearDown() throws Exception {


    }
}
