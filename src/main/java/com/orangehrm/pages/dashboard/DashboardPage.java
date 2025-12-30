package com.orangehrm.pages.dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.pages.BasePage;

/**
 * Page Object Model for Dashboard Page
 * Contains locators and actions related to the Dashboard screen
 */
public class DashboardPage extends BasePage {

    /**
     * Locators for Dashboard Page widgets
     */
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");
    private By quickLaunch = By.xpath("//p[text()='Quick Launch']");
    private By timeAtWork = By.xpath("//p[text()='Time at Work']");
    private By myActions = By.xpath("//p[text()='My Actions']");
    private By buzzLatestPosts = By.xpath("//p[text()='Buzz Latest Posts']");
    private By employeesOnLeaveToday = By.xpath("//p[text()='Employees on Leave Today']");
    private By employeeDistributionbySubUnit = By.xpath("//p[text()='Employee Distribution by Sub Unit']");
    private By employeeDistributionbyLocation = By.xpath("//p[text()='Employee Distribution by Location']");

    /**
     * Locators for Dashboard left navigation menu
     */
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

    /**
     * Constructor for DashboardPage
     *
     * @param driver WebDriver instance
     */
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Waits until an element is visible on the page
     *
     * @param locator element locator
     * @param timeoutInSeconds wait duration
     * @return visible WebElement
     */
    private WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Verifies Dashboard header is displayed
     */
    public boolean isDashboardHeaderDisplayed() {
        return isElementDisplayed(dashboardHeader);
    }

    /**
     * Returns Dashboard page title text
     */
    public String getDashboardTitle() {
        return getText(dashboardHeader);
    }

    /**
     * Verifies Quick Launch widget visibility
     */
    public boolean isQuickLaunchVisible() {
        return isElementDisplayed(quickLaunch);
    }

    /**
     * Verifies Time at Work widget visibility
     */
    public boolean isTimeAtWorkVisible() {
        return isElementDisplayed(timeAtWork);
    }

    /**
     * Verifies My Actions widget visibility
     */
    public boolean isMyActionsVisible() {
        return isElementDisplayed(myActions);
    }

    /**
     * Verifies Buzz Latest Posts widget visibility
     */
    public boolean isBuzzLatestPostsVisible() {
        return isElementDisplayed(buzzLatestPosts);
    }

    /**
     * Verifies Employees on Leave Today widget visibility
     */
    public boolean isEmployeesOnLeaveTodayVisible() {
        return isElementDisplayed(employeesOnLeaveToday);
    }

    /**
     * Verifies Employee Distribution by Sub Unit widget visibility
     */
    public boolean isEmployeeDistributionBySubUnitVisible() {
        return isElementDisplayed(employeeDistributionbySubUnit);
    }

    /**
     * Verifies Employee Distribution by Location widget visibility
     */
    public boolean isEmployeeDistributionByLocationVisible() {
        return isElementDisplayed(employeeDistributionbyLocation);
    }

    /**
     * Verifies Admin navigation link visibility
     */
    public boolean isAdminPageVisible() {
        return isElementDisplayed(adminPage);
    }

    /**
     * Verifies PIM navigation link visibility
     */
    public boolean isPIMPageVisible() {
        return isElementDisplayed(pimPage);
    }

    /**
     * Verifies Leave navigation link visibility
     */
    public boolean isLeavePageVisible() {
        return isElementDisplayed(leavePage);
    }

    /**
     * Verifies Time navigation link visibility
     */
    public boolean isTimePageVisible() {
        return isElementDisplayed(timePage);
    }

    /**
     * Verifies Recruitment navigation link visibility
     */
    public boolean isRecruitmentPageVisible() {
        return isElementDisplayed(recruitmentPage);
    }

    /**
     * Verifies My Info navigation link visibility
     */
    public boolean isMyInfoPageVisible() {
        return isElementDisplayed(myInfoPage);
    }

    /**
     * Verifies Performance navigation link visibility
     */
    public boolean isPerformancePageVisible() {
        return isElementDisplayed(performancePage);
    }

    /**
     * Verifies Dashboard navigation link visibility
     */
    public boolean isDashboardPageVisible() {
        return isElementDisplayed(dashboardPage);
    }

    /**
     * Verifies Directory navigation link visibility
     */
    public boolean isDirectoryPageVisible() {
        return isElementDisplayed(directoryPage);
    }

    /**
     * Verifies Maintenance navigation link visibility
     */
    public boolean isMaintenancePageVisible() {
        return isElementDisplayed(maintenancePage);
    }

    /**
     * Verifies Claim navigation link visibility
     */
    public boolean isClaimPageVisible() {
        return isElementDisplayed(claimPage);
    }

    /**
     * Verifies Buzz navigation link visibility
     */
    public boolean isBuzzPageVisible() {
        return isElementDisplayed(buzzPage);
    }

    /**
     * Clicks on Admin page from navigation menu
     */
    public void clickAdminPage() {
        click(adminPage);
    }

    /**
     * Clicks on PIM page from navigation menu
     * Waits until the element is visible before clicking
     */
    public void clickPIMPage() {
        waitForElementVisible(pimPage, 5);

        if (!isElementDisplayed(pimPage)) {
            System.out.println("PIM navigation link not visible!");
        }

        click(pimPage);
        System.out.println("PIM navigation link clicked");
    }
}