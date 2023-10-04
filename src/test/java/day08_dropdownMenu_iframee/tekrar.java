package day08_dropdownMenu_iframee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeClass;

import java.util.List;

public class tekrar extends TestBase_BeforeClass {
    Select select;
    WebElement kategorilistesi;

    @Before
    public void test01() {
        //● https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        kategorilistesi = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select = new Select(kategorilistesi);
    }

    @Test
    public void test02() {
        //- Test 1
        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        List<WebElement> optionsList = select.getOptions();
        int expectedlist = 45;
        int actuallist = optionsList.size();
        Assert.assertEquals("kategori sayisi 45 degildir", expectedlist, actuallist);
    }

    @Test
    public void Test02() {
        //-Test 2
        //  1. Kategori menusunden Books secenegini  secin
        select.selectByVisibleText("Books");
        //  2. Arama kutusuna Java yazin ve aratin
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("java" + Keys.ENTER);
        //  3. Bulunan sonuc sayisini yazdirin

       WebElement toplamSonucSayisi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
       System.out.println(toplamSonucSayisi.getText());
        //4. Sonucun Java kelimesini icerdigini test edin
       String expectedYazi="Java";
       String actuelYazi=toplamSonucSayisi.getText();
       Assert.assertTrue(actuelYazi.contains(expectedYazi));


    }

}
