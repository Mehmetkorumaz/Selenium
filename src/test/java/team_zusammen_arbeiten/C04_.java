package team_zusammen_arbeiten;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C04_ extends TestBase {
    @Test
    public void test1(){
        // amazon ana sayfaya gidip url'in amazon icerdigini test edin
        driver.get("https://www.amazon.com");
        String expectedAmazonUrl="amazon";
        String actualamazonUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualamazonUrl.contains(expectedAmazonUrl));
        String amazonWHD= driver.getWindowHandle();

        // yeni bir tab'da wisequarter.com'a gidin ve url'in wise icerdigini test edin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");
        String expectedWIseUrl="wise";
        String actualWiseUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualWiseUrl.contains(expectedWIseUrl));
        String wiseWHD= driver.getWindowHandle();


        // yeni bir pencere olarak youtube'a gidin ve url'in youtube icerdigini test edin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String expectedYoutubeUrl= "youtube";
        String actualYoutubeUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualYoutubeUrl.contains(expectedYoutubeUrl));
        String youtubeWHD= driver.getWindowHandle();


        // wisequarter'in acik oldugu sayfaya donup title'in Wise icerdigini test edin
        driver.switchTo().window(wiseWHD);
        String expectedWiseTitle="Wise";
        String actualWiseTitel=driver.getTitle();
        Assert.assertTrue(actualWiseTitel.contains(actualWiseTitel));


        // Amazon'un acik oldugu sayfaya donun ve Title'in Amazon icerdigini test edin
        driver.switchTo().window(amazonWHD);
        String expectedAmazonTitle="Amazon";
        String actualAmazonTitle= driver.getTitle();
        Assert.assertTrue(actualAmazonTitle.contains(expectedAmazonTitle));

    }
}
