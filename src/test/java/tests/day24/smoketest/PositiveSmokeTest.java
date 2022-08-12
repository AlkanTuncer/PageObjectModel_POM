package tests.day24.smoketest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class PositiveSmokeTest {

    HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

    @Test
    public void testPositiveLogin(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlHMC"));

        hotelMyCampPage.logInButton.click();
        hotelMyCampPage.username.sendKeys(ConfigurationReader.getProperty("HMCValidUsername"));
        hotelMyCampPage.password.sendKeys(ConfigurationReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.btnSubmit.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hotelMyCampPage.listOfUsers.isDisplayed(),"Test FAILED - Giriş yapılamadı.");
        softAssert.assertAll();

        Driver.closeDriver();
    }

}
