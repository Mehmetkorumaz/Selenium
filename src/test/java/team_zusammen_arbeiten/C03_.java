package team_zusammen_arbeiten;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_ extends TestBase {
    @Test
    public void itemSearchTest(){
        //Test Case 1: Searching for an Item
        //Test Scenario:
        //Open the Amazon.com website.
        driver.get("https://www.Amazon.com");
        //Locate the search text box.
        WebElement locateTextBox= driver.findElement(By.id("twotabsearchtextbox"));
        //Enter the name of an item.
        locateTextBox.sendKeys("kitap hirsizi"+ Keys.ENTER);
        bekle(3);
        //Click the search button.
        //Expected Outcome:
        //The item is found in the search results.
        WebElement sonucSayisiGörünümü= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(sonucSayisiGörünümü.isDisplayed());
        //Open the Amazon.com website.
    }
    @Test
    public void Test2(){
        //Test Case 2: Creating an Account (Positive)
        //
        //Test Scenario:
        //Open the Amazon.com website.
        driver.get("https://www.Amazon.com");
        //Click on the "Account & Lists" button.
        driver.findElement(By.xpath("//span[@class='nav-line-2 ']")).click();
        //Select "Create your Amazon account."
        driver.findElement(By.id("createAccountSubmit")).click();
        //Fill in the required fields with valid data for Your name, Mobile number or email, password, and re-enter password.
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='customerName']"));
        Faker faker=new Faker();
        String password =faker.internet().password();
        Actions actions=new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();
        //Click the "Continue" button.
        driver.findElement(By.xpath("//input[@id='continue']")).click();


        //Expected Outcome:
        //The user should see the "Solve this puzzle to protect your account" page.
        //Open the Amazon.com website.??????????
    }
    @Test
    public void test3(){
        //Test Case 3: Creating an Account (Negative - Missing Your Name)
        //
        //Test Scenario:
        //Open the Amazon.com website.
        driver.get("https://www.Amazon.com");
        //Click on the "Account & Lists" button.
        driver.findElement(By.xpath("//span[@class='nav-line-2 ']")).click();
        //Select "Create your Amazon account."
        driver.findElement(By.id("createAccountSubmit")).click();
        //Fill in the required fields with valid data for Your name, Mobile number or email, password, and re-enter password.
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='customerName']"));
        Faker faker=new Faker();
        String password =faker.internet().password();
        Actions actions=new Actions(driver);
        actions.click(isimKutusu)
                .sendKeys(faker.name().fullName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .sendKeys(Keys.TAB)
                .sendKeys(password)
                .perform();
        //Click the "Continue" button.
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        //Expected Outcome:
        //The user should see a warning message: "Enter your name."
        driver.findElement(By.xpath("//input[@name='code']")).sendKeys("Enter your name.");
        bekle(3);
        String expectedYazi="Enter your name.";
        //String actualUyariYazisi=driver.findElement(By.xpath("//div[@class='a-row a-spacing-micro cvf-widget-input-code-label']")).getText();
        //Assert.assertEquals(expectedYazi,actualUyariYazisi);???

    }
}
