package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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

        for (WebElement allTitles: amazonPage.productTitles){
            System.out.println(allTitles.getText());
        }


        amazonPage.firstProduct.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Manchester City"),"Başlık 'Manchester City' içermiyor.");
        Assert.assertTrue(amazonPage.firstProductTitle.getText().contains("Manchester City"),"Ürün başlığı 'Manchester City' içermiyor.");

        Driver.closeDriver();
    }

}
