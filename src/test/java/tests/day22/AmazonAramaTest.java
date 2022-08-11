package tests.day22;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AmazonAramaTest {

    AmazonPage amazonPage = new AmazonPage();

    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        amazonPage.aramaKutusu.sendKeys("Manchester City", Keys.ENTER);

        Driver.closeDriver();
    }

}
