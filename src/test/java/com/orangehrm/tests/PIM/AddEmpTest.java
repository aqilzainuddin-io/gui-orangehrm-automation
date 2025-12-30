package com.orangehrm.tests.PIM;

import com.orangehrm.setup.BaseTest;
import com.orangehrm.setup.EnvReader;
import com.orangehrm.pages.dashboard.DashboardPage;
import com.orangehrm.pages.login.LoginPage;
import com.orangehrm.pages.pim.AddEmpPage;
import com.orangehrm.pages.pim.PIMPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * AddEmpTest
 *
 * Test class for adding a new employee in OrangeHRM.
 * Extends BaseTest to utilize WebDriver setup and teardown.
 * Steps include logging in, navigating to PIM, filling employee details, 
 * and verifying that the employee is successfully added.
 */
public class AddEmpTest extends BaseTest {
    
    // Page objects
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;
    private AddEmpPage addEmpPage;

    /**
     * Initialize page objects before each test method
     */
    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
        addEmpPage = new AddEmpPage(driver);
    }

    /**
     * Test adding a new employee
     * Steps:
     * 1. Login using valid credentials
     * 2. Navigate to PIM page from Dashboard
     * 3. Click Add button to open Add Employee form
     * 4. Verify all relevant form fields and labels are visible
     * 5. Fill in employee details and login info
     * 6. Save the employee
     * 7. Assert that success message is displayed
     */
    @Test
    public void addEmployee() throws InterruptedException {
        System.out.println("Add Employee Test Begins");

        // Step 1: Login
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));

        // Step 2: Verify dashboard and navigate to PIM
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(), "PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        // Step 3: Verify PIM page header and click Add
        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(), "PIM header not displayed!");
        pimPage.clickAddBtn();

        // Step 4: Verify Add Employee form elements
        Assert.assertTrue(addEmpPage.isHeaderDisplayed(), "PIM header not displayed!");
        Assert.assertTrue(addEmpPage.isPageTitleVisible(), "Add employee title not displayed!");
        Assert.assertTrue(addEmpPage.isEmpFullNameVisible(), "Employee full name not displayed!");
        Assert.assertTrue(addEmpPage.isEmpIDVisible(), "Employee id not displayed!");
        Assert.assertTrue(addEmpPage.isCreateLoginDetailsVisible(), "Create login details not displayed!");
        addEmpPage.clickCreateLoginDetails();
        Assert.assertTrue(addEmpPage.isUsernameVisible(), "Username not displayed!");
        Assert.assertTrue(addEmpPage.isStatusVisible(), "Status not displayed!");
        Assert.assertTrue(addEmpPage.isPasswordVisible(), "Password not displayed!");
        Assert.assertTrue(addEmpPage.isConfirmPasswordVisible(), "Confirm password is not displayed!");

        // Step 5: Fill in employee details
        addEmpPage.inputEmpFirstName("John52");
        addEmpPage.inputEmpLastName("Doe");
        addEmpPage.inputEmpID("8989");
        addEmpPage.inputUsername("JohnDoe52");
        addEmpPage.clickStatusEnable();
        addEmpPage.inputPassword("JDoe5245");
        addEmpPage.inputConfirmPassword("JDoe5245");

        // Step 6: Save employee
        addEmpPage.clickSaveBtn();

        // Step 7: Verify success message
        Assert.assertTrue(addEmpPage.isSuccessfullySavedMsgVisible(), "Successfully saved message not displayed!");

        System.out.println("Add Employee Test Ends");
    }
}
