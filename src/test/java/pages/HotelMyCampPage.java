package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {

    public HotelMyCampPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "navLogon")
    public WebElement logInButton;

    @FindBy(id = "UserName")
    public WebElement username;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "btnSubmit")
    public WebElement btnSubmit;

    @FindBy(className = "validation-summary-errors")
    public WebElement wrongDataText;

    @FindBy(xpath = "//*[text()=\"ListOfUsers\"]")
    public WebElement listOfUsers;

    @FindBy(xpath = "//*[text()=\"Hotel Management\"]")
    public WebElement hotelManagement;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div/ul/li[3]/ul/li[2]/ul/li[1]/a")
    public WebElement hotelList;

    @FindBy(xpath = "//span[@class=\"hidden-480\"]")
    public WebElement addHotel;

    @FindBy(xpath = "//input[@id=\"Code\"]")
    public WebElement codeCreateHotel;

    @FindBy(xpath = "//select[@id=\"IDGroup\"]")
    public WebElement selectIDGroup;

    @FindBy(xpath = "//button[@id=\"btnSubmit\"]")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class=\"bootbox-body\"]")
    public WebElement successCreateHotel;

    @FindBy(xpath = "//button[@data-bb-handler=\"ok\"]")
    public WebElement okButton;

}
