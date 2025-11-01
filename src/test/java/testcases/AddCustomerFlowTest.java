package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.GuruHomePage;
import support.RetryAnalyzer;
import support.UserInfo;
import java.util.Map;

public class AddCustomerFlowTest extends TestBase {

    @Test(priority = 1, description = "User Land Successfull on Guru 99  and Core elements should be visible", retryAnalyzer = RetryAnalyzer.class)
    public void coreElementsVisible() {
        GuruHomePage home = new GuruHomePage(driver);
        Assert.assertTrue(home.isLogoVisible(), "Logo should be visible on home page");
        Assert.assertTrue(home.isNavigationBarVisible(), "Navigation bar should be visible on home page");
    }


   
    @Test(priority = 2, description = "Verify Customer Is added Successfully", retryAnalyzer = RetryAnalyzer.class)
    public void verifyCustomerAddedSuccessfully() {
        GuruHomePage home = new GuruHomePage(driver);
        Map<String, String> user = UserInfo.get("user1");
        String firstName = user.get("firstName");
        String lastName = user.get("LastName");
        String mobileNumber = user.get("mobileNumber");
        String address = user.get("address");
        String email = user.get("email");

        new GuruHomePage(driver)
                .openBurgerMenu()
                .navigateToAddCustomerPage()
                .clickDoneCheckRadioButton()
                .enterFirstname(firstName)
                .enterLastname(lastName)
                .enterEmail(email)
                .enterPhone(mobileNumber)
                .enterAddress(address)
                .clickSubmitButton()
                .extractAndSaveCustomerId()
                .logGeneratedCustomerId()
                .clickHomeButton();
                Assert.assertTrue(home.isLogoVisible(), "Logo should be visible on home page");
    }


}

