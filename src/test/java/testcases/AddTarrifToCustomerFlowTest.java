package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.AddTariffPlanPage;
import Pages.GuruHomePage;
import support.RetryAnalyzer;
import support.UserInfo;
import java.util.Map;

public class AddTarrifToCustomerFlowTest extends TestBase {

   
    @Test(priority = 2, description = "Verify Tariff Plan Is assigned to CustomerSuccessfully", retryAnalyzer = RetryAnalyzer.class)
    public void verifyTarrifPlanAssignedSuccessfully() {
        Map<String, String> user = UserInfo.get("user1");
        String firstName = user.get("firstName");
        String lastName = user.get("LastName");
        String mobileNumber = user.get("mobileNumber");
        String address = user.get("address");
        String email = user.get("email");

        AddTariffPlanPage tariffPlanPage = new GuruHomePage(driver)
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
                .clickHomeButton()
                .openBurgerMenu()
                .navigateToAddTariffPlanPage()
                .enterSavedCustomerId()
                .clickSubmitButton()
                .clickTariffPlanRadioButton()
                .clickAddPlanToCustomerButton();

        Assert.assertTrue(tariffPlanPage.isTarrifPlanAssignedSuccessfully(), 
                "Success message should be visible indicating Tariff Plan assigned successfully");
    }


}

