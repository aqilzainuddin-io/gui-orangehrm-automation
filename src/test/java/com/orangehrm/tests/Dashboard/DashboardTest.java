package com.orangehrm.tests.Dashboard;

import com.orangehrm.setup.BaseTest;
import com.orangehrm.pages.dashboard.DashboardPage;
import com.orangehrm.pages.login.LoginPage;
import com.orangehrm.setup.EnvReader;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

/**
 * DashboardTest
 *
 * Test class for validating the OrangeHRM Dashboard page.
 * Extends BaseTest to utilize WebDriver setup and teardown.
 * Steps include login, verifying dashboard widgets, and checking navigation links.
 */
public class DashboardTest extends BaseTest {

    // Page objects
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    /**
     * Initialize page objects before each test method
     */
    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    /**
     * Verify Dashboard page elements and navigation links
     * Steps:
     * 1. Login using valid credentials from .env
     * 2. Assert Dashboard header is displayed
     * 3. Print Dashboard title
     * 4. Verify all dashboard widgets are visible
     * 5. Verify all navigation links are visible
     */
    @Test
    public void verifyDashboard() throws InterruptedException  {
        System.out.println("Dashboard Test Begins");

        // Step 1: Login
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));

        // Step 2: Assert Dashboard header is visible
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard header not visible!");

        // Step 3: Print dashboard title for verification
        System.out.println("Dashboard title: " + dashboardPage.getDashboardTitle());

        // Step 4: Verify dashboard widgets
        Assert.assertTrue(dashboardPage.isQuickLaunchVisible(), "Quick Launch widget missing!");
        Assert.assertTrue(dashboardPage.isTimeAtWorkVisible(), "Time at Work widget missing!");
        Assert.assertTrue(dashboardPage.isMyActionsVisible(), "My Actions widget missing!");
        Assert.assertTrue(dashboardPage.isBuzzLatestPostsVisible(), "Buzz Latest Posts widget missing!");
        Assert.assertTrue(dashboardPage.isEmployeesOnLeaveTodayVisible(), "Employees On Leave Today widget missing!");
        Assert.assertTrue(dashboardPage.isEmployeeDistributionBySubUnitVisible(), "Employee Distribution By Unit missing!");
        Assert.assertTrue(dashboardPage.isEmployeeDistributionByLocationVisible(), "Employee Distribution By Location widget missing!");
        System.out.println("Done checking widgets");

        // Step 5: Verify navigation links
        Assert.assertTrue(dashboardPage.isAdminPageVisible(),"Admin navigation link missing!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(),"PIM navigation link missing!");
        Assert.assertTrue(dashboardPage.isLeavePageVisible(),"Leave navigation link missing!");
        Assert.assertTrue(dashboardPage.isTimePageVisible(),"Time navigation link missing!");
        Assert.assertTrue(dashboardPage.isRecruitmentPageVisible(),"Recruitment navigation link missing!");
        Assert.assertTrue(dashboardPage.isMyInfoPageVisible(),"My Info navigation link missing!");
        Assert.assertTrue(dashboardPage.isPerformancePageVisible(),"Performance navigation link missing!");
        Assert.assertTrue(dashboardPage.isDashboardPageVisible(),"Dashboard navigation link missing!");
        Assert.assertTrue(dashboardPage.isDirectoryPageVisible(),"Directory navigation link missing!");
        Assert.assertTrue(dashboardPage.isMaintenancePageVisible(),"Maintenance navigation link missing!");
        Assert.assertTrue(dashboardPage.isClaimPageVisible(),"Claim navigation link missing!");
        Assert.assertTrue(dashboardPage.isBuzzPageVisible(),"Buzz navigation link missing!");
        System.out.println("Done checking navigation links");

        System.out.println("Dashboard Test Ends");
    }
}
