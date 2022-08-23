package tests.CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C02_BasicAuthentications extends TestBaseCross {

    @Test
    public void testBasicAuthentication(){
        // https://username:password@URL/ -> Bu yapıya göre verilen dataları yazıyoruz.
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth/");

        WebElement basicAuth = driver.findElement(By.xpath("//div[@class=\"example\"]"));
        Assert.assertTrue(basicAuth.isDisplayed());
    }
}
