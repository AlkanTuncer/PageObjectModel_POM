package tests.DataProviderDDT_DataDrivenTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class C02_DataProviderNegativeLoginTest {

    @DataProvider
    public static Object[][] hmcTestData() {
        String[][] testData = {  {ConfigurationReader.getProperty("HMCWrongUsername"),ConfigurationReader.getProperty("HMCValidPassword")} ,
                                 {ConfigurationReader.getProperty("HMCValidUsername"),ConfigurationReader.getProperty("HMCWrongPassword")} ,
                                 {ConfigurationReader.getProperty("HMCWrongUsername"),ConfigurationReader.getProperty("HMCWrongPassword")}  };
        return testData;
    }

    @Test(dataProvider = "hmcTestData")
    public void negativeLoginTest(String username,String password){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlHMC"));

        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        hotelMyCampPage.logInButton.click();
        hotelMyCampPage.username.sendKeys(username);
        hotelMyCampPage.password.sendKeys(password);
        hotelMyCampPage.btnSubmit.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hotelMyCampPage.wrongDataText.isDisplayed());
        softAssert.assertAll();

    }

}
