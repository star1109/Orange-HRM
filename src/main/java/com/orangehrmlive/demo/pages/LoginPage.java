package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utility {

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

   @FindBy(id = "txtUsername")
    WebElement userName;

  @FindBy(id = "txtPassword")
    WebElement password;

  @FindBy(id = "btnLogin")
    WebElement loginButton;

    @FindBy(id = "logInPanelHeading")
    WebElement loginPanelText;

    public void enterUserName(String username){
        sendTextToElement(userName,username);
    }

    public void enterPassword(String pwd)
    {
        sendTextToElement(password,pwd);
    }

    public void clickOnLoginButton()
    {
        clickOnElement(loginButton);
    }

    public String getLoginPanelText()
    {
        return getTextFromElement(loginPanelText);
    }



}
