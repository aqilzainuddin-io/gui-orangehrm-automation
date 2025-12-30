package com.orangehrm.tests.PIM;

import com.orangehrm.setup.EnvReader;
import com.orangehrm.setup.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.pages.dashboard.DashboardPage;
import com.orangehrm.pages.login.LoginPage;
import com.orangehrm.pages.pim.PIMPage;
import com.orangehrm.pages.pim.EditEmpPage;

/**
 * EditEmpTest
 *
 * Test class for editing an existing employee's details in OrangeHRM.
 * Extends BaseTest to utilize WebDriver setup and teardown.
 * Steps include logging in, searching for the employee, editing first and last name,
 * saving changes, and verifying that the update is reflected in the system.
 */
public class EditEmpTest extends BaseTest {

    // Page objects
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;
    private EditEmpPage editEmpPage;

    /**
     * Initialize page objects before each test method
     */
    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
        editEmpPage = new EditEmpPage(driver);
    }

    /**
     * Test searching for an employee and updating their first and last name
     * Steps:
     * 1. Login using valid credentials
     * 2. Navigate to PIM page from Dashboard
     * 3. Search for employee by name and ID
     * 4. Verify employee record exists
     * 5. Click Edit and update employee first and last name
     * 6. Save changes and verify success message
     * 7. Re-search to confirm that changes are reflected
     */
    @Test
    public void searchByUpdatedEmployeeNameAndID() throws InterruptedException {
        System.out.println("Edit Employee Test Begins");

        // Step 1: Login
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));

        // Step 2: Verify dashboard and navigate to PIM
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(), "PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        // Step 3: Verify PIM page header and search employee
        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(), "PIM header not displayed!");
        pimPage.inputEmployeeName("John52 Doe");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();

        // Step 4: Verify employee record exists
        Assert.assertTrue(pimPage.isRecordFoundByFirstLastNameVisible(), "Registered first name and last name not displayed!");
        Assert.assertTrue(pimPage.isRecordFoundByIDVisible(), "Registered ID not displayed!");

        // Step 5: Edit employee details
        pimPage.clickEditBtn();
        Assert.assertTrue(editEmpPage.isPersonalDetailsHeaderDisplayed(), "Edit Employee header not displayed!");
        Assert.assertTrue(editEmpPage.isEmpFullNameTitleDisplayed(), "Employee full name label not displayed!");
        editEmpPage.updateEmpFirstName("FinnTeo");
        editEmpPage.updateEmpLastName("Enstain");
        editEmpPage.clickSaveBtn();

        // Step 6: Verify success message
        Assert.assertTrue(editEmpPage.isSuccessfullySavedMsgVisible(), "Successfully saved message not displayed!");

        // Step 7: Re-search to verify updates
        dashboardPage.clickPIMPage();
        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(), "PIM header not displayed!");
        pimPage.inputEmployeeName("FinnTeo Enstain");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();
        Assert.assertTrue(pimPage.isUpdatedRecordFoundByFirstLastNameVisible(), "Updated first name and last name not displayed!");
        Assert.assertTrue(pimPage.isRecordFoundByIDVisible(), "Registered ID not displayed!");

        System.out.println("Edit Employee Test Ends");
    }
}
