package StepDefinition;

import PageObjectModel.OrderPOM;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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


        Set<Map.Entry<String, String>> entries = fieldsMap.entrySet();
        boolean flag = false;
        for (Map.Entry<String, String> entry : entries) {
            for (WebElement element : order.orderDetailList) {
                if (entry.getValue().equals(element.getText())) {
                    flag = true;
                    break;
                }
            }
            Assert.assertTrue(flag);
        }

    }

    @Then("^The order should be added to the all orders table$")
    public void theOrderShouldBeAddedToTheAllOrdersTable() {
        Assert.assertEquals(order.orderList.size(),9);



    }

    @When("^Create the order with \"([^\"]*)\"$")
    public void createTheOrderWith(String product)  {
        order.findElementAndClick("orderLink");
        Select select=new Select(order.selectProduct);
        select.selectByVisibleText(product);

    }
}
