package day09_iframe_cokluWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class tekrar extends TestBase {

    @Test
    public void iframeTest(){
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        bekle(3);
        // 2 ) Bir metod olusturun: iframeTest
        //  - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement iframeLocate= driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(iframeLocate.isEnabled());
        System.out.println(iframeLocate.getText());


        //  - Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe= driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframe);
        WebElement textBox= driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya!");
        bekle(3);

        //  - TextBox’in altinda bulunan “Elemental Selenium”
        //    linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin.
        //iframe'e gecen driver'i yeniden anasayfaya dondurmemiz gerekir
        driver.switchTo().defaultContent();
        WebElement elementalSelenium= driver.findElement(By.xpath("//a[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println(elementalSelenium.getText());


    }
}
