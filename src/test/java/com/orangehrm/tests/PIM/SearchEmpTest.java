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
 * SearchEmpTest
 *
 * Test class for searching employees in OrangeHRM PIM module.
 * Extends BaseTest to utilize WebDriver setup and teardown.
 * Includes tests for searching by employee ID, name, and a combination of both.
 */
public class SearchEmpTest extends BaseTest  {

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
     * Test searching an employee by ID only
     */
    @Test
    public void searchEmployeeByID() throws InterruptedException {
        System.out.println("PIM Test Begins");

        // Login
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));

        // Verify dashboard and navigate to PIM
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(), "PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        // Verify PIM header and search employee by ID
        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(), "PIM header not displayed!");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();
        Assert.assertTrue(pimPage.isRecordFoundByIDVisible(), "Registered ID not displayed!");

        System.out.println("PIM Test Ends");
    }

    /**
     * Test searching an employee by name only
     */
    @Test
    public void searchByEmployeeName() throws InterruptedException {
        // Login
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));

        // Verify dashboard and navigate to PIM
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(), "PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        // Verify PIM header and search employee by name
        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(), "PIM header not displayed!");
        pimPage.inputEmployeeName("John52 Doe");
        pimPage.clickSearchBtn();
        Assert.assertTrue(pimPage.isRecordFoundByFirstLastNameVisible(), "Registered first name and last name not displayed!");
    }

    /**
     * Test searching an employee by both name and ID
     */
    @Test
    public void searchByEmployeeNameAndID() throws InterruptedException {
        // Login
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));

        // Verify dashboard and navigate to PIM
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(), "PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        // Verify PIM header and search employee by name and ID
        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(), "PIM header not displayed!");
        pimPage.inputEmployeeName("John52 Doe");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();
        Assert.assertTrue(pimPage.isRecordFoundByFirstLastNameVisible(), "Registered first name and last name not displayed!");
        Assert.assertTrue(pimPage.isRecordFoundByIDVisible(), "Registered ID not displayed!");
    }
}
