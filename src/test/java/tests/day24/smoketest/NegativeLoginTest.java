package tests.day24.smoketest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class NegativeLoginTest {

    // 3 Farkli test Methodunda 3 senaryoyu test et
    //                - yanlisSifre
    //                - yanlisKulllanici
    //                - yanlisSifreKullanici
    // https://www.hotelmycamp.com/ adresine git
    // test data yanlis username: manager1 , yanlis password : manager1

    HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

    @Test
    public void wrongPassword(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlHMC"));

        hotelMyCampPage.logInButton.click();
        hotelMyCampPage.username.sendKeys(ConfigurationReader.getProperty("HMCValidUsername"));
        hotelMyCampPage.password.sendKeys(ConfigurationReader.getProperty("HMCWrongPassword"), Keys.ENTER);

        Assert.assertTrue(hotelMyCampPage.wrongDataText.getText().contains("Try again please"),"Test FAILED - Password yanlış girilmedi.");

        Driver.closeDriver();
    }

    @Test
    public void wrongUsername(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlHMC"));

        hotelMyCampPage.logInButton.click();
        hotelMyCampPage.username.sendKeys(ConfigurationReader.getProperty("HMCWrongUsername"));
        hotelMyCampPage.password.sendKeys(ConfigurationReader.getProperty("HMCValidPassword"),Keys.ENTER);

        Assert.assertTrue(hotelMyCampPage.wrongDataText.getText().contains("Try again please"),"Test FAILED - Username yanlış girilmedi.");

        Driver.closeDriver();
    }

    @Test
    public void wrongPasswordUsername(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlHMC"));

        hotelMyCampPage.logInButton.click();
        hotelMyCampPage.username.sendKeys(ConfigurationReader.getProperty("HMCWrongUsername"));
        hotelMyCampPage.password.sendKeys(ConfigurationReader.getProperty("HMCWrongPassword"),Keys.ENTER);

        Assert.assertTrue(hotelMyCampPage.wrongDataText.getText().contains("Try again please"),"Test FAILED - Username/Password yanlış girilmedi.");

        Driver.closeDriver();
    }


}
