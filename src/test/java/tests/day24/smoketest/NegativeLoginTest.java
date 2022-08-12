package tests.day24.smoketest;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTest {

    // 3 Farkli test Methodunda 3 senaryoyu test et
    //                - yanlisSifre
    //                - yanlisKulllanici
    //                - yanlisSifreVeKullanici
    // https://www.hotelmycamp.com/ adresine git
    // test data yanlis username: manager1 , yanlis password : manager1

    HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

    @Test
    public void wrongPassword(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlHMC"));

        hotelMyCampPage.logInButton.click();
        hotelMyCampPage.username.sendKeys(ConfigurationReader.getProperty("HMCValidUsername"));
        hotelMyCampPage.password.sendKeys(ConfigurationReader.getProperty("HMCWrongPassword"), Keys.ENTER);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hotelMyCampPage.wrongDataText.isDisplayed());
        softAssert.assertAll();

        Driver.closeDriver();
    }

    @Test
    public void wrongUsername(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlHMC"));

        hotelMyCampPage.logInButton.click();
        hotelMyCampPage.username.sendKeys(ConfigurationReader.getProperty("HMCWrongUsername"));
        hotelMyCampPage.password.sendKeys(ConfigurationReader.getProperty("HMCValidPassword"),Keys.ENTER);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hotelMyCampPage.wrongDataText.isDisplayed());
        softAssert.assertAll();

        Driver.closeDriver();
    }

    @Test
    public void wrongUsernameAndPassword(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlHMC"));

        hotelMyCampPage.logInButton.click();
        hotelMyCampPage.username.sendKeys(ConfigurationReader.getProperty("HMCWrongUsername"));
        hotelMyCampPage.password.sendKeys(ConfigurationReader.getProperty("HMCWrongPassword"),Keys.ENTER);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hotelMyCampPage.wrongDataText.isDisplayed());
        softAssert.assertAll();

        Driver.closeDriver();
    }


}
