package tests.day23;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Facebook {

    FacebookPage facebookPage = new FacebookPage();

    @Test
    public void testFacebookTask(){
        Driver.getDriver().get(ConfigurationReader.getProperty("urlFacebook"));

        facebookPage.createButton.click();

        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();

        actions.sendKeys(facebookPage.firstName,faker.name().firstName(), Keys.TAB).
                sendKeys(faker.name().lastName(),Keys.TAB).sendKeys(email,Keys.TAB).sendKeys(email,Keys.TAB).
                sendKeys(faker.internet().password()).perform();
    }

}
