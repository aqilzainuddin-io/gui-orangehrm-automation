package com.orangehrm.pages.pim;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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

    private By recordFoundTitle = By.xpath("//span[contains(normalize-space(),'Record Found')]");
    private By recordFoundByID = By.xpath("//div[text()='8989']");
    private By recordFoundByFirstLastName = By.xpath("//div[contains(@class, 'oxd-table-row') and .//div[normalize-space(text())='John52'] and .//div[normalize-space(text())='Doe']]");
    

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
        if(!isElementDisplayed(addBtn)){
            System.out.println("Add button not visible!");
            return;
        }
        click(addBtn);
        System.out.println("Add button clicked");
    }
    public void clickSearchBtn(){
        if(!isElementDisplayed(searchBtn)){
            System.out.println("Search button not visible!");
            return;
        }
        click(searchBtn);
        System.out.println("Search button clicked");
    }
    public void clickResetBtn(){
        if(!isElementDisplayed(resetBtn)){
            System.out.println("Reset button not visible!");
            return;
        }
        click(resetBtn);
        System.out.println("Reset button clicked");
    }

    //------------Dynamic Method (Input)------------//
    public void selectEmploymentStatus(String optionText) {
        if (!isElementDisplayed(inputEmploymentStatus)) {
            System.out.println("Employment status input not visible!");
            return;
        }
        click(inputEmploymentStatus);
        System.out.println("Employment status input clicked");
        click(employmentStatusOption(optionText));
    }
    public void selectInclude(String optionText){
        if(!isElementDisplayed(inputInclude)){
            System.out.println("Include input not visible!");
            return;
        }
        click(inputInclude);
        System.out.println("Include input clicked");
        click(includeOption(optionText));
    }
    public void selectJobTitle(String optionText){
        if(!isElementDisplayed(inputJobTitle)){
            System.out.println("Job title input not visible!");
            return;
        }
        click(inputJobTitle);
        System.out.println("Job title input clicked");
        click(jobTitleOption(optionText));
    }
    public void selectSubUnit(String optionText){
        if(!isElementDisplayed(inputSubUnit)){
            System.out.println("Sub unit input not visisble!");
            return;
        }
        click(inputSubUnit);
        System.out.println("Sub unit input clicked");
        click(subUnitOption(optionText));
    }
}