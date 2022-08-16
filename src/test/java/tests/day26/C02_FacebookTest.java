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

public class C02_FacebookTest {

    FacebookPage facebookPage = new FacebookPage();

    @Test
    public void testFacebook(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlFacebook"));

        facebookPage.createButton.click();

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        actions.sendKeys(facebookPage.firstName,faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(),Keys.TAB).sendKeys(email,Keys.TAB).sendKeys(email,Keys.TAB).
                sendKeys(faker.internet().password(),Keys.TAB).sendKeys(Keys.TAB).perform();

        Select select = new Select(facebookPage.dayOfBirth);
        select.selectByIndex(2);
        select = new Select(facebookPage.monthOfBirth);
        select.selectByIndex(3);
        select = new Select(facebookPage.yearOfBirth);
        select.selectByValue("1992");

        facebookPage.male.click();
        facebookPage.signUpButton.click();

        Assert.assertTrue(facebookPage.registrationError.isEnabled());

        Driver.closeDriver();
    }

    @Test(groups = "miniRegression")
    public void test53(){
        System.out.println("Dante53");
    }

}
