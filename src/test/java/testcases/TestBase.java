package testcases;
import config.ConfigManager;
import drivers.DriverFactory;
import drivers.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Listeners;
import support.TestListeners;

@Listeners({TestListeners.class})
public class TestBase {

    protected static WebDriver driver;
    protected static final String Base_URL = ConfigManager.getBaseUrl();

    @Parameters("browser")
    @BeforeTest
    public void setupDriver(@Optional("chrome") String browser) throws Exception {
        try {

            // Initialize the WebDriver using DriverFactory
            driver = DriverFactory.getNewInstance(browser);
            DriverHolder.setDriver(driver);
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
            driver.get(Base_URL);

            System.out.println("[INFO] Browser setup complete with URL: " + Base_URL);

        } catch (Exception e) {
            System.err.println("[ERROR] Failed to initialize the browser: " + e.getMessage());
            throw e;
        }
    }

    @AfterTest
    public void tearDown() throws Exception {
        try {
            if (driver != null) {
                driver.quit();
                System.out.println("[INFO] Browser closed successfully.");
            }
        } catch (WebDriverException e) {
            System.err.println("[ERROR] WebDriver exception during teardown: " + e.getMessage());
            throw e;
        } catch (Exception e) {
            System.err.println("[ERROR] Unexpected error during teardown: " + e.getMessage());
            throw e;
        } finally {
            try {
                DriverHolder.quitDriver();
                System.out.println("[INFO] DriverHolder cleanup complete.");
            } catch (Exception e) {
                System.err.println("[ERROR] Failed to clean up DriverHolder: " + e.getMessage());
            }
        }
    }

}




