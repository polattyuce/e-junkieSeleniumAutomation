package ejunkie;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class US_302 extends BaseDriver {

    @Test
    public void EJunkiedemositesindedemoekitabisatinalmavebankakartihataliodemeislemi(){

        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement addToCard = driver.findElement(By.xpath("(//div[@class='basicDetails']/button/i)[2]"));
        addToCard.click();

        WebElement iFrame = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"))));
        driver.switchTo().frame(iFrame);

        Assert.assertTrue("Kitap Sepete Eklenmemiş"
                ,driver.findElement(By.xpath("//div[@class='Col2 Product-Desc']/h5")).getText().contains("Demo eBook"));

        WebElement creditCard=driver.findElement(By.xpath("(//div[@class='Payment-Options']//button)[3]"));
        creditCard.click();


        WebElement pay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Pay 0.50 USD']")));
        pay.click();

        WebElement invalidPromoCode=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='SnackBar']//span"))));
        Assert.assertTrue("Yanlışlık var",invalidPromoCode.getText().contains("Invalid"));


        BekleKapat();
    }
}
