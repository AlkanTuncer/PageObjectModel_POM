package tests.day24;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelMyCampPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class E2ETesting_EndToEnd {

    //Tests packagenin altına class olusturun: CreateHotel
    //Bir metod olusturun: createHotel
    //https://www.hotelmycamp.com/ adresine git.
    //Username textbox ve password metin kutularını locate edin ve asagidaki verileri
    //Username : manager
    //Password : Manager1!
    //Login butonuna tıklayın.
    //Hotel Management/Hotel List menusunden ADD HOTEL butonuna tiklayin
    //Açılan sayfadaki tum metin kutularına istediğiniz verileri girin.
    //Save butonuna tıklayın.
    //Hotel was inserted successfully” textinin görunduğunu test edin.
    //OK butonuna tıklayın.

    HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

    @Test
    public void createHotel(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlHMC"));

        hotelMyCampPage.logInButton.click();
        hotelMyCampPage.username.sendKeys(ConfigurationReader.getProperty("HMCValidUsername"));
        hotelMyCampPage.password.sendKeys(ConfigurationReader.getProperty("HMCValidPassword"));
        hotelMyCampPage.btnSubmit.click();

        hotelMyCampPage.hotelManagement.click();
        hotelMyCampPage.hotelList.click();
        hotelMyCampPage.addHotel.click();

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        actions.sendKeys(hotelMyCampPage.codeCreateHotel,"53", Keys.TAB).
                sendKeys(faker.name().fullName(),Keys.TAB).sendKeys(faker.address().fullAddress(),Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber(),Keys.TAB).sendKeys(faker.internet().emailAddress()).perform();

        Select select = new Select(hotelMyCampPage.selectIDGroup);
        select.selectByIndex(1);

        hotelMyCampPage.saveButton.click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(hotelMyCampPage.successCreateHotel.isEnabled(),"Test FAILED - Hotel isn't created.");
        softAssert.assertAll();

        hotelMyCampPage.okButton.click();

        Driver.closeDriver();

    }

}
