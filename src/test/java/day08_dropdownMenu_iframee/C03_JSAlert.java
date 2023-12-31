package day08_dropdownMenu_iframee;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSAlert extends TestBase {


    @Test
    public void test01() {
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[16]")).click();
        bekle(7);
    }

    @Test
    public void jsAlertTesti() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        bekle(2);
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(2);
        String expectedYazi = "I am a JS Alert";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi, actualYazi);
        driver.switchTo().alert().accept();
        bekle(2);
    }

    @Test
    public void cancelTesti() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        bekle(2);
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        bekle(2);
        driver.switchTo().alert().dismiss();
        bekle(2);
        String expectedSonucYazisi = "You clicked: Cancel";
        WebElement sonucYaziElementi = this.driver.findElement(By.xpath("//*[@id='result']"));
        String actualSonucYazisi = sonucYaziElementi.getText();
        Assert.assertEquals(expectedSonucYazisi, actualSonucYazisi);
    }

    @Test
    public void promptTesti() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Abdullah");
        driver.switchTo().alert().accept();
        WebElement sonucYaziElementi = this.driver.findElement(By.xpath("//*[@id='result']"));
        String actualSonucYazisi = sonucYaziElementi.getText();
        String expectedIcerik = "Abdullah";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
    }
}
