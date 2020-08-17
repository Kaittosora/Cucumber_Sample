package StepDefinition;

import PageObjectModel.OrderPOM;
import Utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Part1Steps {
    public WebDriver driver= Driver.getDriver();
    OrderPOM order=new OrderPOM();

    @Given("^Navigate to the website$")
    public void navigateToTheWebsite() {
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
    }

    @When("^Enter the username and password and click on login button$")
    public void enterTheUsernameAndPasswordAndClickOnLoginButton() {
        order.findElementAndSendKeys("usernameInput","Tester");
        order.findElementAndSendKeys("passwordInput","test");
        order.findElementAndClick("loginButton");
    }

    @Then("^User should login successfully$")
    public void userShouldLoginSuccessfully() {
        order.ElementContainsText(order.welcomeMessage,"Welcome");

    }

    @Then("^It should be (\\d+) orders on the page$")
    public void itShouldBeOrdersOnThePage(int arg0) {
        Assert.assertEquals(order.orderList.size(),8);
    }

    @When("^Delete all orders$")
    public void deleteAllOrders() {
        for (WebElement element : order.checkboxList) {
            element.click();
        }
        order.findElementAndClick("deleteButton");

    }

    @Then("^All orders page should be empty$")
    public void allOrdersPageShouldBeEmpty() {
        order.ElementContainsText(order.orderMessage,"empty");
    }
}
