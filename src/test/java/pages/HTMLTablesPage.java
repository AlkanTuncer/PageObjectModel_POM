package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HTMLTablesPage {

    public HTMLTablesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(tagName = "h1")
    public WebElement titleHtml;

    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/a[2]")
    public WebElement next;

    @FindBy(xpath = "//*[@id=\"main\"]/h1")
    public WebElement borders;

}
