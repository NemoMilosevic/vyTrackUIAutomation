package com.vytrack.tests;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.VehicleCostsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class TC07_CreateVehicleCosts extends TestBase {


    @Test
    public void TC007() {

        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login("user33", "UserUser123");

        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();


        vehicleCostsPage.fleetElm.click();
        vehicleCostsPage.SelectingVehicleCosts();

        vehicleCostsPage.createVehicleCostsBnt.click();
        BrowserUtils.waitFor(3);

        vehicleCostsPage.typeDropdown.click();
        BrowserUtils.waitFor(2);

        vehicleCostsPage.inputType.sendKeys("Tax Roll", Keys.ENTER);
        BrowserUtils.waitFor(2);

        vehicleCostsPage.totalPrice.sendKeys("10000");
        BrowserUtils.waitFor(2);

       // vehicleCostsPage.dateDropdown.click();


        vehicleCostsPage.saveAndCloseBtn.click();
        BrowserUtils.waitFor(2);
        assertTrue(vehicleCostsPage.SavedMsg.isDisplayed());










        /*



        WebElement submitBtn = driver.findElement(By.xpath("//button[@class='btn btn-success action-button']"));
        submitBtn.click();
        BrowserUtils.waitFor(3);
         */

        /*
        WebElement typeDropdownElm = Driver.getDriver().findElement(By.xpath("//span[@class='select2-chosen']"));
        typeDropdownElm.click();
        WebElement typeField = Driver.getDriver().findElement(By.xpath("//input[@class='select2-input']"));
        typeField.click();
        typeField.sendKeys("Tax Roll");
       // Select typeSelectObj = new Select(typeDropdownElm);
        //typeSelectObj.selectByVisibleText("Tax Roll");
         */


        //assertTrue(vehicleCostsPage.successMessage.isDisplayed());








    }

    }
