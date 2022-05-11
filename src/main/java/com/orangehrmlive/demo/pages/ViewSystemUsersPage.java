package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewSystemUsersPage extends Utility {
    public ViewSystemUsersPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//h1[contains(text(),'System Users')]")
    WebElement systemUserText;

    @FindBy(id = "searchSystemUser_userName")
    WebElement userName;

    @FindBy(id = "searchSystemUser_userType")
    WebElement userRoleDropDown;

    @FindBy(xpath = "//input[@id='searchSystemUser_employeeName_empName']")
    WebElement employeeName;

    @FindBy(xpath = "//select[@id='searchSystemUser_status']")
    WebElement statusDropDown;

    @FindBy(id = "searchBtn")
    WebElement searchButton;

    @FindBy(id = "resetBtn")
    WebElement resetButton;

    @FindBy(id = "btnAdd")
    WebElement addButton;

    @FindBy(id = "btnDelete")
    WebElement deleteButton;

    @FindBy(name = "chkSelectRow[]")
    WebElement clickOnCheckBox;


    public String getSystemUserText()
    {
        return getTextFromElement(systemUserText);
    }

    public void enterUserName(String uname)
    {
        sendTextToElement(userName,uname);
    }

    public void selectUserRole(String role){
        selectByVisibleTextFromDropDown(userRoleDropDown,role);
    }

    public void enterEmployeeName(String ename)
    {
        sendTextToElement(employeeName,ename);
    }

    public void selectStatus(String status)
    {
        selectByVisibleTextFromDropDown(statusDropDown,status);
    }

    public void clickOnSearchButton()
    {
        clickOnElement(searchButton);
    }

    public void clickOnResetButton()
    {
        clickOnElement(resetButton);
    }

    public void clickOnAddButton()
    {
        clickOnElement(addButton);
    }

    public void clickOnDeleteButton()
    {
        clickOnElement(deleteButton);
    }

    public void clickOnUserCheckBox()
    {
        clickOnElement(clickOnCheckBox);
    }

    @FindBy(xpath = "//input[@id='dialogDeleteBtn']")
    WebElement okButtonOnDelete;

    public void clickONOnButtonOnPopUp()
    {
        clickOnElement(okButtonOnDelete);
    }


    @FindBy(xpath = "//td[contains(text(),'No Records Found')]")
    WebElement noRecordFoundText;

    public String getNoRecordFoundText()
    {
        return getTextFromElement(noRecordFoundText);
    }




}
