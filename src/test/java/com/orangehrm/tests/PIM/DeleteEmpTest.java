package com.orangehrm.tests.PIM;

import com.orangehrm.setup.EnvReader;
import com.orangehrm.setup.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.pages.dashboard.DashboardPage;
import com.orangehrm.pages.login.LoginPage;
import com.orangehrm.pages.pim.PIMPage;

/**
 * DeleteEmpTest
 *
 * Test class for deleting an existing employee in OrangeHRM.
 * Extends BaseTest to utilize WebDriver setup and teardown.
 * Steps include logging in, searching for the employee, deleting, 
 * and verifying that the employee no longer exists in the system.
 */
public class DeleteEmpTest extends BaseTest {

    // Page objects
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;

    /**
     * Initialize page objects before each test method
     */
    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
    }

    /**
     * Test deleting an employee
     * Steps:
     * 1. Login using valid credentials
     * 2. Navigate to PIM page from Dashboard
     * 3. Search for employee by name and ID
     * 4. Verify employee record exists
     * 5. Click Delete and confirm
     * 6. Verify success message is displayed
     * 7. Search again to ensure employee is no longer present
     */
    @Test
    public void deleteEmployeeTest() throws InterruptedException {
        System.out.println("Delete Employee Test Begins");

        // Step 1: Login
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));

        // Step 2: Verify dashboard and navigate to PIM
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(), "PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        // Step 3: Verify PIM page header and search employee
        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(), "PIM header not displayed!");
        pimPage.inputEmployeeName("FinnTeo Enstain");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();

        // Step 4: Verify employee record exists
        Assert.assertTrue(pimPage.isUpdatedRecordFoundByFirstLastNameVisible(), "Registered first name and last name not displayed!");
        Assert.assertTrue(pimPage.isRecordFoundByIDVisible(), "Registered ID not displayed!");

        // Step 5: Delete employee
        pimPage.clickDeleteBtn();
        Assert.assertTrue(pimPage.isPopoutConfirmationDltMsgVisible(), "Popout confirmation delete message not displayed!");
        pimPage.confirmDeleteBtn();

        // Step 6: Verify success message
        Assert.assertTrue(pimPage.isSuccessfullyDeletedMsgVisible(), "Successfully deleted message not displayed!");

        // Step 7: Search again to ensure record is gone
        pimPage.inputEmployeeName("FinnTeo Enstain");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();
        Assert.assertFalse(pimPage.isUpdatedRecordFoundByFirstLastNameExist(), "Registered first name and last name still displayed!");
        Assert.assertFalse(pimPage.isRecordFoundByIDExist(), "Registered ID still displayed!");

        System.out.println("Delete Employee Test Ends");
    }
}
