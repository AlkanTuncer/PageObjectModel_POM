package tests.DataProviderDDT_DataDrivenTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C01_DataProvider {

    @DataProvider
    public static Object[][] arananlarListesi() {
        String[][] aranacaklar = {{"Arrow"},{"Java"},{"Flutter"},{"Appium"}};
        return aranacaklar;
    }

    // Arrow Java Flutter Appium -> Bu üç kelimeyi arat.

    @Test(dataProvider = "arananlarListesi")
    public void amazonSearch(String str){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        AmazonPage amazonPage = new AmazonPage();

        amazonPage.aramaKutusu.sendKeys(str, Keys.ENTER);
        Assert.assertTrue(amazonPage.sonucText.getText().contains(str));

    }

}
