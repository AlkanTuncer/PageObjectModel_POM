package tests.day26;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C03_HotelMyCampPositiveLogin {

    HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

    @Test(groups = {"miniRegression", "notRun"})
    public void testHMCPositiveLogin(){
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
