package pages.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.BasePage;


public class DashboardPage extends BasePage {

    // locator for something visible only when login is successful
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By quickLaunch = By.xpath("//p[text()='Quick Launch']");
    private By timeAtWork = By.xpath("//p[text()='Time at Work']");
    private By myActions = By.xpath("//p[text()='My Actions']");
    private By buzzLatestPosts = By.xpath("//p[text()='Buzz Latest Posts']");
    private By employeesOnLeaveToday = By.xpath("//p[text()='Employees on Leave Today']");
    private By employeeDistributionbySubUnit = By.xpath("//p[text()='Employee Distribution by Sub Unit']");
    private By employeeDistributionbyLocation = By.xpath("//p[text()='Employee Distribution by Location']");

    // locator for all page in navigation bar
    private By adminPage = By.xpath("//span[text()='Admin']");
    private By pimPage = By.xpath("//span[text()='PIM']");
    private By leavePage = By.xpath("//span[text()='Leave']");
    private By timePage = By.xpath("//span[text()='Time']");
    private By recruitmentPage = By.xpath("//span[text()='Recruitment']");
    private By myInfoPage = By.xpath("//span[text()='My Info']");
    private By performancePage = By.xpath("//span[text()='Performance']");
    private By dashboardPage = By.xpath("//span[text()='Dashboard']");
    private By directoryPage = By.xpath("//span[text()='Directory']");
    private By maintenancePage = By.xpath("//span[text()='Maintenance']");
    private By claimPage = By.xpath("//span[text()='Claim']");
    private By buzzPage = By.xpath("//span[text()='Buzz']");

    // constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    // method
    public boolean isDashboardHeaderDisplayed() {
        return isElementDisplayed(dashboardHeader);
    }

    public String getDashboardTitle() {
        return getText(dashboardHeader);
    }

    public boolean isQuickLaunchVisible() {
        return isElementDisplayed(quickLaunch);
    }

    public boolean isTimeAtWorkVisible() {
        return isElementDisplayed(timeAtWork);
    }

    public boolean isMyActionsVisible() {
        return isElementDisplayed(myActions);
    }

    public boolean isBuzzLatestPostsVisible() {
        return isElementDisplayed(buzzLatestPosts);
    }

    public boolean isEmployeesOnLeaveTodayVisible() {
        return isElementDisplayed(employeesOnLeaveToday);
    }

    public boolean isEmployeeDistributionBySubUnitVisible() {
        return isElementDisplayed(employeeDistributionbySubUnit);
    }

    public boolean isEmployeeDistributionByLocationVisible() {
        return isElementDisplayed(employeeDistributionbyLocation);
    }

    // method 
    public boolean isAdminPageVisible(){
        return isElementDisplayed(adminPage);
    }
    public boolean isPIMPageVisible(){
        return isElementDisplayed(pimPage);
    }
    public boolean isLeavePageVisible(){
        return isElementDisplayed(leavePage);
    }
    public boolean isTimePageVisible(){
        return isElementDisplayed(timePage);
    }
    public boolean isRecruitmentPageVisible(){
        return isElementDisplayed(recruitmentPage);
    }
    public boolean isMyInfoPageVisible(){
        return isElementDisplayed(myInfoPage);
    }
    public boolean isPerformancePageVisible(){
        return isElementDisplayed(performancePage);
    }
    public boolean isDashboardPageVisible(){
        return isElementDisplayed(dashboardPage);
    }
    public boolean isDirectoryPageVisible(){
        return isElementDisplayed(directoryPage);
    }
    public boolean isMaintenancePageVisible(){
        return isElementDisplayed(maintenancePage);
    }
    public boolean isClaimPageVisible(){
        return isElementDisplayed(claimPage);
    }
    public boolean isBuzzPageVisible(){
        return isElementDisplayed(buzzPage);
    }

    public void clickAdminPage(){
        click(adminPage);
    }
    public void clickPIMPage(){
        if(!isElementDisplayed(pimPage)){
            System.out.println("PIM navigation link not visible!");
        }
        click(pimPage);
        System.out.println("PIM navigation link clicked");
    }
}