package com.vytrack.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclesPage {

    public static final String XPathCreateButton = "//*[@title='Create Car']";

    public VehiclesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void clickCreateCar() {
        Driver.getDriver().findElement(By.xpath(XPathCreateButton)).click();
    };
    public boolean isCreateCarButtonPresent(int timeToWait) {
        return BrowserUtils.checkVisibilityOfElement(By.xpath(XPathCreateButton), timeToWait);
    }
}


