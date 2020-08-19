package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public void listSizeVerify(List<WebElement> list , int num) {
        Assert.assertEquals(list.size(),num);
    }

    public void waitAndSelect(WebElement element , String myText) {
        wait.until(ExpectedConditions.visibilityOf(element));
        Select select=new Select(element);
        select.selectByVisibleText(myText);
    }

    public void listContainsAllOtherList(List<WebElement>list1, List<String>list2){
        List<String>list=new ArrayList<>();
        for (WebElement webElement : list1) {
            list.add(webElement.getText());
        }
        Assert.assertTrue(list.containsAll(list2));
    }

    public void listContainsAllOtherMapValues(List<WebElement>list, Map<String,String>map){
        Set<Map.Entry<String, String>> entries = map.entrySet();
        boolean flag = false;
        for (Map.Entry<String, String> entry : entries) {
            for (WebElement element : list) {
                if (entry.getValue().equals(element.getText())) {
                    flag = true;
                    break;
                }
            }
            Assert.assertTrue(flag);
        }
    }

}
