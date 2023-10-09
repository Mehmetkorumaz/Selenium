package team_zusammen_arbeiten;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.dom.model.ShadowRootType;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C05_ extends TestBase {
    @Test
    public void test1(){
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']")).click();
        String ilkWHD= driver.getWindowHandle();
        //4.Diger window'a gecin
        Set<String> windowHDleri= driver.getWindowHandles();
        String ikinciEkranWHD="";
        for (String each:windowHDleri
             ) {
            if (!ilkWHD.equals(each)){
                ikinciEkranWHD=each;
            }
        }
        driver.switchTo().window(ikinciEkranWHD);
        //5."username" ve "password" kutularina deger yazdirin
        WebElement userName= driver.findElement(By.xpath("//*[@placeholder='Username']"));
        Faker faker=new Faker();
        actions.click(userName)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .perform();
        //6."login" butonuna basin
         driver.findElement(By.xpath("//button[text()='Login']")).click();
        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        System.out.println(driver.switchTo().alert().getText());
        String expectedYazi="validation failed";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();
        //9.Ilk sayfaya geri donun
        driver.switchTo().window(ilkWHD);
        //10.Ilk sayfaya donuldugunu test edin
        String expectedUrlilk="webdriveruniversity";
        String actualUrlilk= driver.getCurrentUrl();
        Assert.assertTrue(actualUrlilk.contains(expectedUrlilk));
    }
}
