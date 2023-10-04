package day07_assertions_checkBox;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase_BeforeClass;

   public class tekrar extends TestBase_BeforeClass {
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun
    //   ve gerekli testleri yapin
    //  ○ titleTest   => Sayfa başlığının “YouTube” oldugunu test edin
    //  ○ imageTest   => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //  ○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //  ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin


    @Test
     public void titleTest(){

        driver.get("https://www.youtube.com");
        bekle(2);
        String expectedTitle= "Youtube";
        String actualTitle= driver.getTitle();


      driver.close();
    }
    @Test
    public void imageTest(){
        driver.get("https://www.youtube.com");
        WebElement logoElement= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(logoElement.isDisplayed());

    }

}
