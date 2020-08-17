package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPOM extends BasePOM {
    public OrderPOM() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameInput;
    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordInput;
    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;
    @FindBy(css = ".login_info")
    public WebElement welcomeMessage;
    @FindBy(css = ".SampleTable>tbody>tr:nth-child(n+2)")
    public List<WebElement> orderList;
    @FindBy(css = "input[type='checkbox']")
    public List<WebElement> checkboxList;
    @FindBy(id = "ctl00_MainContent_btnDelete")
    public WebElement deleteButton;
    @FindBy(id = "ctl00_MainContent_orderMessage")
    public WebElement orderMessage;
    @FindBy(xpath = "//a[text()='Order']")
    public WebElement orderLink;
    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement selectProduct;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement cutomerNameInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaCard;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNoInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDateInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;
    @FindBy(xpath = "//a[text()='View all orders']")
    public WebElement viewAllOrdersLink;
    @FindBy(xpath = "//table[@class='SampleTable']/tbody/tr[2]/td[preceding-sibling::td]")
    public List<WebElement>orderDetailList;

    WebElement myElement;


    public void findElementAndClick(String elementName) {
        switch (elementName) {
            case "loginButton":
                myElement = loginButton;
                break;
            case "deleteButton":
                myElement = deleteButton;
                break;
            case "orderLink":
                myElement = orderLink;
                break;
            case "visaCard":
                myElement = visaCard;
                break;
            case "processButton":
                myElement = processButton;
                break;
            case "viewAllOrdersLink":
                myElement = viewAllOrdersLink;
                break;

        }
        waitAndClick(myElement);
    }

    public void findElementAndSendKeys(String elementName, String value) {
        switch (elementName) {
            case "usernameInput":
                myElement = usernameInput;
                break;
            case "passwordInput":
                myElement = passwordInput;
                break;
            case "quantityInput":
                myElement = quantityInput;
                break;
            case "cutomerNameInput":
                myElement = cutomerNameInput;
                break;
            case "streetInput":
                myElement = streetInput;
                break;
            case "cityInput":
                myElement = cityInput;
                break;
            case "stateInput":
                myElement = stateInput;
                break;
            case "zipInput":
                myElement = zipInput;
                break;
            case "cardNoInput":
                myElement = cardNoInput;
                break;
            case "expireDateInput":
                myElement = expireDateInput;
                break;
        }
        waitAndSendKeys(myElement, value);
    }

}
