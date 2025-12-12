package tests.PIM;

import setup.BaseTest;
import setup.EnvReader;
import pages.dashboard.DashboardPage;
import pages.login.LoginPage;
import pages.pim.AddEmpPage;
import pages.pim.PIMPage;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddEmpTest extends BaseTest {
    
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;
    private AddEmpPage addEmpPage;

    @BeforeMethod
    public void initPages(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
        addEmpPage = new AddEmpPage(driver);
    }

    @Test
    public void addEmployee() throws InterruptedException{

        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(),"Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(),"PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(),"PIM header not displayed!");
        pimPage.clickAddBtn();

        Assert.assertTrue(addEmpPage.isHeaderDisplayed(),"PIM header not displayed!");
        Assert.assertTrue(addEmpPage.isPageTitleVisible(),"Add employee title not displayed!");
        Assert.assertTrue(addEmpPage.isEmpFullNameVisible(),"Employee full name not displayed!");
        Assert.assertTrue(addEmpPage.isEmpIDVisible(),"Employee id not displayed!");
        Assert.assertTrue(addEmpPage.isCreateLoginDetailsVisible(),"Create login details not displayed!");
        addEmpPage.clickCreateLoginDetails();
        Assert.assertTrue(addEmpPage.isUsernameVisible(),"Username not displayed!");
        Assert.assertTrue(addEmpPage.isStatusVisible(),"Status not displayed!");
        Assert.assertTrue(addEmpPage.isPasswordVisible(),"Password not displayed!");
        Assert.assertTrue(addEmpPage.isConfirmPasswordVisible(),"Confirm password is not displayed!");

        addEmpPage.inputEmpFirstName("John52");
        addEmpPage.inputEmpLastName("Doe");
        addEmpPage.inputEmpID("8989");
        addEmpPage.inputUsername("JohnDoe52");
        addEmpPage.clickStatusEnable();
        addEmpPage.inputPassword("JDoe5245");
        addEmpPage.inputConfirmPassword("JDoe5245");
        addEmpPage.clickSaveBtn();

        Assert.assertTrue(addEmpPage.isSuccessfullySavedMsgVisible(),"Successfully saved message not displayed!");
    }
}
