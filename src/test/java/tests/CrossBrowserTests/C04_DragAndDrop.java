package tests.CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DragAndDrop {

    // https://demoqa.com/droppable adresine gidelim
    // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
    // “Drop here” yazisi yerine “Dropped!” oldugunu test edin

    @Test
    public void test(){
        Driver.getDriver().get("https://demoqa.com/droppable");

        Actions actions = new Actions(Driver.getDriver());

        WebElement dragMe = Driver.getDriver().findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement dropHere = Driver.getDriver().findElement(By.xpath("//div[@id=\"droppable\"]"));

        actions.dragAndDrop(dragMe,dropHere).perform();

        Assert.assertEquals(dropHere.getText(),"Dropped!","Text Dropped! değildir.");
    }

}
