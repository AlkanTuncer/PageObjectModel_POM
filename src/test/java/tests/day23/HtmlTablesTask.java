package tests.day23;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HTMLTablesPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class HtmlTablesTask {

    /*
        https://www.w3schools.com/html/html_tables.asp
        adrese gidilsin
        HTML Tables yazısı test edilsin
        next click
        açılan sayfada
        HTML Table Borders olduğu doğrulansın.
     */

    HTMLTablesPage htmlTablesPage = new HTMLTablesPage();

    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("taskUrl"));

        Assert.assertTrue(htmlTablesPage.titleHtml.isDisplayed(),"HTML Titles yazısı görünmüyor.");

        htmlTablesPage.next.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(htmlTablesPage.borders.isDisplayed(),"HTML Table Borders yazısı vardır.");

        Driver.closeDriver();

    }

}
