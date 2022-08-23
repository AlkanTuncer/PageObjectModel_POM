package tests.CrossBrowserTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_Dropdown {

    @Test
    public void testAmazonDropDown(){
        Driver.getDriver().navigate().to("https://www.amazon.com/");
        WebElement dropDown = Driver.getDriver().findElement(By.xpath("//select[@class=\"nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown\"]"));
        Select select = new Select(dropDown);
        select.selectByIndex(2);
        //select.selectByVisibleText("Automotive");
        //select.selectByValue("search-alias=automotive-intl-ship");

        System.out.println("3.Element : "+select.getFirstSelectedOption().getText());
    }

}
