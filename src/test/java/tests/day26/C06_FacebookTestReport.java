package tests.day26;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C06_FacebookTestReport extends TestBaseRapor {

    FacebookPage facebookPage = new FacebookPage();

    @Test
    public void testFacebookTask(){
        extentTest = extentReports.createTest("Facebook New User Create","Create a random user");

        Driver.getDriver().get(ConfigurationReader.getProperty("urlFacebook"));
        extentTest.info("Facebook sayfasına gidildi.");

        facebookPage.createButton.click();
        extentTest.info("Yeni kullanıcı oluşturmak için butona tıklandı.");

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        actions.sendKeys(facebookPage.firstName,faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(),Keys.TAB).sendKeys(email,Keys.TAB).sendKeys(email,Keys.TAB).
                sendKeys(faker.internet().password(),Keys.TAB).sendKeys(Keys.TAB).perform();
        extentTest.info("Faker Class ile random bilgiler oluşturulup ait olan yerlere bilgiler girildi.");

        Select select = new Select(facebookPage.dayOfBirth);
        select.selectByIndex(2);
        select = new Select(facebookPage.monthOfBirth);
        select.selectByIndex(3);
        select = new Select(facebookPage.yearOfBirth);
        select.selectByValue("1992");
        extentTest.info("Doğum tarihi Select Class ile seçildi.");

        facebookPage.male.click();
        extentTest.info("Cinsiyet 'Male' olarak seçildi.");

        facebookPage.signUpButton.click();
        extentTest.info("Kaydol'a tıklandı.");

        Assert.assertTrue(facebookPage.registrationError.isEnabled());
        extentTest.info("Yeni üyelik oluşturulamadığı test edildi.");

        //Driver.closeDriver();
    }

}
