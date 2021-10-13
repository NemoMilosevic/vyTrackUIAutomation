package com.vytrack.pages;

import com.github.javafaker.Faker;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US09_FleetVechiclePage {

    public US09_FleetVechiclePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//span[@class='title title-level-1' and normalize-space(.)='Fleet']")
    public WebElement fleetModule;

    @FindBy (xpath = "//span[@class='title title-level-2' and normalize-space(.)='Vehicle Contracts']")
    public WebElement vehicleContract;

    @FindBy (xpath = "//a[@class='btn main-group btn-primary pull-right ']")
    public WebElement createBtn;

    @FindBy (xpath = "(//span[@class='select2-arrow'])[1]")
    public WebElement typeDrop;

    @FindBy (xpath = "//div[@class='select2-result-label' and .='Cash']")
    public WebElement cashOption;

    @FindBy (xpath = "//div[@id='flash-messages']/div/div[@class='flash-messages-holder']")
    public WebElement confirmationMessage;

    @FindBy (xpath = "//button[@class='btn btn-success action-button' and normalize-space(.)='Save and Close']")
    public WebElement saveButton;


    //contractInfo
    @FindBy (name = "custom_entity_type[Responsible]")
    public WebElement responsible;

    @FindBy (name = "custom_entity_type[ActivationCost]")
    public WebElement activationCost;

    @FindBy (name = "custom_entity_type[RecurringCostAmount]")
    public WebElement costAmount;

    @FindBy (xpath = "(//span[@class='select2-arrow'])[2]")
    public WebElement costDrop;

    @FindBy (xpath = "//div[@class='select2-result-label' and .='Daily']")
    public WebElement dailyOption;

    @FindBy (name = "custom_entity_type[OdometerDetails]")
    public WebElement odometerDetails;

    @FindBy (name = "custom_entity_type[Vendor]")
    public WebElement vendor;

    @FindBy (name = "custom_entity_type[Driver]")
    public WebElement driver;

    @FindBy (name = "custom_entity_type[ContractReference]")
    public WebElement contactReference;

    @FindBy (name = "custom_entity_type[TermsandConditions]")
    public WebElement termsAndConditions;

    @FindBy (xpath = "(//span[@class='select2-arrow'])[3]")
    public WebElement statusDrop;

    @FindBy (xpath = "//div[@class='select2-result-label' and .='Active']")
    public WebElement activeOption;



    public void fillUpContract() {
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();

        typeDrop.click();
        actions.moveToElement(cashOption).click().perform();
        responsible.sendKeys(faker.name().fullName());
        activationCost.sendKeys(faker.number().digits(2));
        costAmount.sendKeys(faker.number().digits(3));
        costDrop.click();
        actions.moveToElement(dailyOption).click().perform();
        odometerDetails.sendKeys(faker.number().digits(6));
       /* WebElement invoiceDate = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[1]"));
        //invoiceDate.sendKeys(faker.numerify("00/00"));

        WebElement contractStartDate = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[2]"));
        //contractStartDate.sendKeys(faker.date().future());

        WebElement contractExpirationDate = Driver.getDriver().findElement(By.xpath("(//input[@placeholder='Choose a date'])[3]"));
        //contractExpirationDate.sendKeys(faker.numerify("00/00"));*/
        vendor.sendKeys(faker.name().fullName());
        driver.sendKeys(faker.name().fullName());
        contactReference.sendKeys(faker.name().fullName());
        termsAndConditions.sendKeys(faker.book().toString());
        statusDrop.click();
        actions.moveToElement(activeOption).click().perform();
    }




}
