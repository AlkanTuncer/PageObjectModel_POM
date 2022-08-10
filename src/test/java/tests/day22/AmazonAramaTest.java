package tests.day22;

import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AmazonAramaTest {

    AmazonPage amazonPage = new AmazonPage();

    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        amazonPage.aramaKutusu.sendKeys("Manchester City new season jersey");
    }

    /*
                      PAGE OBJECT MODEL

            - POM popüler bir Framework Design Pattern'dir.

            - Test suitlerimizde cok fazla testimiz oldugunda, test caseleri ve kodları korumak
            daha karmasık hale gelir.Bu nedenle;
                - sürdürülebilir / maintainable
                - yeniden kullanılabilir / reusable
                - daha hızlı / faster
                - anlaşılabilir / understandable
            daha iyi bir framework dizaynına ihtiyacımız var.

            - Page Object Model ile sayfaya özgü elementleri veya metotları page class içinde tutar ve
            bunları gercek test classlarından uzak tutarız.

            - POM ile ihtiyacımız olan class üyelerini sadece bir kez create edip birden cok kez kullanabiliriz.

     */
}
