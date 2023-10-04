package day06_notations_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class tekrar {
@Test
    public  void test01(){
    //1-launch browser
    WebDriverManager.chromedriver().setup();
    WebDriver driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    //2- Navigate to Url 'https://www.automationexercise.com'
    driver.get("https://www.automationexercise.com");

    //3- Verify that home page is visiple successfully_ gorunur oldugunu test etmek
    WebElement logo= driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
    Assert.assertTrue(logo.isDisplayed()); // gorunur oldugunu test ediyoruz...

    //4- Click on 'Signup / Login 'button
    WebElement signupButton= driver.findElement(By.xpath("//a[text()=' Signup / Login']"));
    signupButton.click();

    //5- Verify 'Login to your account' is visible //görunur oldugunu test edecegiz
    WebElement visibleTest= driver.findElement(By.xpath("//h2[text()='Login to your account']"));
    Assert.assertTrue(visibleTest.isDisplayed());
    //6- Enter correct e_mail adres and password
    WebElement email= driver.findElement(By.xpath("//input[@data-qa='login-email']"));
    email.sendKeys("ahmet@nehaber.com");

    WebElement password= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
    password.sendKeys("12345");

    // click 'Login' button
    driver.findElements(By.xpath("//button[@data-qa='login-button']"+ Keys.ENTER));



}
}
