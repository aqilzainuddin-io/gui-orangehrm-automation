package com.orangehrm.tests.PIM;

import com.orangehrm.setup.EnvReader;
import com.orangehrm.setup.BaseTest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangehrm.pages.dashboard.DashboardPage;
import com.orangehrm.pages.login.LoginPage;
import com.orangehrm.pages.pim.PIMPage;

public class PIMTest extends BaseTest  {
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private PIMPage pimPage;

    @BeforeMethod
    public void initPages(){
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        pimPage = new PIMPage(driver);
    }

    @Test
    public void searchEmployeeByID() throws InterruptedException{
        System.out.println("PIM Test Begins");
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(),"Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(),"PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(),"PIM header not displayed!");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();
        Assert.assertTrue(pimPage.isRecordFoundByIDVisible(),"Registered ID not displayed!");
        System.out.println("PIM Test Ends");
    }
    
    @Test
    public void searchByEmployeeName() throws InterruptedException{
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(),"Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(),"PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(),"PIM header not displayed!");
        pimPage.inputEmployeeName("John52 Doe");
        pimPage.clickSearchBtn();
        Assert.assertTrue(pimPage.isRecordFoundByFirstLastNameVisible(),"Registered first name and last name not displayed!");
    }

    @Test
    public void searchByEmployeeNameAndID() throws InterruptedException{
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
    }

    @Test
    public void searchByUpdatedEmployeeNameAndID() throws InterruptedException{
        loginPage.login(EnvReader.get("VALID_USERNAME"), EnvReader.get("VALID_PASSWORD"));
        Assert.assertTrue(dashboardPage.isDashboardHeaderDisplayed(),"Dashboard header not displayed!");
        Assert.assertTrue(dashboardPage.isPIMPageVisible(),"PIM navigator link not displayed!");
        dashboardPage.clickPIMPage();

        Assert.assertTrue(pimPage.isPIMHeaderDisplayed(),"PIM header not displayed!");
        pimPage.inputEmployeeName("Robert Enstain");
        pimPage.inputEmployeeID("8989");
        pimPage.clickSearchBtn();
        Assert.assertTrue(pimPage.isRecordFoundByFirstLastNameVisible(),"Registered first name and last name not displayed!");
        Assert.assertTrue(pimPage.isRecordFoundByIDVisible(),"Registered ID not displayed!");
    }
}

