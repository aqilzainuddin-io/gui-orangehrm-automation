package tests.Dashboard;

import setup.BaseTest;
import pages.dashboard.DashboardPage;
import pages.login.LoginPage;
import setup.EnvReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


public class DashboardTest extends BaseTest {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void verifyDashboard() throws InterruptedException  {
        // Step 1: Login
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));

        // Step 2: Assert Dashboard loaded
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard header not visible!");

        // Step 3: Title check
        System.out.println("Dashboard title: " + dashboardPage.getDashboardTitle());

        // Step 4: Verify all widgets visible
        Assert.assertTrue(dashboardPage.isQuickLaunchVisible(), "Quick Launch widget missing!");
        Assert.assertTrue(dashboardPage.isTimeAtWorkVisible(), "Time at Work widget missing!");
        Assert.assertTrue(dashboardPage.isMyActionsVisible(), "My Actions widget missing!");
        Assert.assertTrue(dashboardPage.isBuzzLatestPostsVisible(), "Buzz Latest Posts widget missing!");
        Assert.assertTrue(dashboardPage.isEmployeesOnLeaveTodayVisible(), "Employees On Leave Today widget missing!");
        Assert.assertTrue(dashboardPage.isEmployeeDistributionBySubUnitVisible(), "Employee Distribution By Unit missing!");
        Assert.assertTrue(dashboardPage.isEmployeeDistributionByLocationVisible(), "Employee Distribution By Location widget missing!");
        // checking purposes
        System.out.println("done checking widget");
        Thread.sleep(5000);

        // Step 5: Verify all navigation link visible
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
        // checking purposes
        System.out.println("done checking nav link");
        Thread.sleep(5000);
    }
}
