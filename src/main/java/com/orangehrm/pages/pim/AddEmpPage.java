package com.orangehrm.pages.pim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.pages.BasePage;

/**
 * Page Object Model for Add Employee Page (PIM)
 * Contains locators and actions related to adding a new employee
 */
public class AddEmpPage extends BasePage {

    /**
     * Constructor for AddEmpPage
     *
     * @param driver WebDriver instance
     */
    public AddEmpPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Locators for Add Employee page labels
     */
    private By header = By.xpath("//h6[contains(normalize-space(),'PIM')]");
    private By pageTitle = By.xpath("//h6[contains(normalize-space(),'Add Employee')]");
    private By empFullName = By.xpath("//label[contains(normalize-space(),'Employee Full Name')]");
    private By empID = By.xpath("//label[contains(normalize-space(),'Employee Id')]");
    private By createLoginDetails = By.xpath("//p[contains(normalize-space(),'Create Login Details')]");
    private By username = By.xpath("//label[contains(normalize-space(),'Username')]");
    private By status = By.xpath("//label[contains(normalize-space(),'Status')]");
    private By password = By.xpath("//label[normalize-space(text())='Password']");
    private By confirmPassword = By.xpath("//label[normalize-space(text())='Confirm Password']");

    /**
     * Locators for Add Employee page input fields
     */
    private By empFirstName = By.xpath("//input[@name='firstName']");
    private By empLastName = By.xpath("//input[@name='lastName']");
    private By inputEmpID = By.xpath("//label[contains(normalize-space(),'Employee Id')]/../following-sibling::div//input");
    private By inputCreateLoginDetails = By.xpath("//p[contains(normalize-space(),'Create Login Details')]/following::span");
    private By inputUsername = By.xpath("//label[contains(normalize-space(),'Username')]/../following-sibling::div/input");
    private By statusEnabled = By.xpath("//div[@class='oxd-radio-wrapper']//label[contains(., 'Enabled')]");
    private By statusDisabled = By.xpath("//div[@class='oxd-radio-wrapper']//label[contains(., 'Disabled')]");
    private By inputPassword = By.xpath("//label[normalize-space(text())='Password']/../following-sibling::div/input");
    private By inputConfirmPassword = By.xpath("//label[normalize-space(text())='Confirm Password']/../following-sibling::div/input");

    /**
     * Locators for Add Employee page buttons
     */
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private By cancelBtn = By.xpath("//button[normalize-space()='Cancel']");

    /**
     * Locators for Add Employee page messages
     */
    private By successfullySavedMsg = By.xpath("//div/p[contains(normalize-space(),'Successfully Saved')]");

    /**
     * Waits until an element is visible on the page
     *
     * @param locator element locator
     * @param timeoutInSeconds wait duration
     * @return visible WebElement
     */
    private WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Verifies PIM header visibility
     */
    public boolean isHeaderDisplayed() {
        return waitForElementVisible(header, 10).isDisplayed();
    }

    /**
     * Verifies Add Employee page title visibility
     */
    public boolean isPageTitleVisible() {
        return waitForElementVisible(pageTitle, 10).isDisplayed();
    }

    /**
     * Verifies Employee Full Name label visibility
     */
    public boolean isEmpFullNameVisible() {
        return waitForElementVisible(empFullName, 10).isDisplayed();
    }

    /**
     * Verifies Employee ID label visibility
     */
    public boolean isEmpIDVisible() {
        return waitForElementVisible(empID, 10).isDisplayed();
    }

    /**
     * Verifies Create Login Details section visibility
     */
    public boolean isCreateLoginDetailsVisible() {
        return waitForElementVisible(createLoginDetails, 10).isDisplayed();
    }

    /**
     * Verifies Username label visibility
     */
    public boolean isUsernameVisible() {
        return waitForElementVisible(username, 10).isDisplayed();
    }

    /**
     * Verifies Status label visibility
     */
    public boolean isStatusVisible() {
        return waitForElementVisible(status, 10).isDisplayed();
    }

    /**
     * Verifies Password label visibility
     */
    public boolean isPasswordVisible() {
        return waitForElementVisible(password, 10).isDisplayed();
    }

    /**
     * Verifies Confirm Password label visibility
     */
    public boolean isConfirmPasswordVisible() {
        return waitForElementVisible(confirmPassword, 10).isDisplayed();
    }

    /**
     * Verifies successfully saved message visibility
     */
    public boolean isSuccessfullySavedMsgVisible() {
        return waitForElementVisible(successfullySavedMsg, 30).isDisplayed();
    }

    /**
     * Inputs employee first name
     *
     * @param empfirstname employee first name
     */
    public void inputEmpFirstName(String empfirstname) {
        waitForElementVisible(empFirstName, 5);
        if (!isElementDisplayed(empFirstName)) {
            System.out.println("Employee First Name input not visible!");
            return;
        }
        click(empFirstName);
        type(empFirstName, empfirstname);
    }

    /**
     * Inputs employee last name
     *
     * @param emplastname employee last name
     */
    public void inputEmpLastName(String emplastname) {
        waitForElementVisible(empLastName, 5);
        if (!isElementDisplayed(empLastName)) {
            System.out.println("Employee last name input not visible!");
            return;
        }
        click(empLastName);
        type(empLastName, emplastname);
    }

    /**
     * Inputs employee ID
     *
     * @param empID employee ID
     */
    public void inputEmpID(String empID) {
        waitForElementVisible(inputEmpID, 5);
        if (!isElementDisplayed(inputEmpID)) {
            System.out.println("Employee ID input not visible!");
            return;
        }
        click(inputEmpID);
        type(inputEmpID, empID);
    }

    /**
     * Inputs username for login details
     *
     * @param username application username
     */
    public void inputUsername(String username) {
        waitForElementVisible(inputUsername, 5);
        if (!isElementDisplayed(inputUsername)) {
            System.out.println("Username input not visible!");
            return;
        }
        click(inputUsername);
        type(inputUsername, username);
    }

    /**
     * Selects Enabled status
     */
    public void clickStatusEnable() {
        waitForElementVisible(statusEnabled, 5);
        if (!isElementDisplayed(statusEnabled)) {
            System.out.println("Status enable not visible!");
            return;
        }
        click(statusEnabled);
    }

    /**
     * Selects Disabled status
     */
    public void clickStatusDisable() {
        waitForElementVisible(statusDisabled, 5);
        if (!isElementDisplayed(statusDisabled)) {
            System.out.println("Status disable not visible!");
            return;
        }
        click(statusDisabled);
    }

    /**
     * Inputs password
     *
     * @param pass password value
     */
    public void inputPassword(String pass) {
        waitForElementVisible(inputPassword, 5);
        if (!isElementDisplayed(inputPassword)) {
            System.out.println("Password input not visible!");
            return;
        }
        click(inputPassword);
        type(inputPassword, pass);
    }

    /**
     * Inputs confirm password
     *
     * @param confirmpass confirm password value
     */
    public void inputConfirmPassword(String confirmpass) {
        waitForElementVisible(inputConfirmPassword, 5);
        if (!isElementDisplayed(inputConfirmPassword)) {
            System.out.println("Confirm password input not visible!");
            return;
        }
        click(inputConfirmPassword);
        type(inputConfirmPassword, confirmpass);
    }

    /**
     * Clicks Save button
     */
    public void clickSaveBtn() {
        waitForElementVisible(saveBtn, 5);
        if (!isElementDisplayed(saveBtn)) {
            System.out.println("Save button not visible!");
            return;
        }
        click(saveBtn);
    }

    /**
     * Clicks Cancel button
     */
    public void clickCancelBtn() {
        waitForElementVisible(cancelBtn, 5);
        if (!isElementDisplayed(cancelBtn)) {
            System.out.println("Cancel button not visible!");
            return;
        }
        click(cancelBtn);
    }

    /**
     * Clicks Create Login Details toggle
     */
    public void clickCreateLoginDetails() {
        waitForElementVisible(inputCreateLoginDetails, 5);
        if (!isElementDisplayed(inputCreateLoginDetails)) {
            System.out.println("Create login details toggle not visible!");
            return;
        }
        click(inputCreateLoginDetails);
    }
}