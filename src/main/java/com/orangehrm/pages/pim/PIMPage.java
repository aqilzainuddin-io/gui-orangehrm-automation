package com.orangehrm.pages.pim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orangehrm.pages.BasePage;

public class PIMPage extends BasePage {
    
    // constructor
    public PIMPage(WebDriver driver) {
        super(driver);
    }

    //locators
    private By pimHeader = By.xpath("//h6[text()='PIM']");
    
    private By employeeInformation = By.xpath("//h5[contains(normalize-space(),'Employee Info')]");
    private By employeeName = By.xpath("//label[contains(normalize-space(),'Employee Name')]");
    private By inputEmployeeName = By.xpath("//label[contains(normalize-space(),'Employee Name')]/../following-sibling::div//input");

    private By employeeID = By.xpath("//label[contains(normalize-space(),'Employee Id')]");
    private By inputEmployeeID = By.xpath("//label[contains(normalize-space(),'Employee Id')]/../following-sibling::div//input");
    
    private By employmentStatus = By.xpath("//label[contains(normalize-space(),'Employment Status')]");
    private By inputEmploymentStatus = By.xpath("//label[contains(normalize-space(),'Employment Status')]/../following-sibling::div");
    private By employmentStatusOption(String employmentStatusOption){
        return By.xpath("//div//span[contains(normalize-space(),'"+employmentStatusOption+"')]");
    }

    private By include = By.xpath("//label[contains(normalize-space(),'Include')]");
    private By inputInclude = By.xpath("//label[contains(normalize-space(),'Include')]/../following-sibling::div");
    private By includeOption(String includeOption){
        return By.xpath("//div//span[text()='"+includeOption+"']");
    }

    private By supervisorName = By.xpath("//label[contains(normalize-space(),'Supervisor Name')]");
    private By inputSupervisorName = By.xpath("//label[contains(normalize-space(),'Supervisor Name')]/../following-sibling::div//input");

    private By jobTitle = By.xpath("//label[contains(normalize-space(),'Job Title')]");
    private By inputJobTitle = By.xpath("//label[contains(normalize-space(),'Job Title')]/../following-sibling::div");
    private By jobTitleOption(String jobTitleOption){
        return By.xpath("//div//span[contains(text(),'"+jobTitleOption+"')]");
    }

    private By subUnit = By.xpath("//label[contains(normalize-space(),'Sub Unit')]");
    private By inputSubUnit = By.xpath("//label[contains(normalize-space(),'Sub Unit')]/../following-sibling::div");
    private By subUnitOption(String subUnitOption){
        return By.xpath("//div//span[contains(text(),'"+subUnitOption+"')]");
    }

    private By searchBtn = By.xpath("//button[normalize-space()='Search']");
    private By resetBtn = By.xpath("//button[normalize-space()='Reset']");
    private By addBtn = By.xpath("//button[normalize-space()='Add']");
    private By editBtn = By.xpath("//div[contains(@class,'card-header-slot-content')]//i[contains(@class,'bi-pencil-fill')]");
    private By deleteBtn = By.xpath("//div[contains(@class,'card-header-slot-content')]//i[contains(@class,'bi-trash')]");

    private By recordFoundTitle = By.xpath("//span[contains(normalize-space(),'Record Found')]");
    private By recordFoundByID = By.xpath("//div[text()='8989']");
    private By recordFoundByFirstLastName = By.xpath("//div[contains(@class, 'oxd-table-row') and .//div[normalize-space(text())='John52'] and .//div[normalize-space(text())='Doe']]");
    private By updatedRecordFoundByFirstLastName = By.xpath("//div[contains(@class, 'oxd-table-row') and .//div[normalize-space(text())='Robert'] and .//div[normalize-space(text())='Enstain']]");

    //-----------wait for element method-----------//
    private WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //------------Normal Method (Label)------------//
    public boolean isPIMHeaderDisplayed(){
        return isElementDisplayed(pimHeader);
    }
    public boolean isEmployeeInformationVisible(){
        return isElementDisplayed(employeeInformation);
    }
    public boolean isEmployeeNameVisisble(){
        return isElementDisplayed(employeeName);
    }
    public boolean isEmployeeIDVisible(){
        return isElementDisplayed(employeeID);
    }
    public boolean isEmploymentStatusVisible(){
        return isElementDisplayed(employmentStatus);
    }
    public boolean isIncludeVisible(){
        return isElementDisplayed(include);
    }
    public boolean isSupervisorNameVisible(){
        return isElementDisplayed(supervisorName);
    }
    public boolean isJobTitleVisible(){
        return isElementDisplayed(jobTitle);
    }
    public boolean isSubUnitVisible(){
        return isElementDisplayed(subUnit);
    }
    public boolean isRecordFoundTitleVisible(){
        return isElementDisplayed(recordFoundTitle);
    }
    public boolean isRecordFoundByIDVisible(){
        return isElementDisplayed(recordFoundByID);
    }
    public boolean isRecordFoundByFirstLastNameVisible(){
        return isElementDisplayed(recordFoundByFirstLastName);
    }
    

    //------------Normal Method (Input)------------//
    public void inputEmployeeName(String empname){
        waitForElementVisible(inputEmployeeName, 5); 
        if(!isElementDisplayed(inputEmployeeName)){
            System.out.println("Employee name input not visible!");
            return;
        }
        click(inputEmployeeName);
        System.out.println("Employee name input clicked");
        type(inputEmployeeName, empname);
        System.out.println("Employee name input filled");
    }

    public void inputEmployeeID(String empID){
        waitForElementVisible(inputEmployeeID, 5);
        if(!isElementDisplayed(inputEmployeeID)){
            System.out.println("Employee ID input not visible!");
            return;
        }
        click(inputEmployeeID);
        System.out.println("Employee ID input clicked");
        type(inputEmployeeID, empID);
        System.out.println("Employee ID input filled");
    }

    public void inputSupervisorName(String supname){
        waitForElementVisible(inputSupervisorName, 5);
        if(!isElementDisplayed(inputSupervisorName)){
            System.out.println("Supervisor name input not visible!");
            return;
        }
        click(inputSupervisorName);
        System.out.println("Supervisor name input clicked");
        type(inputSupervisorName, supname);
        System.out.println("Supervisor name input filled");
    }

    public void clickAddBtn(){
        waitForElementVisible(addBtn, 5); 
        if(!isElementDisplayed(addBtn)){
            System.out.println("Add button not visible!");
            return;
        }
        click(addBtn);
        System.out.println("Add button clicked");
    }

    public void clickSearchBtn(){
        waitForElementVisible(searchBtn, 5);
        if(!isElementDisplayed(searchBtn)){
            System.out.println("Search button not visible!");
            return;
        }
        click(searchBtn);
        System.out.println("Search button clicked");
    }

    public void clickResetBtn(){
        waitForElementVisible(resetBtn, 5);
        if(!isElementDisplayed(resetBtn)){
            System.out.println("Reset button not visible!");
            return;
        }
        click(resetBtn);
        System.out.println("Reset button clicked");
    }

    //------------Dynamic Method (Input)------------//
    public void selectEmploymentStatus(String optionText) {
        waitForElementVisible(inputEmploymentStatus, 5);
        if (!isElementDisplayed(inputEmploymentStatus)) {
            System.out.println("Employment status input not visible!");
            return;
        }
        click(inputEmploymentStatus);
        System.out.println("Employment status input clicked");
        click(employmentStatusOption(optionText));
    }

    public void selectInclude(String optionText){
        waitForElementVisible(inputInclude, 5);
        if(!isElementDisplayed(inputInclude)){
            System.out.println("Include input not visible!");
            return;
        }
        click(inputInclude);
        System.out.println("Include input clicked");
        click(includeOption(optionText));
    }

    public void selectJobTitle(String optionText){
        waitForElementVisible(inputJobTitle, 5);
        if(!isElementDisplayed(inputJobTitle)){
            System.out.println("Job title input not visible!");
            return;
        }
        click(inputJobTitle);
        System.out.println("Job title input clicked");
        click(jobTitleOption(optionText));
    }

    public void selectSubUnit(String optionText){
        waitForElementVisible(inputSubUnit, 5);
        if(!isElementDisplayed(inputSubUnit)){
            System.out.println("Sub unit input not visisble!");
            return;
        }
        click(inputSubUnit);
        System.out.println("Sub unit input clicked");
        click(subUnitOption(optionText));
    }

    public void clickEditBtn(){
        waitForElementVisible(editBtn, 5);
        if(!isElementDisplayed(editBtn)){
            System.out.println("Edit button not visible!");
            return;
        }
        click(editBtn);
        System.out.println("Edit button clicked");
    }

    public void clickDeleteBtn(){
        waitForElementVisible(deleteBtn, 5);
        if(!isElementDisplayed(deleteBtn)){
            System.out.println("Delete button not visible!");
            return;
        }
        click(deleteBtn);
        System.out.println("Delete button clicked");
    }
}