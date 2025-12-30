package com.orangehrm.pages.pim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.pages.BasePage;

/**
 * Page Object Model for Edit Employee Page (PIM)
 * Contains locators and actions related to editing employee personal details
 */
public class EditEmpPage extends BasePage {

    /**
     * Constructor for EditEmpPage
     *
     * @param driver WebDriver instance
     */
    public EditEmpPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Locators for Edit Employee page elements
     */
    private By personalDetailsHeader = By.xpath("//h6[normalize-space()='Personal Details']");
    private By empFullNameTitle = By.xpath("//label[contains(text(),'Employee Full Name')]");
    private By inputEmpFirstName = By.xpath("//input[contains(@class,'orangehrm-firstname')]");
    private By inputEmpLastName = By.xpath("//input[contains(@class,'orangehrm-lastname')]");
    private By saveBtn = By.xpath("//p[contains(@class,'oxd-text--p')]/following-sibling::button[contains(@type,'submit')]");
    private By successfullySavedMsg = By.xpath("//div/p[contains(normalize-space(),'Successfully Updated')]");

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
     * Verifies Personal Details header visibility
     */
    public boolean isPersonalDetailsHeaderDisplayed() {
        return waitForElementVisible(personalDetailsHeader, 10).isDisplayed();
    }

    /**
     * Verifies Employee Full Name title visibility
     */
    public boolean isEmpFullNameTitleDisplayed() {
        return waitForElementVisible(empFullNameTitle, 10).isDisplayed();
    }

    /**
     * Clicks Save button on Edit Employee page
     */
    public void clickSaveBtn() {
        waitForElementVisible(saveBtn, 10).click();
    }

    /**
     * Verifies successfully updated message visibility
     */
    public boolean isSuccessfullySavedMsgVisible() {
        return waitForElementVisible(successfullySavedMsg, 30).isDisplayed();
    }

    /**
     * Updates employee first name
     *
     * @param inputfirstname new first name value
     */
    public void updateEmpFirstName(String inputfirstname) {
        waitForElementVisible(inputEmpFirstName, 5);

        if (!isElementDisplayed(inputEmpFirstName)) {
            System.out.println("Employee First Name input not visible!");
            return;
        }
        click(inputEmpFirstName);
        type(inputEmpFirstName, inputfirstname);
    }

    /**
     * Updates employee last name
     *
     * @param inputlastname new last name value
     */
    public void updateEmpLastName(String inputlastname) {
        waitForElementVisible(inputEmpLastName, 5);

        if (!isElementDisplayed(inputEmpLastName)) {
            System.out.println("Employee Last Name input not visible!");
            return;
        }
        click(inputEmpLastName);
        type(inputEmpLastName, inputlastname);
    }
}
