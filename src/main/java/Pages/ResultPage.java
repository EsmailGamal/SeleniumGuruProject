package Pages;
import core.BasePage;
import core.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.CustomerDataManager;


public class ResultPage extends BasePage {
    private final ElementActions actions;

    public ResultPage(WebDriver driver) {
        super(driver);
        this.actions = new ElementActions(driver);
    }

    private static final By customerIDValue = By.xpath("//b[normalize-space(.)='Customer ID']/ancestor::td/following-sibling::td//h3");
    private static final By customerIDTitle = By.xpath("//b[normalize-space(.)='Customer ID']");
    private static final By homeButton = By.xpath("//a[@class='button']");
    
  
    public String getCustomerId() {
        return actions.getText(customerIDValue).trim();
    }

   
    public ResultPage saveCustomerId() {
        String customerId = getCustomerId();
        CustomerDataManager.saveCustomerId(customerId);
        return this;
    }

    
    public ResultPage extractAndSaveCustomerId() {
        return saveCustomerId();
    }

    public ResultPage logGeneratedCustomerId() {
        String id = getCustomerId();
        System.out.println("Generated Customer ID: " + id);
        return this;
    }
    
    public GuruHomePage clickHomeButton() {
        actions.click(homeButton);
        return new GuruHomePage(driver);
    }

}