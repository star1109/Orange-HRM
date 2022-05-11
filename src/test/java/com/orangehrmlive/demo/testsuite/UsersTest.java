package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.AddUserPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.pages.ViewSystemUsersPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class UsersTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    ViewSystemUsersPage viewSystemUsersPage;
    AddUserPage addUserPage ;
    @BeforeMethod(alwaysRun = true)
    public void inIt()
    {
        homePage = new HomePage();
        loginPage = new LoginPage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        addUserPage = new AddUserPage();
    }

     @Test(dataProvider = "validCredentials",dataProviderClass = TestData.class,groups = {"sanity","smoke","regression"})
    public void adminShouldAddUserSuccessFully(String userName,String password)  {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        homePage.clickOnAdminTab();
        String expectedtext = "System Users";
        String actualText = viewSystemUsersPage.getSystemUserText();
        Assert.assertEquals(expectedtext,actualText,"page not found");
        viewSystemUsersPage.clickOnAddButton();
        String expectedAddUserText = "Add User";
        String actualAddUserText = addUserPage.getaddUserText();
        Assert.assertEquals(expectedAddUserText,actualAddUserText,"page not found error");
        addUserPage.selectUserRole("Admin");
        addUserPage.enterEmployeeName("Ananya Dash");
        addUserPage.enterUserName("");
        addUserPage.selectStatusFromDropDown("Disabled");
        addUserPage.enterPassword("12345678");
        addUserPage.enterConfirmPassword("12345678");
        addUserPage.clickOnSaveButton();


    }

    @Test(dataProvider = "validCredentials",dataProviderClass = TestData.class,groups = {"smoke","regression"})
    public void searchTheUserCreatedAndVerifyIt(String userName,String password) throws InterruptedException {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        homePage.clickOnAdminTab();
        String expectedtext = "System Users";
        String actualText = viewSystemUsersPage.getSystemUserText();
        Assert.assertEquals(expectedtext,actualText,"page not found");
        viewSystemUsersPage.enterUserName("paul");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectStatus("Enabled");
        viewSystemUsersPage.clickOnSearchButton();

    }

    @Test(dataProvider = "validCredentials",dataProviderClass = TestData.class,groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully(String userName,String password) throws InterruptedException {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        homePage.clickOnAdminTab();
        String expectedtext = "System Users";
        String actualText = viewSystemUsersPage.getSystemUserText();
        Assert.assertEquals(expectedtext,actualText,"page not found");
        viewSystemUsersPage.enterUserName("manali28");
        viewSystemUsersPage.selectUserRole("ESS");
        viewSystemUsersPage.selectStatus("Enabled");
        viewSystemUsersPage.clickOnSearchButton();
        viewSystemUsersPage.clickOnUserCheckBox();
        viewSystemUsersPage.clickOnDeleteButton();
        viewSystemUsersPage.clickONOnButtonOnPopUp();

    }

    @Test(dataProvider = "validCredentials",dataProviderClass = TestData.class,groups = "regression")
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound(String userName,String password){

        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        homePage.clickOnAdminTab();
        String expectedtext = "System Users";
        String actualText = viewSystemUsersPage.getSystemUserText();
        Assert.assertEquals(expectedtext,actualText,"page not found");
        viewSystemUsersPage.enterUserName("paul");
        viewSystemUsersPage.selectUserRole("Admin");
        viewSystemUsersPage.selectStatus("Enabled");
        viewSystemUsersPage.clickOnSearchButton();
        String expectedResult = "No Records Found";
        String actualResult  = viewSystemUsersPage.getNoRecordFoundText();
        Assert.assertEquals(expectedResult,actualResult,"page not found");

    }




}
