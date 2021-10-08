package com.vytrack.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US06_OptionsUnderUser {

    @FindBy(xpath = "//li[@class='dropdown user-menu-dropdown']")
    public WebElement dropdownMenu;

    @FindBy(xpath = "//*[@id=\"user-menu\"]/ul/li[1]/a")
    public WebElement myUser;

    @FindBy(xpath = "//li[@class='mobile-hide']/a[@href='/config/user/profile']")
    public WebElement myConfiguration;

    @FindBy(xpath = "//*[@id=\"user-menu\"]/ul/li[3]/a")
    public WebElement myCalendar;


    public US06_OptionsUnderUser(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goToDropdown(){
        dropdownMenu.click();
    }


}
