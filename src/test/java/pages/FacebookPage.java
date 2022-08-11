package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@data-testid=\"open-registration-form-button\"]")
    public WebElement createButton;

    @FindBy(xpath = "//input[@name=\"firstname\"]")
    public WebElement firstName;

    @FindBy(xpath = "//select[@aria-label=\"Day\"]")
    public WebElement dayOfBirth;

    @FindBy(xpath = "//select[@aria-label=\"Month\"]")
    public WebElement monthOfBirth;

    @FindBy(xpath = "//select[@aria-label=\"Year\"]")
    public WebElement yearOfBirth;

    @FindBy(xpath = "//input[@value=\"2\"]")
    public WebElement male;

    @FindBy(xpath = "//button[@name=\"websubmit\"]")
    public WebElement signUpButton;

    @FindBy(xpath = "//div[@id=\"reg_error_inner\"]")
    public WebElement registrationError;

}
