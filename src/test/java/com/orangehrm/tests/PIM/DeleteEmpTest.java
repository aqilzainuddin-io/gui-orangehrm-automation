package com.orangehrm.tests.PIM;

import com.orangehrm.setup.EnvReader;
import com.orangehrm.setup.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.pages.dashboard.DashboardPage;
import com.orangehrm.pages.login.LoginPage;
import com.orangehrm.pages.pim.PIMPage;

public class DeleteEmpTest extends BaseTest  {
    
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;

    @BeforeMethod
    public void initPages(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
    }

    //edit delete employee test case
    @Test
    public void deleteEmployeeTest() throws InterruptedException{
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(),"Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(),"PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(),"PIM header not displayed!");
        pimPage.inputEmployeeName("FinnTeo Enstain");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();
        Assert.assertTrue(pimPage.isUpdatedRecordFoundByFirstLastNameVisible(),"Registered first name and last name not displayed!");
        Assert.assertTrue(pimPage.isRecordFoundByIDVisible(),"Registered ID not displayed!");

        pimPage.clickDeleteBtn();
        Assert.assertTrue(pimPage.isPopoutConfirmationDltMsgVisible(),"Popout confirmation delete message not displayed!");
        pimPage.confirmDeleteBtn();
        Assert.assertTrue(pimPage.isSuccessfullyDeletedMsgVisible(),"Successfully deleted message not displayed!");

        pimPage.inputEmployeeName("FinnTeo Enstain");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();
        Assert.assertFalse(pimPage.isUpdatedRecordFoundByFirstLastNameExist(),"Registered first name and last name displayed!");
        Assert.assertFalse(pimPage.isRecordFoundByIDExist(),"Registered ID displayed!");
    }
}
