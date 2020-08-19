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
        List<String> stringList = table.asList(String.class);
        order.findListAndCompareWithOtherOne("BobsDetailList",stringList);

    }
}
