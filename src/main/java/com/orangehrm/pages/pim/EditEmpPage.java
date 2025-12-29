package com.orangehrm.pages.pim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.pages.BasePage;

public class EditEmpPage extends BasePage {
    // constructor
    public EditEmpPage(WebDriver driver) {
        super(driver);
    }

    //locators
    private By personalDetailsHeader = By.xpath("//h6[normalize-space()='Personal Details']");
    private By empFullNameTitle = By.xpath("//label[contains(text(),'Employee Full Name')]");
    private By inputEmpFirstName = By.xpath("//input[contains(@class,'orangehrm-firstname')]");
    private By inputEmpLastName = By.xpath("//input[contains(@class,'orangehrm-lastname')]");
    private By saveBtn = By.xpath("//p[contains(@class,'oxd-text--p')]/following-sibling::button[contains(@type,'submit')]");
    private By successfullySavedMsg = By.xpath("//div/p[contains(normalize-space(),'Successfully Updated')]");

    //-----------wait for element method-----------//
    private WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //methods
    public boolean isPersonalDetailsHeaderDisplayed() {
        return waitForElementVisible(personalDetailsHeader, 10).isDisplayed();
    }
    public boolean isEmpFullNameTitleDisplayed() {
        return waitForElementVisible(empFullNameTitle, 10).isDisplayed();
    }
    public void clickSaveBtn() {
        waitForElementVisible(saveBtn, 10).click();
    }
    public boolean isSuccessfullySavedMsgVisible(){
        return waitForElementVisible(successfullySavedMsg, 30).isDisplayed();
    }
    
    public void updateEmpFirstName(String inputfirstname){
        waitForElementVisible(inputEmpFirstName, 5);
        if(!isElementDisplayed(inputEmpFirstName)){
            System.out.println("Employee First Name input not visible!");
            return;
        }
        click(inputEmpFirstName);
        System.out.println("Employee first name input clicked");
        type(inputEmpFirstName, inputfirstname);
        System.out.println("Employee first name input filled");
    }
    public void updateEmpLastName(String inputlastname){
        waitForElementVisible(inputEmpLastName, 5);
        if(!isElementDisplayed(inputEmpLastName)){
            System.out.println("Employee Last Name input not visible!");
            return;
        }
        click(inputEmpLastName);
        System.out.println("Employee last name input clicked");
        type(inputEmpLastName, inputlastname);
        System.out.println("Employee last name input filled");
    }
}
