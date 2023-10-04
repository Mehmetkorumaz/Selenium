package day07_assertions_checkBox;

import org.junit.Test;
import utilities.TestBase;

public class C05TestBaseilkClass extends TestBase {

    C05TestBaseilkClass(){

    }

    @Test
    public void test01() {
        this.driver.get("https://www.amazon.com");
        bekle(3);
    }
}
