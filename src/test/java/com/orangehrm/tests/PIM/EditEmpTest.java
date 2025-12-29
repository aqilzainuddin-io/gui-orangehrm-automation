package com.orangehrm.tests.PIM;

import com.orangehrm.setup.EnvReader;
import com.orangehrm.setup.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.pages.dashboard.DashboardPage;
import com.orangehrm.pages.login.LoginPage;
import com.orangehrm.pages.pim.PIMPage;
import com.orangehrm.pages.pim.EditEmpPage;

public class EditEmpTest extends BaseTest  {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;
    private EditEmpPage editEmpPage;

    @BeforeMethod
    public void initPages(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
        editEmpPage = new EditEmpPage(driver);
    }

    @Test
    public void searchByUpdatedEmployeeNameAndID() throws InterruptedException{
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(),"Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(),"PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(),"PIM header not displayed!");
        pimPage.inputEmployeeName("John52 Doe");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();
        Assert.assertTrue(pimPage.isRecordFoundByFirstLastNameVisible(),"Registered first name and last name not displayed!");
        Assert.assertTrue(pimPage.isRecordFoundByIDVisible(),"Registered ID not displayed!");
        

        pimPage.clickEditBtn();
        Assert.assertTrue(editEmpPage.isPersonalDetailsHeaderDisplayed(),"Edit Employee header not displayed!");
        Assert.assertTrue(editEmpPage.isEmpFullNameTitleDisplayed());
        editEmpPage.updateEmpFirstName("FinnTeo");
        editEmpPage.updateEmpLastName("Enstain");
        editEmpPage.clickSaveBtn();
        Assert.assertTrue(editEmpPage.isSuccessfullySavedMsgVisible(),"Successfully saved message not displayed!");
        
        dashboardPage.clickPIMPage();
        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(),"PIM header not displayed!");
        pimPage.inputEmployeeName("FinnTeo Enstain");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();
        Assert.assertTrue(pimPage.isUpdatedRecordFoundByFirstLastNameVisible(),"Registered first name and last name not displayed!");
        Assert.assertTrue(pimPage.isRecordFoundByIDVisible(),"Registered ID not displayed!");
    }
}
