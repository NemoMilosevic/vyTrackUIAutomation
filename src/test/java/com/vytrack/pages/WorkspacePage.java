package com.vytrack.pages;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkspacePage {

    @FindBy(xpath = "//a/span[contains(text(), 'Fleet')]//ancestor::li")
    private WebElement menuFleet;

    @FindBy(xpath = "//span[text()= 'Vehicles']//parent::a//parent::li")
    private WebElement menuVehicles;

    public WorkspacePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void gotoVehicles () {
        this.menuFleet.click();
        this.menuVehicles.click();
    }

}