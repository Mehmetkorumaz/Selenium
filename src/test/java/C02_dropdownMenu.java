import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeClass;

import java.util.List;

public class C02_dropdownMenu extends TestBase_BeforeClass {
    @Test
    public void dropdownTesti(){
     driver.get("https://www.amazon.com");
        WebElement kategoriDropdownElementi= (WebElement) driver.findElements(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(kategoriDropdownElementi);
        List<WebElement> optionsElement=select.getOptions();
        int expectedKategorisayisi=45;
        int actualkategorisayisi=optionsElement.size();
        Assert.assertEquals("kategori sayisi 45 degil!!!",expectedKategorisayisi,actualkategorisayisi);

    }
    public void JawaAramaTesti(){

    }
}
