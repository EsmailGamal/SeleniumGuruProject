package Pages;
import core.BasePage;
import core.ElementActions;
import core.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.CustomerDataManager;

public class AddTariffPlanPage extends BasePage {
    private final ElementActions actions;

    public AddTariffPlanPage(WebDriver driver) {
        super(driver);
        this.actions = new ElementActions(driver);
    }

    private static final By customerIDField = By.id("customer_id");
    private static final By submitButton = By.xpath("//input[@name='submit']");
    private static final By tariffPlanRadioButton = By.id("sele");
    private static final By addPlanToCustomerButton = By.xpath("//input[@name='submit']");
    private static final By successMessage = By.xpath("//h2[normalize-space()='Congratulation Tariff Plan assigned']");

    public AddTariffPlanPage enterSavedCustomerId() {
        String customerId = CustomerDataManager.loadCustomerId();
        if (customerId == null || customerId.isEmpty()) {
            throw new RuntimeException("No saved Customer ID found. Please ensure a Customer ID was saved using ResultPage.extractAndSaveCustomerId()");
        }
        actions.type(customerIDField, customerId);
        return this;
    }

    public AddTariffPlanPage clickSubmitButton() {
        actions.click(submitButton);
        return this;
    }

public AddTariffPlanPage clickTariffPlanRadioButton() {
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    actions.forceClick(tariffPlanRadioButton);
    return this;
}
public AddTariffPlanPage clickAddPlanToCustomerButton() {
    actions.click(addPlanToCustomerButton);  
    return this;
}

public boolean isTarrifPlanAssignedSuccessfully() {
    try {
        return Waits.waitForVisible(driver, successMessage).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}
}