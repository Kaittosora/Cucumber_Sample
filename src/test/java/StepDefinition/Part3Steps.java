package StepDefinition;

import PageObjectModel.OrderPOM;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Part3Steps {
    OrderPOM order = new OrderPOM();


    @Then("^User fill the order form$")
    public void userFillTheOrderForm(DataTable fields) {
        List<Map<String, String>> maps = fields.asMaps(String.class, String.class);
        for (Map<String, String> fieldsMap : maps) {
            order.findElementAndClick("orderLink");
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

        }
    }
}
