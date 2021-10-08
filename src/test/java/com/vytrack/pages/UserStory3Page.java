package com.vytrack.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserStory3Page{

    @FindBy(xpath = "//*[@id=\"main-menu\"]/ul/li[2]/a/span")
    public WebElement fleet;

    @FindBy(xpath = "//span[.='Vehicles']")
    public WebElement vehicle;

    @FindBy(css = "table .grid-header:nth-of-type(1) input")
    public WebElement checkBox;

    @FindBy(xpath = "//tbody[@class='grid-body']/tr[@class='grid-row row-click-action'][1]")
    public WebElement allCheckBox;

    public UserStory3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void vehicleSelect(){

        fleet.click();
        BrowserUtils.waitFor(2);
        vehicle.click();
        BrowserUtils.waitFor(2);
        checkBox.click();
        Assertions.assertTrue(checkBox.isSelected());

    }

    public void userChecksAnyCheckBox(){
        fleet.click();
        BrowserUtils.waitFor(2);
        vehicle.click();
        BrowserUtils.waitFor(2);

        List<WebElement> selectWholeCheckBox = Driver.getDriver().findElements(By.xpath("//tr[@class='grid-row row-click-action']"));
        System.out.println("selectWholeCheckBox.size() = " + selectWholeCheckBox.size());

        for (int i = 1; i < selectWholeCheckBox.size(); i++) {

            WebElement eachCheckBox = Driver.getDriver().findElement(By.xpath("//tr[@class='grid-row row-click-action']["+i+"]//input[@tabindex='-1']"));
            eachCheckBox.click();
            Assertions.assertTrue(eachCheckBox.isSelected());
            BrowserUtils.waitFor(1);
            eachCheckBox.click();

        }

    }
}