package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePOM {
    WebDriver driver;
    WebDriverWait wait;

    public BasePOM(){

        driver = Driver.getDriver();
        wait = new WebDriverWait(driver,10);

    }
    public void waitAndClick(WebElement element) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
        webElement.click();
    }
    public void waitAndSendKeys(WebElement element, String text) {
        WebElement webElement = wait.until(ExpectedConditions.visibilityOf(element));
        webElement.clear();
        webElement.sendKeys(text);
    }
    public void ElementContainsText(WebElement element , String myText) {

        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().contains(myText));
    }

}
