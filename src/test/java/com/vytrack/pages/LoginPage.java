package com.vytrack.pages;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy (id = "prependedInput")
    private WebElement usernameBox;

    @FindBy (id ="prependedInput2")
    private WebElement passwordBox;

    @FindBy (id ="_submit")
    private WebElement loginBtn;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void goToAndLogin (String username, String password){
        Driver.getDriver().get(ConfigurationReader.read("truckDriver1", "storeManager1", "salesManager1", "url"));
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }



}