package tests.day23;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.W3SchoolPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class W3SchoolPageTask {

    /*
        https://www.w3schools.com/html/html_tables.asp
        adrese gidilsin
        HTML Tables yazısı test edilsin
        next click
        açılan sayfada
        HTML Table Borders olduğu doğrulansın.
     */

    W3SchoolPage w3SchoolPage = new W3SchoolPage();

    @Test
    public void test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("taskUrl"));

        Assert.assertTrue(w3SchoolPage.htmlTables.isDisplayed(),"HTML Titles yazısı görünmüyor.");
        System.out.println("Html Tables Text : "+w3SchoolPage.htmlTables.getText());

        w3SchoolPage.next.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(w3SchoolPage.borders.isDisplayed(),"HTML Table Borders yazısı vardır.");
        System.out.println("Html Borders Text : "+w3SchoolPage.borders.getText());

        Driver.closeDriver();

    }

}
