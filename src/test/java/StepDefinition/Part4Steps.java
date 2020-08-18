package StepDefinition;

import PageObjectModel.OrderPOM;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Part4Steps {
    OrderPOM order = new OrderPOM();

    @Then("^Verify the data for the Bob Feather$")
    public void verifyTheDataForTheBobFeather(DataTable table) {
        List<WebElement> bobsDetail = order.BobsDetailList;
        List<String> stringList = table.asList(String.class);

        boolean flag = false;
        for (String string:stringList) {
            for (WebElement element : bobsDetail) {
                if (string.equals(element.getText())) {
                    flag = true;
                    break;
                }
            }
            Assert.assertTrue(flag);
        }
    }
}
