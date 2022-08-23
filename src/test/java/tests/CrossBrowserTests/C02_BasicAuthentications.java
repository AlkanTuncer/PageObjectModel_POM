package tests.CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;


public class C02_BasicAuthentications {

    @Test
    public void testBasicAuthentication(){
        // https://username:password@URL/ -> Bu yapıya göre verilen dataları yazıyoruz.
        Driver.getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth/");

        WebElement basicAuth = Driver.getDriver().findElement(By.xpath("//div[@class=\"example\"]"));
        Assert.assertTrue(basicAuth.isDisplayed());
    }
}
