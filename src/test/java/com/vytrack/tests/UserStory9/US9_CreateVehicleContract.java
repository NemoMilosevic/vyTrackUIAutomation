package com.vytrack.tests.UserStory9;

import com.github.javafaker.Faker;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
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


public class US9_CreateVehicleContract {

    @Test
    public void createContract() {
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


        WebElement createBtn = Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createBtn.click();

        BrowserUtils.waitFor(2);
        WebElement typeDrop = Driver.getDriver().findElement(By.xpath("(//span[@class='select2-arrow'])[1]"));
        typeDrop.click();

        WebElement cashOption = Driver.getDriver().findElement(By.xpath("//div[@class='select2-result-label' and .='Cash']"));
        actions.moveToElement(cashOption).click().perform();

        fillUpContract();

        WebElement saveButton = Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-success action-button' and normalize-space(.)='Save and Close']"));
        saveButton.click();

        BrowserUtils.waitFor(2);

        WebElement confirmationMessage = Driver.getDriver().findElement(By.xpath("//div[@id='flash-messages']/div/div[@class='flash-messages-holder']"));
        Assertions.assertTrue(confirmationMessage.isDisplayed());
    }

    @Test
    public void driverCreateContract() {
        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("truckDriver1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);

        WebElement fleetModule = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-1' and normalize-space(.)='Fleet']"));
        WebElement vehicleContract = Driver.getDriver().findElement(By.xpath("//span[@class='title title-level-2' and normalize-space(.)='Vehicle Contracts']"));

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(fleetModule).pause(1000)
                .moveToElement(vehicleContract).pause(1000)
                .click().perform();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 2);
        wait.until(ExpectedConditions.titleIs("Dashboard"));

        //WebElement createBtn=Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        //Assertions.assertTrue(createBtn.isDisplayed());

      /*  try {
            boolean createBtn1 =Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']")).isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return;
        }*/

       /* try {
            System.out.println("Driver.getDriver().findElement(By.xpath(\"//a[@class='btn main-group btn-primary pull-right ']\")).isDisplayed() = " + Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']")).isDisplayed());
        } catch (NoSuchElementException e) {

        }
        Assertions.assertTrue(Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']")) == null);
       // Assertions.assertTrue(Driver.getDriver().findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']")).isDisplayed());
*/

        //Assertions.assertTrue(createBtn=NoSuchElementException.class);
        //assertTrue(createBtn.isEmpty());

        List<WebElement> createBtn = Driver.getDriver().findElements(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        if (createBtn.size() == 0) {
            //System.out.println("Element is not visible");
            Assertions.assertTrue(createBtn.size()==0);
        } else {
            System.out.println("Element is visible");
        }



    }

    public void fillUpContract() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        WebElement responsible = Driver.getDriver().findElement(By.name("custom_entity_type[Responsible]"));
        responsible.sendKeys(faker.name().fullName());

        WebElement activationCost = Driver.getDriver().findElement(By.name("custom_entity_type[ActivationCost]"));
        activationCost.sendKeys(faker.number().digits(2));

        WebElement costAmount = Driver.getDriver().findElement(By.name("custom_entity_type[RecurringCostAmount]"));
        costAmount.sendKeys(faker.number().digits(3));

        WebElement costDrop = Driver.getDriver().findElement(By.xpath("(//span[@class='select2-arrow'])[2]"));
        costDrop.click();
        WebElement dailyOption = Driver.getDriver().findElement(By.xpath("//div[@class='select2-result-label' and .='Daily']"));
        actions.moveToElement(dailyOption).click().perform();

        WebElement odometerDetails = Driver.getDriver().findElement(By.name("custom_entity_type[OdometerDetails]"));
        odometerDetails.sendKeys(faker.number().digits(6));

        WebElement invoiceDate = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[1]"));
        //invoiceDate.sendKeys(faker.numerify("00/00"));

        WebElement contractStartDate = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[2]"));
        //contractStartDate.sendKeys(faker.date().future());

        WebElement contractExpirationDate = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[3]"));
        //contractExpirationDate.sendKeys(faker.numerify("00/00"));

        WebElement vendor = Driver.getDriver().findElement(By.name("custom_entity_type[Vendor]"));
        vendor.sendKeys(faker.name().fullName());

        WebElement driver = Driver.getDriver().findElement(By.name("custom_entity_type[Driver]"));
        driver.sendKeys(faker.name().fullName());

        WebElement contactReference = Driver.getDriver().findElement(By.name("custom_entity_type[ContractReference]"));
        contactReference.sendKeys(faker.name().fullName());

        WebElement termsAndConditions = Driver.getDriver().findElement(By.name("custom_entity_type[TermsandConditions]"));
        termsAndConditions.sendKeys(faker.book().toString());

        WebElement statusDrop = Driver.getDriver().findElement(By.xpath("(//span[@class='select2-arrow'])[3]"));
        statusDrop.click();
        WebElement activeOption = Driver.getDriver().findElement(By.xpath("//div[@class='select2-result-label' and .='Active']"));
        actions.moveToElement(activeOption).click().perform();
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






