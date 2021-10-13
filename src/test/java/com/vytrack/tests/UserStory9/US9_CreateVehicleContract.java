package com.vytrack.tests.UserStory9;

import com.github.javafaker.Faker;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.US09_FleetVechiclePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class US9_CreateVehicleContract extends TestBase {

    @Test
    public void storeManager1CreateContract() {
        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("storeManager1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);

        US09_FleetVechiclePage page = new US09_FleetVechiclePage();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(page.fleetModule).pause(1000)
                .moveToElement(page.vehicleContract).pause(1000)
                .click().perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
        wait.until(ExpectedConditions.titleIs("All - Vehicle Contract - Entities - System - Car - Entities - System"));
        page.createBtn.click();

        BrowserUtils.waitFor(2);

        page.fillUpContract();
        page.saveButton.click();
        BrowserUtils.waitFor(2);

       Assertions.assertTrue(page.confirmationMessage.isDisplayed());
    }

    @Test
    public void salesManager1CreateContract() {
        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("salesManager1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);

        US09_FleetVechiclePage page = new US09_FleetVechiclePage();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(page.fleetModule).pause(1000)
                .moveToElement(page.vehicleContract).pause(1000)
                .click().perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
        wait.until(ExpectedConditions.titleIs("All - Vehicle Contract - Entities - System - Car - Entities - System"));
        page.createBtn.click();

        BrowserUtils.waitFor(2);

        page.fillUpContract();
        page.saveButton.click();
        BrowserUtils.waitFor(2);

        Assertions.assertTrue(page.confirmationMessage.isDisplayed());
    }

    @Test
    public void driverCreateContract() {
        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("truckDriver1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);

        US09_FleetVechiclePage page = new US09_FleetVechiclePage();

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(page.fleetModule).pause(1000)
                .moveToElement(page.vehicleContract).pause(1000)
                .click().perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
        wait.until(ExpectedConditions.titleIs("Dashboard"));

//        List<WebElement> createBtn = Driver.getDriver().findElements(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
//        if (createBtn.size() == 0) {
//            //System.out.println("Element is not visible");
//            Assertions.assertTrue(createBtn.size()==0);
//        } else {
//            System.out.println("Element is visible");
//        }
       // BrowserUtils.checkVisibilityOfElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"), 2);
        Assertions.assertTrue(BrowserUtils.checkVisibilityOfElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"), 2));
//finish



    }






}
/* AC #1: managers are able to Create Vehicle Contract.

Given store/sales manager is on the homePage
When user select “Vehicle Contract” under Fleet module
And user click “Create Vehicle Contract” button
When user fill out general information and click “Save and Close” button
Then verify “Entity saved” confirm message

AC #2: driver should not to create Vehicle Contract.

Given driver is on the homePage
When user select “Vehicle Contract” under Fleet module
Then verify “You do not have permission to perform this action.” message */






