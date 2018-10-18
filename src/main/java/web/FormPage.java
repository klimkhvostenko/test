package web;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Created by Клим on 17.10.2018.
 */
public class FormPage {
    WebDriver driver;
    public FormPage open(){
        driver.get("https://www.pdffiller.com/en/forms.htm");
        return this;
    }

    private void closePopUp(){
        try{
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOfElementLocated(By.cssSelector(".cm.cm--md.cm-email-verification-steps")));
        WebElement closeEmailPopUp = driver.findElement(By.cssSelector(".i.i-close.cm__close"));
        closeEmailPopUp.click();
        } catch (TimeoutException e){}

    }

    public List<String> getListOfDocuments(){
        closePopUp();
        WebElement myBoxTab = driver.findElement(By.cssSelector(".i.i-mybox-new"));
        myBoxTab.click();
        List<String> values = new ArrayList<String>();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOfElementLocated(By.cssSelector(".md-doc__name")));
        List<WebElement> listOfdocumentsNames = driver.findElements(By.cssSelector(".md-doc__name"));
        for(WebElement element: listOfdocumentsNames){
            values.add(element.getText());
        }
        return values;
    }

    public String getLastAddedDocumentsName(){
        closePopUp();
        WebElement myBoxTab = driver.findElement(By.cssSelector(".i.i-mybox-new"));
        myBoxTab.click();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(visibilityOfElementLocated(By.cssSelector(".md-doc__name")));
        WebElement lastAddedDocumentsNameInForm = driver.findElement(By.cssSelector(".md-doc__name"));
        String lastAddedDocumentsName = lastAddedDocumentsNameInForm.getText();
        driver.close();
        return lastAddedDocumentsName;
    }
}
