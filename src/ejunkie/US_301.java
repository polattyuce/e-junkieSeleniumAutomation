package ejunkie;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class US_301 extends BaseDriver {

    @Test
    public void ekitabıSepeteEkleme() {

        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement addToCard = driver.findElement(By.xpath("(//div[@class='basicDetails']/button/i)[2]"));
        addToCard.click();

        WebElement iFrame = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"))));
        driver.switchTo().frame(iFrame);

        WebElement addPromoCode = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='Actions']/button)[2]")));
        addPromoCode.click();

        WebElement promoCode = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='Actions']/div/input"))));
        promoCode.sendKeys("sjkhgjksdgsdfg");

        WebElement apply = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class='Actions']/div/button"))));
        apply.click();

        WebElement invalidPromoCode=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='SnackBar']//span")));
        Assert.assertTrue("Yanlışlık var",invalidPromoCode.getText().contains("Invalid"));

         BekleKapat();
    }
}
