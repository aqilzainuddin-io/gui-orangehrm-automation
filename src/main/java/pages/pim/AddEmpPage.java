package pages.pim;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class AddEmpPage extends BasePage {
    
    // constructor
    public AddEmpPage(WebDriver driver) {
        super(driver);
    }

    //locators-label
    private By header = By.xpath("//h6[contains(normalize-space(),'PIM')]");
    private By pageTitle = By.xpath("//h6[contains(normalize-space(),'Add Employee')]");
    private By empFullName = By.xpath("//label[contains(normalize-space(),'Employee Full Name')]");
    private By empID = By.xpath("//label[contains(normalize-space(),'Employee Id')]");
    private By createLoginDetails = By.xpath("//p[contains(normalize-space(),'Create Login Details')]");
    private By username = By.xpath("//label[contains(normalize-space(),'Username')]");
    private By status = By.xpath("//label[contains(normalize-space(),'Status')]");
    private By password = By.xpath("//label[normalize-space(text())='Password']");
    private By confirmPassword = By.xpath("//label[normalize-space(text())='Confirm Password']");

    //locators-input
    private By empFirstName = By.xpath("//input[@name='firstName']");
    private By empLastName = By.xpath("//input[@name='lastName']");
    private By inputEmpID = By.xpath("//label[contains(normalize-space(),'Employee Id')]/../following-sibling::div//input");
    private By inputCreateLoginDetails = By.xpath("//p[contains(normalize-space(),'Create Login Details')]/following::span");
    private By inputUsername = By.xpath("//label[contains(normalize-space(),'Username')]/../following-sibling::div/input");
    private By statusEnabled = By.xpath("//label[contains(normalize-space(),'Enabled')]/input");
    private By statusDisabled = By.xpath("//label[contains(normalize-space(),'Disabled')]/input");
    private By inputPassword = By.xpath("//label[normalize-space(text())='Password']/../following-sibling::div/input");
    private By inputConfirmPassword = By.xpath("//label[normalize-space(text())='Confirm Password']/../following-sibling::div/input");
    
    //locators-button
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");
    private By cancelBtn = By.xpath("//button[normalize-space()='Cancel']");

    //locators-message
    private By successfullySavedMsg = By.xpath("//div/p[contains(normalize-space(),'Successfully Saved')]");

    //-----------wait for element method-----------//
    private WebElement waitForElementVisible(By locator, int timeoutInSeconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //------------Getter Method (Label)------------//
    public boolean isHeaderDisplayed(){
        return waitForElementVisible(header, 10).isDisplayed();
    }
    public boolean isPageTitleVisible(){
        return waitForElementVisible(pageTitle, 10).isDisplayed();
    }
    public boolean isEmpFullNameVisible(){
        return waitForElementVisible(empFullName, 10).isDisplayed();
    }
    public boolean isEmpIDVisible(){
        return waitForElementVisible(empID, 10).isDisplayed();
    }
    public boolean isCreateLoginDetailsVisible(){
        return waitForElementVisible(createLoginDetails, 10).isDisplayed();
    }
    public boolean isUsernameVisible(){
        return waitForElementVisible(username, 10).isDisplayed();
    }
    public boolean isStatusVisible(){
        return waitForElementVisible(status, 10).isDisplayed();
    }
    public boolean isPasswordVisible(){
        return waitForElementVisible(password, 10).isDisplayed();
    }
    public boolean isConfirmPasswordVisible(){
        return waitForElementVisible(confirmPassword, 10).isDisplayed();
    }
    public boolean isSuccessfullySavedMsgVisible(){
        return waitForElementVisible(successfullySavedMsg, 30).isDisplayed();
    }

    //------------Action Method (Input)------------//
    public void inputEmpFirstName(String empfirstname){
        if(!isElementDisplayed(empFirstName)){
            System.out.println("Employee First Name input not visible!");
            return;
        }
        click(empFirstName);
        System.out.println("Employee first name input clicked");
        type(empFirstName, empfirstname);
        System.out.println("Employee first name input filled");
    }
    public void inputEmpLastName(String emplastname){
        if(!isElementDisplayed(empLastName)){
            System.out.println("Employee last name input not visible!");
            return;
        }
        click(empLastName);
        System.out.println("Employee last name input clicked");
        type(empLastName, emplastname);
        System.out.println("Employee last name input filled");
    }
    public void inputEmpID(String empID){
        if(!isElementDisplayed(inputEmpID)){
            System.out.println("Employee ID input not visible!");
            return;
        }
        click(inputEmpID);
        System.out.println("Employee ID input clicked");
        type(inputEmpID, empID);
        System.out.println("Employee ID input filled");
    }
    public void inputUsername(String username){
        if(!isElementDisplayed(inputUsername)){
            System.out.println("Username input not visible!");
            return;
        }
        click(inputUsername);
        System.out.println("Username input clicked");
        type(inputUsername, username);
        System.out.println("Username input filled");
    }
    public void clickStatusEnable(){
        if(!isElementDisplayed(statusEnabled)){
            System.out.println("Status enable not visible!");
            return;
        }
        click(statusEnabled);
        System.out.println("Status enable clicked");
    }
    public void clickStatusDisable(){
        if(!isElementDisplayed(statusDisabled)){
            System.out.println("Status disable not visible!");
            return;
        }
        click(statusDisabled);
        System.out.println("Status disable clicked");
    }
    public void inputPassword(String pass){
        if(!isElementDisplayed(inputPassword)){
            System.out.println("Password input not visable!");
            return;
        }
        click(inputPassword);
        System.out.println("Password input clicked");
        type(inputPassword, pass);
        System.out.println("Password input filled");
    }
    public void inputConfirmPassword(String confirmpass){
        if(!isElementDisplayed(inputConfirmPassword)){
            System.out.println("Confirm password input not visable!");
            return;
        }
        click(inputConfirmPassword);
        System.out.println("Confirm password input clicked");
        type(inputConfirmPassword, confirmpass);
        System.out.println("Confirm password input filled");
    }
    public void clickSaveBtn(){
        if(!isElementDisplayed(saveBtn)){
            System.out.println("Save button not visible!");
            return;
        }
        click(saveBtn);
        System.out.println("Save button clicked");
    }
    public void clickCancelBtn(){
        if(!isElementDisplayed(cancelBtn)){
            System.out.println("Cancel button not visible!");
            return;
        }
        click(cancelBtn);
        System.out.println("Cancel button clicked");
    }
    public void clickCreateLoginDetails(){
        if(!isElementDisplayed(inputCreateLoginDetails)){
            System.out.println("Create login details toggle not visible!");
            return;
        }
        click(inputCreateLoginDetails);
        System.out.println("Create login details toggle clicked");
    }
}