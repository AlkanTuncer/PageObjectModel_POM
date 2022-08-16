package tests.day26;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C05_TestNGReports extends TestBaseRapor {

    @Test
    public void testWindowHandleReusableMethods(){
        extentTest = extentReports.createTest("windowHandle with ReusableMethods","Title ile yeni sayfaya geçiş");

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        extentTest.info("heokuapp sayfasına gidildi.");

        Driver.getDriver().findElement(By.xpath("//a[@target=\"_blank\"]")).click();
        extentTest.info("'Click Here' butonuna tıklandı.");

        ReusableMethods.switchToWindow("New Window");
        extentTest.info("Reusable Metot kullanılarak yeni sayfaya geçildi.");

        Assert.assertEquals(Driver.getDriver().getTitle(),"New Window","Test FAILED - Title is not 'New Window'");
        extentTest.pass("Title'ın beklenen değer ile aynı olduğu test edildi.");

        //Driver.closeDriver();
    }

}
