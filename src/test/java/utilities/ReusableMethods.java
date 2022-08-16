package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReusableMethods {

    public static String takeScreenshot(String name){
        String date = new SimpleDateFormat("yyyyMMddhhss").format(new Date());
        TakesScreenshot ts= (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String target = System.getProperty("user.dir")+"src/test-output/screenshots"+name+date+".png";
        File file = new File(target);
        try {
            FileUtils.copyFile(source,file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return target;
    }

    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    public static List<String> getElementsText(By locator){
        List<WebElement> elements = Driver.getDriver().findElements(locator);
        List<String> elementsTexts = new ArrayList<>();
        for (WebElement elem : elements){
            if (!elem.getText().isEmpty()){
                elementsTexts.add(elem.getText());
            }
        }
        return elementsTexts;
    }

    // ------------------ Explicit Wait ------------------------
    public static WebElement waitForVisibility(WebElement element, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int time){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
