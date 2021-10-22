package com.vytrack.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateCarPage {

    @FindBy(css = "[id^='custom_entity_type_LicensePlate']")
    private WebElement licensePlate;

    @FindBy(css = "[id^='custom_entity_type_Driver']")
    private WebElement driverInput;

    @FindBy(css = "[id^='custom_entity_type_Location']")
    private WebElement location;

    @FindBy(css="[id^='custom_entity_type_Tags_0']")
    private WebElement optionJunior;

    @FindBy(css="[id^='custom_entity_type_Tags_1']")
    private WebElement optionSenior;

    @FindBy(css="[id^='custom_entity_type_Tags_2']")
    private WebElement optionEmployeeCar;

    @FindBy(css="[id^='custom_entity_type_Tags_3']")
    private WebElement optionPurchased;

    @FindBy(css="[id^='custom_entity_type_Tags_4']")
    private WebElement optionCompact;

    @FindBy(css="[id^='custom_entity_type_Tags_5']")
    private WebElement optionSedan;

    @FindBy(css="[id^='custom_entity_type_Tags_6']")
    private WebElement optionConvertable;





    @FindBy(css = "[id^='custom_entity_type_ChassisNumber']")
    private WebElement chassisNumber;

    @FindBy(css = "[id^='custom_entity_type_ModelYear']")
    private WebElement modelYear;

    @FindBy(css = "[id^='custom_entity_type_LastOdometer']")
    private WebElement lastOdometer;

    @FindBy(css = "[id^='custom_entity_type_CatalogValue']")
    private WebElement catalogValue;

    @FindBy(css = "[id^='custom_entity_type_SeatsNumber']")
    private WebElement seatsNumber;

    @FindBy(css = "[id^='custom_entity_type_DoorsNumber']")
    private WebElement doorsNumber;

    @FindBy(css = "[id^='custom_entity_type_Color']")
    private WebElement color;

    @FindBy(css = "[id^='date_selector_custom_entity_type_ImmatriculationDate']")
    private WebElement immatriculationDate;

    @FindBy(css= "[id^='date_selector_custom_entity_type_FirstContractDate']")
    private WebElement firstContractDate;

    @FindBy(css = "[id^='custom_entity_type_CO2Emissions']")
    private WebElement co2emissions;

    @FindBy(css = "[id^='custom_entity_type_Horsepower']")
    private WebElement horsePower;

    @FindBy(css = "[id^='custom_entity_type_HorsepowerTaxation']")
    private WebElement horsePowerTaxation;

    @FindBy(css = "[id^='custom_entity_type_Power']")
    private WebElement power;

    @FindBy(css = "[class='btn btn-success action-button']")
    private WebElement saveAndClose;

    @FindBy(xpath = "//span[text()='General Information']")
    private WebElement generalInfo;

    public void setDriverInput(String value) {
        driverInput.sendKeys(value);
    }

    public void setOptionJunior(Boolean checked){
        if (optionJunior.isSelected() != checked){
            optionJunior.click();

        }
    }
    public void setOptionSenior(Boolean checked){
        if(optionSenior.isSelected() != checked){
            optionSenior.click();
        }
    }
    public void setOptionEmployeeCar(Boolean checked){
        if(optionEmployeeCar.isSelected() !=checked){
            optionEmployeeCar.click();
        }
    }

    public void setOptionPurchased(Boolean checked){
        if(optionPurchased.isSelected()!=checked){
            optionPurchased.click();
        }
    }

    public void setOptionCompact(Boolean checked){
        if(optionCompact.isSelected()!=checked){
            optionCompact.click();
        }
    }

    public void setOptionSedan(Boolean checked){
        if(optionSedan.isSelected()!=checked){
            optionSedan.click();
        }
    }

    public void setOptionConvertable(Boolean checked){
        if(optionConvertable.isSelected()!=checked){
            optionConvertable.click();
        }
    }

    public void setLocation(String value) {
        location.sendKeys(value);
    }

    public void setLicensePlate(String value) {
        licensePlate.sendKeys(value);
    }

    public void setChassisNumber(String value) {
        chassisNumber.sendKeys(value);
    }

    public void setModelYear(String value){ modelYear.sendKeys(value);}

    public void setLastOdometer(String value){ lastOdometer.sendKeys(value);}

    public void setImmatriculationDate(int index) {
        immatriculationDate.click();
        BrowserUtils.waitFor(3);
        List<WebElement> tds = Driver.getDriver().findElements(By.cssSelector("[data-handler='selectDay']"));
        tds.get(index).click();
    }

    public void setFirstContractDate(int index) {
        firstContractDate.click();
        BrowserUtils.waitFor(2);
        List<WebElement> tds = Driver.getDriver().findElements(By.cssSelector("[data-handler='selectDay']"));
        tds.get(index).click();
    }

    public void setCatalogValue(String value){ catalogValue.sendKeys(value);}

    public void setSeatsNumber(String value){ seatsNumber.sendKeys(value);}

    public void setDoorsNumber(String value){ doorsNumber.sendKeys(value);}

    public void setColor(String value){ color.sendKeys(value);}

   // public void setTransmission(String value){ transmission.sendKeys(value);}

   // public void setFuelType(String value){ fuelType.sendKeys(value);}

    public void setEmissions(String value){ co2emissions.sendKeys(value);}

    public void setHorsePower(String value){ horsePower.sendKeys(value);}

    public void setHorsePowerTaxation(String value){ horsePowerTaxation.sendKeys(value);}

    public void setPower(String value){ power.sendKeys(value);}











    public CreateCarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void saveAndClose() {
        saveAndClose.click();
    }
}