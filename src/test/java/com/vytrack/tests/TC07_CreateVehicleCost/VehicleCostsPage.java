package com.vytrack.tests.TC07_CreateVehicleCost;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleCostsPage {

    @FindBy(xpath = "//li[@class='dropdown dropdown-level-1']/a/span[normalize-space()='Fleet']")
    public WebElement fleetElm;

    @FindBy(xpath = "//span[.='Vehicle Costs']")
    public WebElement vehicleCostsElm;

    @FindBy(xpath = "//a[@title='Create Vehicle Costs']")
    public WebElement createVehicleCostsBnt;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveAndCloseBtn;

    @FindBy(xpath = "//div[@class='flash-messages-holder']")
    public WebElement SavedMsg;

    @FindBy(xpath = "//span[@class='select2-arrow']")
    public WebElement typeDropdown;

    @FindBy(xpath = "//input[@class='select2-input select2-focused']")
    public WebElement inputType;

    @FindBy(xpath = "//div[.='Tax Roll']")
    public WebElement textRoll;

    @FindBy(xpath = "//ul[@class='select2-breadcrumbs']")
    public WebElement Input;

    @FindBy(xpath = "//input[@name='custom_entity_type[TotalPrice]']")
    public WebElement totalPrice;

    @FindBy(xpath = "//input[@name='date_selector_custom_entity_type_Date-uid-615fd2520e7c1']")
    public WebElement dateDropdown;




    public VehicleCostsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void SelectingVehicleCosts(){

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(vehicleCostsElm).perform();
        BrowserUtils.waitFor(3);
        vehicleCostsElm.click();

        BrowserUtils.waitFor(4);

        /*
        @FindBy(xpath =" //strong[normalize-space(.)='New order has been successfully added.']")
        public WebElement successMessage ;

         */

    }








}
