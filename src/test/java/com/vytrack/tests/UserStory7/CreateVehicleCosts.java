package com.vytrack.tests.UserStory7;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.TestBase;
import com.vytrack.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;


import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreateVehicleCosts extends TestBase {


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














    }

    }
