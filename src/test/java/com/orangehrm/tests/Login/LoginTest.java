package com.orangehrm.tests.Login;

import com.orangehrm.setup.BaseTest;
import com.orangehrm.pages.dashboard.DashboardPage;
import com.orangehrm.pages.login.LoginPage;
import com.orangehrm.setup.EnvReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;


public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void initPage() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void emptyUsernamePasswordLogin(){
        System.out.println("Login Test Begins");
        loginPage.login(EnvReader.get(""),EnvReader.get(""));
        Assert.assertTrue(loginPage.isUsernameReqErrMsgVisible(),"Error message not displayed!");
        Assert.assertTrue(loginPage.isPasswordReqErrMsgVisible(),"Error message not displayed!");
    }

    @Test 
    public void emptyPasswordLogin(){
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get(""));
        Assert.assertTrue(loginPage.isPasswordReqErrMsgVisible(),"Error message not displayed!");
    }

    @Test
    public void emptyUsernameLogin(){
        loginPage.login(EnvReader.get(""), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(loginPage.isUsernameReqErrMsgVisible(),"Error message not displayed!");
    }

    @Test
    public void invalidLogin() {
        loginPage.login(EnvReader.get("INVALID_USERNAME"), EnvReader.get("INVALID_PASSWORD"));
        Assert.assertTrue(loginPage.isInvalidCredErrMsgVisible(), "Error message not displayed!");
    }

    @Test
    public void invalidUsernameLogin(){
        loginPage.login(EnvReader.get("INVALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(loginPage.isInvalidCredErrMsgVisible(), "Error message not displayed!");
    }

    @Test
    public void invalidPasswordLogin(){
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("INVALID_PASSWORD"));
        Assert.assertTrue(loginPage.isInvalidCredErrMsgVisible(), "Error message not displayed!");
    }

    @Test
    public void validLogin() {
        System.out.println("Login Test Ends");
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard not visible after valid login!");
    }
}
