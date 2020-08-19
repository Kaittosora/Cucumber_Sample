package StepDefinition;

import PageObjectModel.OrderPOM;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;
import java.util.Set;

public class Part2Steps {
    OrderPOM order = new OrderPOM();


    @Then("^User fill the order form and verify it$")
    public void userFillTheOrderForm(DataTable fields) {
        Map<String, String> fieldsMap = fields.asMap(String.class, String.class);

        order.findElementAndSendKeys("quantityInput", fieldsMap.get("quantity"));
        order.findElementAndSendKeys("cutomerNameInput", fieldsMap.get("customer name"));
        order.findElementAndSendKeys("streetInput", fieldsMap.get("street"));
        order.findElementAndSendKeys("cityInput", fieldsMap.get("city"));
        order.findElementAndSendKeys("stateInput", fieldsMap.get("state"));
        order.findElementAndSendKeys("zipInput", fieldsMap.get("zip"));
        order.findElementAndClick("visaCard");
        order.findElementAndSendKeys("cardNoInput", fieldsMap.get("card number"));
        order.findElementAndSendKeys("expireDateInput", fieldsMap.get("expiration date"));
        order.findElementAndClick("processButton");
        order.findElementAndClick("viewAllOrdersLink");

        order.findListAndCompareWithMapValues("orderDetailList",fieldsMap);
    }

    @Then("^The order should be added to the all orders table$")
    public void theOrderShouldBeAddedToTheAllOrdersTable() {
        order.findListAndVerifySize("orderList",9);
    }

    @When("^Create the order with \"([^\"]*)\"$")
    public void createTheOrderWith(String productName)  {
        order.findElementAndClick("orderLink");
        order.findElementAndSelect("selectProduct",productName);

    }
}
