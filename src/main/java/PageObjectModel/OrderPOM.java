package PageObjectModel;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;

public class OrderPOM extends BasePOM {
    public OrderPOM() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "ctl00_MainContent_username")
    private WebElement usernameInput;
    @FindBy(id = "ctl00_MainContent_password")
    private WebElement passwordInput;
    @FindBy(id = "ctl00_MainContent_login_button")
    private WebElement loginButton;
    @FindBy(css = ".login_info")
    private WebElement welcomeMessage;
    @FindBy(css = ".SampleTable>tbody>tr:nth-child(n+2)")
    private List<WebElement> orderList;
    @FindBy(id = "ctl00_MainContent_btnCheckAll")
    private WebElement checkAllButton;
    @FindBy(id = "ctl00_MainContent_btnDelete")
    private WebElement deleteButton;
    @FindBy(id = "ctl00_MainContent_orderMessage")
    private WebElement orderMessage;
    @FindBy(xpath = "//a[text()='Order']")
    private WebElement orderLink;
    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    private WebElement selectProduct;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantityInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement customerNameInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement streetInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement cityInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    private WebElement stateInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    private WebElement zipInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    private WebElement visaCard;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    private WebElement cardNoInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    private WebElement expireDateInput;
    @FindBy(id = "ctl00_MainContent_fmwOrder_InsertButton")
    private WebElement processButton;
    @FindBy(xpath = "//a[text()='View all orders']")
    private WebElement viewAllOrdersLink;
    @FindBy(xpath = "//table[@class='SampleTable']/tbody/tr[2]/td[preceding-sibling::td]")
    private List<WebElement>orderDetailList;
    @FindBy(xpath = "//table[@class='SampleTable']/tbody/tr[7]/td[preceding-sibling::td]")
    private List<WebElement>BobsDetailList;

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
                case "checkAllButton":
                myElement = checkAllButton;
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
                myElement = customerNameInput;
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
    List<WebElement>myList;
    public void findListAndVerifySize(String listName,int num){
        switch (listName){
            case "orderList":
                myList=orderList;
                break;
            case "orderDetailList":
                myList=orderDetailList;
                break;
        }
        listSizeVerify(myList,num);
    }
    public void findElementAndVerifyElementContainText(String elementName , String text) {

        switch (elementName) {
            case "welcomeMessage":
                myElement = welcomeMessage;
                break;
            case "orderMessage":
                myElement = orderMessage;
                break;
        }
        ElementContainsText(myElement, text);
    }
    public void findElementAndSelect(String elementName, String str){
        switch (elementName){
            case "selectProduct":
                myElement=selectProduct;
                break;
        }
        waitAndSelect(myElement,str);
    }
    public void findListAndCompareWithOtherOne(String listName, List<String>list){
        switch (listName){
            case "BobsDetailList":
                myList=BobsDetailList;
                break;
        }
        listContainsAllOtherList(BobsDetailList,list);
    }

    public void findListAndCompareWithMapValues(String listName, Map<String,String>map){
        switch (listName){
            case "orderDetailList":
                myList=orderDetailList;
                break;
        }
        listContainsAllOtherMapValues(orderDetailList,map);
    }
}
