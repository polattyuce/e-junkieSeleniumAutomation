package Utlity;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utlity.BaseDriver.driver;
import static Utlity.BaseDriver.wait;

public class MyFunc {

    public static void Bekle(int sn){

        try {
            Thread.sleep(sn*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void scrollElement(WebElement element) {
        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        javaScript.executeScript("arguments[0].scrollIntoView();", element);

    }

    public static void javaScriptClick(WebElement element) {
        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        javaScript.executeScript("arguments[0].click();", element);
    }



}
