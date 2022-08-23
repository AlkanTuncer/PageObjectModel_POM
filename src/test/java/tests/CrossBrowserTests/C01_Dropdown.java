package tests.CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBaseCross;

public class C01_Dropdown extends TestBaseCross {

    @Test
    public void testAmazonDropDown(){
        driver.navigate().to("https://www.amazon.com/");
        WebElement dropDown = driver.findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
        Select select = new Select(dropDown);
        select.selectByIndex(2);
        //select.selectByVisibleText("Automotive");
        //select.selectByValue("search-alias=automotive-intl-ship");

        System.out.println("3.Element : "+select.getFirstSelectedOption().getText());
    }

}
