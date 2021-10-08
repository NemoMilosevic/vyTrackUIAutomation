package com.vytrack.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US09_FleetVechiclePage {

    public US09_FleetVechiclePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//span[@class='title title-level-1' and normalize-space(.)='Fleet']")
    public WebElement fleetModule;

    @FindBy (xpath = "//span[@class='title title-level-2' and normalize-space(.)='Vehicle Contracts']")
    public WebElement vehicleContract;


}
