package com.orangehrm.tests.Login;

import com.orangehrm.setup.BaseTest;
import com.orangehrm.pages.dashboard.DashboardPage;
import com.orangehrm.pages.login.LoginPage;
import com.orangehrm.setup.EnvReader;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

/**
 * LoginTest
 *
 * Test class for validating OrangeHRM login functionality.
 * Extends BaseTest to utilize WebDriver setup and teardown.
 * Covers scenarios including empty fields, invalid credentials, and valid login.
 */
public class LoginTest extends BaseTest {

    // Page object for login page
    private LoginPage loginPage;

    /**
     * Initialize page object before each test method
     */
    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    /**
     * Test login with empty username and password
     * Verifies that the "Required" error messages are displayed
     */
    @Test
    public void emptyUsernamePasswordLogin() {
        System.out.println("Login Test Begins");
        loginPage.login(EnvReader.get(""), EnvReader.get(""));
        Assert.assertTrue(loginPage.isUsernameReqErrMsgVisible(), "Username required error not displayed!");
        Assert.assertTrue(loginPage.isPasswordReqErrMsgVisible(), "Password required error not displayed!");
    }

    /**
     * Test login with empty password only
     * Verifies that password required error is displayed
     */
    @Test 
    public void emptyPasswordLogin() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get(""));
        Assert.assertTrue(loginPage.isPasswordReqErrMsgVisible(), "Password required error not displayed!");
    }

    /**
     * Test login with empty username only
     * Verifies that username required error is displayed
     */
    @Test
    public void emptyUsernameLogin() {
        loginPage.login(EnvReader.get(""), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(loginPage.isUsernameReqErrMsgVisible(), "Username required error not displayed!");
    }

    /**
     * Test login with invalid username and password
     * Verifies that "Invalid credentials" error is displayed
     */
    @Test
    public void invalidLogin() {
        loginPage.login(EnvReader.get("INVALID_USERNAME"), EnvReader.get("INVALID_PASSWORD"));
        Assert.assertTrue(loginPage.isInvalidCredErrMsgVisible(), "Invalid credentials error not displayed!");
    }

    /**
     * Test login with invalid username and valid password
     * Verifies that "Invalid credentials" error is displayed
     */
    @Test
    public void invalidUsernameLogin() {
        loginPage.login(EnvReader.get("INVALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(loginPage.isInvalidCredErrMsgVisible(), "Invalid credentials error not displayed!");
    }

    /**
     * Test login with valid username and invalid password
     * Verifies that "Invalid credentials" error is displayed
     */
    @Test
    public void invalidPasswordLogin() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("INVALID_PASSWORD"));
        Assert.assertTrue(loginPage.isInvalidCredErrMsgVisible(), "Invalid credentials error not displayed!");
    }

    /**
     * Test login with valid credentials
     * Verifies that the Dashboard is visible after login
     */
    @Test
    public void validLogin() {
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard not visible after valid login!");
        System.out.println("Login Test Ends");
    }
}
