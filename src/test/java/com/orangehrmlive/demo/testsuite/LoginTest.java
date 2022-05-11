package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class LoginTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = TestData.class,groups = {"sanity","regression","smoke"})
    public void verifyUserShouldLoginSuccessFully(String userName, String password) throws InterruptedException {

        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        String expectedText = "Welcome";
        String actualText = homePage.getWelcomeText();
        Assert.assertEquals(expectedText, actualText, "page not found");
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = TestData.class,groups = {"smoke","regression"})
    public void verifyThatTheLogoDisplayOnHomePage(String userName, String password) throws InterruptedException {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        boolean logo = homePage.logoIsDisplayed();
        Assert.assertEquals(logo,true);
    }

    @Test(dataProvider = "validCredentials", dataProviderClass = TestData.class,groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully(String userName, String password) throws InterruptedException {
        loginPage.enterUserName(userName);
        loginPage.enterPassword(password);
        loginPage.clickOnLoginButton();
        homePage.clickOnUserProfileLogo();
        homePage.mouseHoverAndClickOnLogOut();
        String expectedText = "LOGIN Panel";
        String actualText = loginPage.getLoginPanelText();
        Assert.assertEquals(actualText,expectedText,"page not found");
    }


}
