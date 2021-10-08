package com.vytrack.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleCostsPage {

    @FindBy(xpath = "//span[@class='title title-level-1']")
    public WebElement fleetBtn;

    @FindBy( xpath = "\"//span[.='Vehicle Costs']\"")
    public WebElement  createVehicleCostBtn;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement submitBtn;

    @FindBy(linkText= "Entity saved")
    public WebElement successMessage;


    public VehicleCostsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    /*
     @FindBy(xpath =" //strong[normalize-space(.)='New order has been successfully added.']")
    public WebElement successMessage ;
     */



}
