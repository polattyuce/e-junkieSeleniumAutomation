package ejunkie;

import Utlity.BaseDriver;
import Utlity.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class US_303 extends BaseDriver {

    @Test
    public void DebitKrediKartıileBaşarısızÖdemeKontrolü() {

        driver.get("https://shopdemo.fatfreeshop.com/?");

        WebElement addToCard = driver.findElement(By.xpath("(//div[@class='basicDetails']/button/i)[2]"));
        addToCard.click();

        WebElement iFrame = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[class='EJIframeV3 EJOverlayV3']"))));
        driver.switchTo().frame(iFrame);

        Assert.assertTrue("Kitap Sepete Eklenmemiş"
                , driver.findElement(By.xpath("//div[@class='Col2 Product-Desc']/h5")).getText().contains("Demo eBook"));

        WebElement creditCard = driver.findElement(By.xpath("(//div[@class='Payment-Options']//button)[3]"));
        creditCard.click();

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder='Email']")));
        email.sendKeys("rojow22711@xcmexico.com");

        WebElement emailConfirm = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("[placeholder='Confirm Email']"))));
        emailConfirm.sendKeys("rojow22711@xcmexico.com");

        WebElement nameOnCard = driver.findElement(By.cssSelector("[placeholder='Name On Card']"));
        nameOnCard.sendKeys("fdasgadsgadfs");

        WebElement phone = driver.findElement(By.xpath("(//input[@placeholder='Optional'])[1]"));
        phone.sendKeys("23462352345");

        WebElement iframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[role='presentation']")));
        driver.switchTo().frame(iframe);

        WebElement cardNumber =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='InputContainer']/input)[1]")));
        cardNumber.sendKeys("1111 1111 1111 1111");

        WebElement yearMonth = driver.findElement(By.xpath("(//span[@class='InputContainer']/input)[2]"));
        yearMonth.sendKeys("1122");

        WebElement cvv = driver.findElement(By.xpath("(//span[@class='InputContainer']/input)[3]"));
        cvv.sendKeys("1223");

        driver.switchTo().parentFrame();
        WebElement pay = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Pay 0.50 USD']")));
        pay.click();

        WebElement hataMesajı=driver.findElement(By.xpath("//div[@id='SnackBar']//span"));
        System.out.println(hataMesajı.getText());

        Assert.assertEquals(hataMesajı.getText(),"Kart numaranız geçersiz.");
        BekleKapat();
    }
}
