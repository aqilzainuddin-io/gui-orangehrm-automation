package com.orangehrm.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.orangehrm.pages.BasePage;

/**
 * Page Object Model for Login Page
 * Contains locators and actions related to user authentication
 */
public class LoginPage extends BasePage {

    /**
     * Locators for Login Page elements
     */
    private By usernameField = By.xpath("//label[text()='Username']/../following-sibling::div/input");
    private By passwordField = By.xpath("//label[text()='Password']/../following-sibling::div/input");
    private By loginButton = By.xpath("//button[contains(normalize-space(),'Login')]");
    private By invalidCredMsg = By.xpath("//p[contains(normalize-space(),'Invalid credentials')]");
    private By usernameRequiredMsg = By.xpath("//label[text()='Username']/../following-sibling::span[text()='Required']");
    private By passwordRequiredMsg = By.xpath("//label[text()='Password']/../following-sibling::span[text()='Required']");

    /**
     * Constructor for LoginPage
     *
     * @param driver WebDriver instance
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Verifies invalid credentials error message visibility
     *
     * @return true if error message is displayed
     */
    public boolean isInvalidCredErrMsgVisible() {
        return isElementDisplayed(invalidCredMsg);
    }

    /**
     * Returns invalid credentials error message text
     *
     * @return error message text
     */
    public String getInvalidCredErrMsg() {
        return getText(invalidCredMsg);
    }

    /**
     * Verifies username required error message visibility
     *
     * @return true if username required message is displayed
     */
    public boolean isUsernameReqErrMsgVisible() {
        return isElementDisplayed(usernameRequiredMsg);
    }

    /**
     * Verifies password required error message visibility
     *
     * @return true if password required message is displayed
     */
    public boolean isPasswordReqErrMsgVisible() {
        return isElementDisplayed(passwordRequiredMsg);
    }

    /**
     * Returns username required error message text
     *
     * @return username required message text
     */
    public String getUsernameReqMsg() {
        return getText(usernameRequiredMsg);
    }

    /**
     * Returns password required error message text
     *
     * @return password required message text
     */
    public String getPasswordReqMsg() {
        return getText(passwordRequiredMsg);
    }

    /**
     * Performs login action using provided credentials
     *
     * @param username application username
     * @param password application password
     */
    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }
}