package tests.day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.Set;

public class C04_WindowHandleRM {

    // https://the-internet.herokuapp.com/windows sitesine gideli
    // 'Click Here' butonuna tıklayalım
    // new taba geçip title'ın "New Window" olduğunu test edelim

    @Test
    public void testWindowHandle(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        String mainPageWH = Driver.getDriver().getWindowHandle();

        WebElement openNewWindow = Driver.getDriver().findElement(By.xpath("//a[@target=\"_blank\"]"));
        openNewWindow.click();

        Set<String> handles = Driver.getDriver().getWindowHandles();
        String newTabWH = "";

        for (String each : handles){
            if (!each.equals(mainPageWH)){
                newTabWH = each;
            }
        }

        Driver.getDriver().switchTo().window(newTabWH);
        Assert.assertEquals(Driver.getDriver().getTitle(), "New Window", "Test FAILED - Title is not 'New Window'");

        Driver.closeDriver();
    }

    @Test
    public void testWindowHandleReusableMethods(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        Driver.getDriver().findElement(By.xpath("//a[@target=\"_blank\"]")).click();

        ReusableMethods.switchToWindow("New Window");
        Assert.assertEquals(Driver.getDriver().getTitle(),"New Window","Test FAILED - Title is not 'New Window'");

        Driver.closeDriver();

    }

}
