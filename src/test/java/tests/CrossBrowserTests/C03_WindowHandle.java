package tests.CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseCross;

public class C03_WindowHandle extends TestBaseCross {

    // ● https://the-internet.herokuapp.com/windows adresine gidin.
    // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
    // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
    // ● Click Here butonuna basın.
    // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
    // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
    // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.


    @Test
    public void test(){
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement text = driver.findElement(By.tagName("h3"));
        String anaSayfa = driver.getWindowHandle();
        System.out.println("Ana Sayfa Handle : "+anaSayfa);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(text.getText().equals("Opening a new window"),"'Opening a new window' - Text dogrulanamadı.");
        softAssert.assertEquals(driver.getTitle(),"The Internet","The Internet - Title dogrulanamadı.");

        driver.findElement(By.linkText("Click Here")).click();
        String tab = driver.getWindowHandle();
        driver.switchTo().window(tab);
        System.out.println("New Window Handle : "+tab);

        softAssert.assertEquals(driver.getTitle(),"New Window","New Window - Title dogrulanamadı.");
        WebElement text2 = driver.findElement(By.tagName("h3"));
        softAssert.assertEquals(text2.getText(),"New Window","'New Window' - Text dogrulanamadı.");

        driver.switchTo().window(anaSayfa);
        softAssert.assertEquals(driver.getTitle(),"The Internet","The Internet - Title dogrulanamadı.");
    }


}
