package tests.Login;

import setup.BaseTest;
import pages.dashboard.DashboardPage;
import pages.login.LoginPage;
import setup.EnvReader;
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
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        DashboardPage dashboardPage = new DashboardPage(driver);
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(), "Dashboard not visible after valid login!");
    }
}
