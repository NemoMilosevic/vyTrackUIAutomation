package com.vytrack.tests;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehicleCostsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC07_CreateVehicleCosts extends TestBase {


    @Test
    public void TC007() {

        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login("user33", "UserUser123");

        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();


        //WebElement fleetButton = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1']"));
        vehicleCostsPage.fleetBtn.click();


        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(vehicleCostsPage.fleetBtn).perform();
        BrowserUtils.waitFor(3);
        vehicleCostsPage.createVehicleCostBtn.click();

        BrowserUtils.waitFor(4);


        WebElement btn = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        btn.click();

        BrowserUtils.waitFor(4);

        /*
        WebElement typeDropdownElm = Driver.getDriver().findElement(By.xpath("//span[@class='select2-chosen']"));
        typeDropdownElm.click();
        WebElement typeField = Driver.getDriver().findElement(By.xpath("//input[@class='select2-input']"));
        typeField.click();
        typeField.sendKeys("Tax Roll");
       // Select typeSelectObj = new Select(typeDropdownElm);
        //typeSelectObj.selectByVisibleText("Tax Roll");

         */

        WebElement submitBtn = driver.findElement(By.xpath("//button[@class='btn btn-success action-button']"));
        submitBtn.click();
        BrowserUtils.waitFor(3);

        //assertTrue(vehicleCostsPage.successMessage.isDisplayed());






        /*
        WebElement yearDropdownElm = driver.findElement(By.id("year")) ;
        // TODO: Wrap it up using Select class so we can use easy methods
        Select yearSelectObj = new Select(yearDropdownElm) ;
        // TODO: select items in 3 different ways
        // Select 3rd item
        yearSelectObj.selectByIndex(2);
        // Select item with value attribute 2019
        yearSelectObj.selectByValue("2019");
        // Select item with visible text 1990
        yearSelectObj.selectByVisibleText("1990");

         */

    }

    }
