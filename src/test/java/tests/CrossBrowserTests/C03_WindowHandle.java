package tests.CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

public class C03_WindowHandle {

    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // ● Click Here butonuna basın.
    // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.


    @Test
    public void test(){
        Driver.getDriver().navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement text = Driver.getDriver().findElement(By.tagName("h3"));
        String anaSayfa = Driver.getDriver().getWindowHandle();
        System.out.println("Ana Sayfa Handle : "+anaSayfa);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(text.getText().equals("Opening a new window"),"'Opening a new window' - Text dogrulanamadı.");
        softAssert.assertEquals(Driver.getDriver().getTitle(),"The Internet","The Internet - Title dogrulanamadı.");

        Driver.getDriver().findElement(By.linkText("Click Here")).click();
        String tab = Driver.getDriver().getWindowHandle();
        Driver.getDriver().switchTo().window(tab);
        System.out.println("New Window Handle : "+tab);

        softAssert.assertEquals(Driver.getDriver().getTitle(),"New Window","New Window - Title dogrulanamadı.");
        WebElement text2 = Driver.getDriver().findElement(By.tagName("h3"));
        softAssert.assertEquals(text2.getText(),"New Window","'New Window' - Text dogrulanamadı.");

        Driver.getDriver().switchTo().window(anaSayfa);
        softAssert.assertEquals(Driver.getDriver().getTitle(),"The Internet","The Internet - Title dogrulanamadı.");
    }


}
