package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//b[contains(text(),'PIM')]")
    WebElement pimText;

    @FindBy(xpath = "//b[contains(text(),'Leave')]")
    WebElement leaveText;

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement dashBoardText;

    @FindBy(xpath = "//a[@id='welcome']")
    WebElement welcomeText;

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement adminTab;

    @FindBy(xpath = "//a[@id='welcome']")
    WebElement profileLogo;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logout;

    public String getPimText() {
        Reporter.log("get pim text " + pimText.toString() + "<br>");
        return getTextFromElement(pimText);
    }

    public String getLeaveText() {
        Reporter.log("get getLeave text" + leaveText.toString() + "<br>");
        return getTextFromElement(leaveText);
    }

    public String dashBoardText() {
        Reporter.log("get Dashboard Text" + dashBoardText.toString() + "<br>");
        return getTextFromElement(dashBoardText);
    }

    public String getWelcomeText() {
        Reporter.log("verify the welcome text " + welcomeText.toString() + "<br>");
        String str = welcomeText.getText();
        String result = str.substring(0, 7);
        return result;
    }

    public void clickOnAdminTab() {
        Reporter.log("Click on AdminTab" + adminTab.toString() + "<br>");
        clickOnElement(adminTab);
    }

    public void clickOnUserProfileLogo() {
        Reporter.log("Click on user profile logo " + profileLogo.toString() + "<br>");
        clickOnElement(profileLogo);
    }

    public void mouseHoverAndClickOnLogOut() {
        Reporter.log("MouseHover to logout button " + logout.toString() + "<br>");
        mouseHoverToElementAndClick(logout);
    }

    @FindBy(xpath = "//body/div[@id='wrapper']/div[@id='branding']/a[1]/img[1]")
    WebElement OrangeHRMLogo;
    public boolean logoIsDisplayed() {
        Reporter.log("Check logo is displayed " + welcomeText.toString() + "<br>");
        return OrangeHRMLogo.isDisplayed();
    }

}
