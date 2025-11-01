package Pages;
import core.BasePage;
import core.ElementActions;
import core.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 

public class GuruHomePage extends BasePage {
    private final ElementActions actions;

    public GuruHomePage(WebDriver driver) {
        super(driver);
        this.actions = new ElementActions(driver);
    }

    private static final By websiteLogo = By.xpath("//a[@class='logo']");
    private static final By pageTitle = By.xpath("//a[normalize-space()='Demo Site']");
    private static final By navigationBar = By.id("navbar-brand-centered");
    private static final By burgerMenuToggle = By.xpath("//nav[@class='left']//a[@href='#menu']");
    private static final By addCustomerLink = By.xpath("//ul[@class='links']//li//a[@href='addcustomer.php'][normalize-space()='Add Customer']");
    private static final By addTariffPlanLink = By.xpath("//ul[@class='links']//li//a[@href='assigntariffplantocustomer.php'][normalize-space()='Add Tariff Plan to Customer']");
    

    public AddCustomerPage navigateToAddCustomerPage() {
        actions.click(addCustomerLink);
        return new AddCustomerPage(driver);
    }

    public AddTariffPlanPage navigateToAddTariffPlanPage() {
        actions.click(addTariffPlanLink);
        return new AddTariffPlanPage(driver);
    }

    public GuruHomePage openBurgerMenu() {
        actions.click(burgerMenuToggle);
        return this;
    }

    public boolean isLogoVisible() {
        try {
            return Waits.waitForVisible(driver, websiteLogo).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNavigationBarVisible() {
        try {
            return Waits.waitForVisible(driver, navigationBar).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getHeaderText() {
        return Waits.waitForVisible(driver, pageTitle).getText();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean urlContains(String expectedSubstring) {
        return getCurrentUrl().contains(expectedSubstring);
    }

}
