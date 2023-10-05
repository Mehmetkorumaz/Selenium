package team_zusammen_arbeiten;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;


public class C02_ extends TestBase {
    @Test
    public void test02(){
        // 1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");
        // 2. Username kutusuna “standard_user” yazdirin
        WebElement userName=driver.findElement(By.xpath("//input[@data-test='username']"));
        userName.sendKeys("standard_user");
        // 3. Password kutusuna “secret_sauce” yazdirin
        WebElement password=driver.findElement(By.xpath("//input[@data-test='password']"));
        password.sendKeys("secret_sauce");
        // 4. Login tusuna basin
        driver.findElement(By.xpath("//*[@name='login-button']")).click();

        // 5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String ilkUrunIsmi= driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();

        // 6. Add to Cart butonuna basin
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        // 7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//*[@*='shopping_cart_link']")).click();
        // 8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement UrunSepette= driver.findElement(By.xpath("//*[@*='cart_item_label']"));

        Assert.assertTrue(UrunSepette.isDisplayed());
        // 9. Sayfayi kapatin
    }
}
