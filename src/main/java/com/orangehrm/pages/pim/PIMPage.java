package com.orangehrm.pages.pim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.pages.BasePage;

/**
 * Page Object Model for PIM Page
 * Contains locators and actions related to employee search, add, edit, and delete
 */
public class PIMPage extends BasePage {

    /**
     * Constructor for PIMPage
     *
     * @param driver WebDriver instance
     */
    public PIMPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Locators for PIM page headers and titles
     */
    private By pimHeader = By.xpath("//h6[text()='PIM']");
    private By employeeInformation = By.xpath("//h5[contains(normalize-space(),'Employee Info')]");

    /**
     * Locators for employee name field
     */
    private By employeeName = By.xpath("//label[contains(normalize-space(),'Employee Name')]");
    private By inputEmployeeName = By.xpath("//label[contains(normalize-space(),'Employee Name')]/../following-sibling::div//input");

    /**
     * Locators for employee ID field
     */
    private By employeeID = By.xpath("//label[contains(normalize-space(),'Employee Id')]");
    private By inputEmployeeID = By.xpath("//label[contains(normalize-space(),'Employee Id')]/../following-sibling::div//input");

    /**
     * Locators for employment status dropdown
     */
    private By employmentStatus = By.xpath("//label[contains(normalize-space(),'Employment Status')]");
    private By inputEmploymentStatus = By.xpath("//label[contains(normalize-space(),'Employment Status')]/../following-sibling::div");

    /**
     * Dynamic locator for employment status options
     *
     * @param employmentStatusOption option text
     * @return option locator
     */
    private By employmentStatusOption(String employmentStatusOption) {
        return By.xpath("//div//span[contains(normalize-space(),'" + employmentStatusOption + "')]");
    }

    /**
     * Locators for include dropdown
     */
    private By include = By.xpath("//label[contains(normalize-space(),'Include')]");
    private By inputInclude = By.xpath("//label[contains(normalize-space(),'Include')]/../following-sibling::div");

    /**
     * Dynamic locator for include options
     *
     * @param includeOption option text
     * @return option locator
     */
    private By includeOption(String includeOption) {
        return By.xpath("//div//span[text()='" + includeOption + "']");
    }

    /**
     * Locators for supervisor name field
     */
    private By supervisorName = By.xpath("//label[contains(normalize-space(),'Supervisor Name')]");
    private By inputSupervisorName = By.xpath("//label[contains(normalize-space(),'Supervisor Name')]/../following-sibling::div//input");

    /**
     * Locators for job title dropdown
     */
    private By jobTitle = By.xpath("//label[contains(normalize-space(),'Job Title')]");
    private By inputJobTitle = By.xpath("//label[contains(normalize-space(),'Job Title')]/../following-sibling::div");

    /**
     * Dynamic locator for job title options
     *
     * @param jobTitleOption option text
     * @return option locator
     */
    private By jobTitleOption(String jobTitleOption) {
        return By.xpath("//div//span[contains(text(),'" + jobTitleOption + "')]");
    }

    /**
     * Locators for sub unit dropdown
     */
    private By subUnit = By.xpath("//label[contains(normalize-space(),'Sub Unit')]");
    private By inputSubUnit = By.xpath("//label[contains(normalize-space(),'Sub Unit')]/../following-sibling::div");

    /**
     * Dynamic locator for sub unit options
     *
     * @param subUnitOption option text
     * @return option locator
     */
    private By subUnitOption(String subUnitOption) {
        return By.xpath("//div//span[contains(text(),'" + subUnitOption + "')]");
    }

    /**
     * Locators for action buttons
     */
    private By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private By resetBtn = By.xpath("//button[normalize-space()='Reset']");
    private By addBtn = By.xpath("//button[normalize-space()='Add']");
    private By editBtn = By.xpath("//div[text()='8989']/following::div[@class='oxd-table-cell-actions']//i[@class='oxd-icon bi-pencil-fill']");
    private By deleteBtn = By.xpath("//div[text()='8989']/following::div[@class='oxd-table-cell-actions']//i[@class='oxd-icon bi-trash']");

    /**
     * Locators for delete confirmation dialog
     */
    private By popoutConfirmationDltMsg = By.xpath("//div[@class='orangehrm-modal-header']//p[text()='Are you Sure?']");
    private By confirmDltBtn = By.xpath("//button[normalize-space()='Yes, Delete']");
    private By cancelDltBtn = By.xpath("//button[normalize-space()='No, Cancel']");
    private By successfullyDeletedMsg = By.xpath("//div[contains(@class,'oxd-toast-content--success')]//p[text()='Successfully Deleted']");

    /**
     * Locators for search results and records
     */
    private By recordFoundTitle = By.xpath("//span[contains(normalize-space(),'Record Found')]");
    private By recordFoundByID = By.xpath("//div[text()='8989']");
    private By recordFoundByFirstLastName = By.xpath("//div[contains(@class, 'oxd-table-row') and .//div[normalize-space(text())='John52'] and .//div[normalize-space(text())='Doe']]");
    private By updatedRecordFoundByFirstLastName = By.xpath("//div[contains(@class, 'oxd-table-row') and .//div[normalize-space(text())='FinnTeo'] and .//div[normalize-space(text())='Enstain']]");

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
    public boolean isPIMHeaderDisplayed() {
        return isElementDisplayed(pimHeader);
    }

    /**
     * Verifies Employee Information section visibility
     */
    public boolean isEmployeeInformationVisible() {
        return isElementDisplayed(employeeInformation);
    }

    /**
     * Verifies Employee Name label visibility
     */
    public boolean isEmployeeNameVisisble() {
        return isElementDisplayed(employeeName);
    }

    /**
     * Verifies Employee ID label visibility
     */
    public boolean isEmployeeIDVisible() {
        return isElementDisplayed(employeeID);
    }

    /**
     * Verifies Employment Status label visibility
     */
    public boolean isEmploymentStatusVisible() {
        return isElementDisplayed(employmentStatus);
    }

    /**
     * Verifies Include label visibility
     */
    public boolean isIncludeVisible() {
        return isElementDisplayed(include);
    }

    /**
     * Verifies Supervisor Name label visibility
     */
    public boolean isSupervisorNameVisible() {
        return isElementDisplayed(supervisorName);
    }

    /**
     * Verifies Job Title label visibility
     */
    public boolean isJobTitleVisible() {
        return isElementDisplayed(jobTitle);
    }

    /**
     * Verifies Sub Unit label visibility
     */
    public boolean isSubUnitVisible() {
        return isElementDisplayed(subUnit);
    }

    /**
     * Verifies record found title visibility
     */
    public boolean isRecordFoundTitleVisible() {
        return isElementDisplayed(recordFoundTitle);
    }

    /**
     * Verifies record found by employee ID visibility
     */
    public boolean isRecordFoundByIDVisible() {
        return isElementDisplayed(recordFoundByID);
    }

    /**
     * Verifies record found by first and last name visibility
     */
    public boolean isRecordFoundByFirstLastNameVisible() {
        return waitForElementVisible(recordFoundByFirstLastName, 10).isDisplayed();
    }

    /**
     * Verifies updated record found by first and last name visibility
     */
    public boolean isUpdatedRecordFoundByFirstLastNameVisible() {
        return waitForElementVisible(updatedRecordFoundByFirstLastName, 10).isDisplayed();
    }

    /**
     * Verifies delete confirmation popup visibility
     */
    public boolean isPopoutConfirmationDltMsgVisible() {
        return waitForElementVisible(popoutConfirmationDltMsg, 10).isDisplayed();
    }

    /**
     * Verifies successfully deleted message visibility
     */
    public boolean isSuccessfullyDeletedMsgVisible() {
        return waitForElementVisible(successfullyDeletedMsg, 10).isDisplayed();
    }

    /**
     * Checks if updated record exists by first and last name
     */
    public boolean isUpdatedRecordFoundByFirstLastNameExist() {
        return isElementDisplayed(updatedRecordFoundByFirstLastName);
    }

    /**
     * Checks if record exists by employee ID
     */
    public boolean isRecordFoundByIDExist() {
        return isElementDisplayed(recordFoundByID);
    }

    /**
     * Inputs employee name
     *
     * @param empname employee name
     */
    public void inputEmployeeName(String empname) {
        waitForElementVisible(inputEmployeeName, 5);
        if (!isElementDisplayed(inputEmployeeName)) {
            System.out.println("Employee name input not visible!");
            return;
        }
        click(inputEmployeeName);
        type(inputEmployeeName, empname);
    }

    /**
     * Inputs employee ID
     *
     * @param empID employee ID
     */
    public void inputEmployeeID(String empID) {
        waitForElementVisible(inputEmployeeID, 5);
        if (!isElementDisplayed(inputEmployeeID)) {
            System.out.println("Employee ID input not visible!");
            return;
        }
        click(inputEmployeeID);
        type(inputEmployeeID, empID);
    }

    /**
     * Inputs supervisor name
     *
     * @param supname supervisor name
     */
    public void inputSupervisorName(String supname) {
        waitForElementVisible(inputSupervisorName, 5);
        if (!isElementDisplayed(inputSupervisorName)) {
            System.out.println("Supervisor name input not visible!");
            return;
        }
        click(inputSupervisorName);
        type(inputSupervisorName, supname);
    }

    /**
     * Clicks Add button
     */
    public void clickAddBtn() {
        waitForElementVisible(addBtn, 5);
        if (!isElementDisplayed(addBtn)) {
            System.out.println("Add button not visible!");
            return;
        }
        click(addBtn);
    }

    /**
     * Clicks Search button
     */
    public void clickSearchBtn() {
        waitForElementVisible(searchBtn, 5);
        if (!isElementDisplayed(searchBtn)) {
            System.out.println("Search button not visible!");
            return;
        }
        click(searchBtn);
    }

    /**
     * Clicks Reset button
     */
    public void clickResetBtn() {
        waitForElementVisible(resetBtn, 5);
        if (!isElementDisplayed(resetBtn)) {
            System.out.println("Reset button not visible!");
            return;
        }
        click(resetBtn);
    }

    /**
     * Selects employment status from dropdown
     *
     * @param optionText option value
     */
    public void selectEmploymentStatus(String optionText) {
        waitForElementVisible(inputEmploymentStatus, 5);
        if (!isElementDisplayed(inputEmploymentStatus)) {
            System.out.println("Employment status input not visible!");
            return;
        }
        click(inputEmploymentStatus);
        click(employmentStatusOption(optionText));
    }

    /**
     * Selects include option from dropdown
     *
     * @param optionText option value
     */
    public void selectInclude(String optionText) {
        waitForElementVisible(inputInclude, 5);
        if (!isElementDisplayed(inputInclude)) {
            System.out.println("Include input not visible!");
            return;
        }
        click(inputInclude);
        click(includeOption(optionText));
    }

    /**
     * Selects job title from dropdown
     *
     * @param optionText option value
     */
    public void selectJobTitle(String optionText) {
        waitForElementVisible(inputJobTitle, 5);
        if (!isElementDisplayed(inputJobTitle)) {
            System.out.println("Job title input not visible!");
            return;
        }
        click(inputJobTitle);
        click(jobTitleOption(optionText));
    }

    /**
     * Selects sub unit from dropdown
     *
     * @param optionText option value
     */
    public void selectSubUnit(String optionText) {
        waitForElementVisible(inputSubUnit, 5);
        if (!isElementDisplayed(inputSubUnit)) {
            System.out.println("Sub unit input not visible!");
            return;
        }
        click(inputSubUnit);
        click(subUnitOption(optionText));
    }

    /**
     * Clicks Edit button for selected employee
     */
    public void clickEditBtn() {
        waitForElementVisible(editBtn, 5);
        if (!isElementDisplayed(editBtn)) {
            System.out.println("Edit button not visible!");
            return;
        }
        click(editBtn);
    }

    /**
     * Clicks Delete button for selected employee
     */
    public void clickDeleteBtn() {
        waitForElementVisible(deleteBtn, 5);
        if (!isElementDisplayed(deleteBtn)) {
            System.out.println("Delete button not visible!");
            return;
        }
        click(deleteBtn);
    }

    /**
     * Confirms delete action
     */
    public void confirmDeleteBtn() {
        waitForElementVisible(confirmDltBtn, 5);
        if (!isElementDisplayed(confirmDltBtn)) {
            System.out.println("Confirm delete button not visible!");
            return;
        }
        click(confirmDltBtn);
    }

    /**
     * Cancels delete action
     */
    public void cancelDeleteBtn() {
        waitForElementVisible(cancelDltBtn, 5);
        if (!isElementDisplayed(cancelDltBtn)) {
            System.out.println("Cancel delete button not visible!");
            return;
        }
        click(cancelDltBtn);
    }
}
