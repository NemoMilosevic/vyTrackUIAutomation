package com.vytrack.pages;
import com.github.javafaker.Faker;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US08_CreateOdometerPage {

    @FindBy(xpath = "//*[@title='Create Vehicle Odometer']")
    public WebElement createOdometerButton;

    @FindBy(name = "custom_entity_type[OdometerValue]")
    public WebElement odometerValueBox;

    @FindBy(xpath = "//input[@placeholder='Choose a date']")
    public WebElement dateBox;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[5]/a")
    public WebElement datePicker;

    @FindBy(name = "custom_entity_type[Driver]")
    public WebElement driverBox;

    @FindBy(xpath = "//span[text()='miles']")
    public WebElement unitsMiles;

    @FindBy(xpath = "//button[@class='btn btn-success action-button']")
    public WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"flash-messages\"]/div/div/div/div")
    public WebElement entitySavedMsgDriver;

    @FindBy(xpath = "//*[@id=\"flash-messages\"]/div/div/div[2]/div")
    public WebElement entitySavedMsgManager;

    public US08_CreateOdometerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void accessVehicleOdometerDriver(){
        WebElement fleet = Driver.getDriver().findElement(By.linkText("Fleet"));
        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[1]/div/div/ul/li[4]/a/span"));
        Actions builder = new Actions(Driver.getDriver());
        Action mouseOverFleet = builder.moveToElement(fleet).build();
        mouseOverFleet.perform();
        vehicleOdometer.click();
    }

    public void accessVehicleOdometerManager(){
        WebElement fleet = Driver.getDriver().findElement(By.linkText("Fleet"));
        WebElement vehicleOdometer = Driver.getDriver().findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/div/div/ul/li[4]/a/span"));
        Actions builder = new Actions(Driver.getDriver());
        Action mouseOverFleet = builder.moveToElement(fleet).build();
        mouseOverFleet.perform();
        vehicleOdometer.click();
    }

    public void createVehicleOdometer(){
        createOdometerButton.click();
    }

    public void fillOutInfo(){
        Faker faker = new Faker();
        odometerValueBox.sendKeys(faker.numerify("######"));
        dateBox.click();
        datePicker.click();
        driverBox.sendKeys(faker.name().fullName());
        unitsMiles.click();
        saveButton.submit();
    }

}