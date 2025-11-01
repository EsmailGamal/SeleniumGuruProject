package Pages;
import core.BasePage;
import core.ElementActions;
import core.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 

public class AddCustomerPage extends BasePage {
    private final ElementActions actions;

    public AddCustomerPage(WebDriver driver) {
        super(driver);
        this.actions = new ElementActions(driver);
    }

    private static final By addCustomerTitle = By.xpath("//h1[normalize-space()='Add Customer']");
    private static final By doneCheckRadioButton = By.xpath("//label[@for='done']");
    private static final By pendingRadioButton = By.xpath("//label[@for='pending']");
    private static final By firstnameField = By.id("fname");
    private static final By lastnameField = By.id("lname");
    private static final By emailField = By.id("email");
    private static final By addressField = By.xpath("//textarea[@id='message']");
    private static final By phoneField = By.id("telephoneno");
    private static final By submitButton = By.xpath("//input[@name='submit']");

    public AddCustomerPage clickDoneCheckRadioButton() {
        actions.click(doneCheckRadioButton);
        return this;
    }

    public AddCustomerPage clickPendingCheckRadioButton() {
        actions.click(pendingRadioButton);
        return this;
    }

    public AddCustomerPage enterFirstname(String firstname) {
        actions.type(firstnameField, firstname);
        return this;
    }

    public AddCustomerPage enterLastname(String lastname) {
        actions.type(lastnameField, lastname);
        return this;
    }

    public AddCustomerPage enterEmail(String email) {
        actions.type(emailField, email);
        return this;
    }

    public AddCustomerPage enterAddress(String address) {
        actions.type(addressField, address);
        return this;
    }

    public AddCustomerPage enterPhone(String phone) {
        actions.type(phoneField, phone);
        return this;
    }

    public ResultPage clickSubmitButton() {
        actions.click(submitButton);
        return new ResultPage (driver);
    }
    
}