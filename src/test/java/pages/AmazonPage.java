package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class AmazonPage {

    public AmazonPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "twotabsearchtextbox")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']")
    public WebElement sonucText;

    @FindBy(xpath = "(//*[text()='Manchester City FC Puma Boys’ and Girls 2022/23 Replica Home Football Jersey'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "//span[@id=\"productTitle\"]")
    public WebElement firstProductTitle;

    @FindBy(xpath = "//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]")
    public List<WebElement> productTitles;

}
