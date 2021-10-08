package com.vytrack.tests.UserStory11;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TestBase;
import com.vytrack.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewAllVehicleModels extends TestBase
{

    @Test
    public void vehicleModels(){
        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("storeManager1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);

        Actions actions = new Actions(Driver.getDriver());
        WebElement fleetModule = driver.findElement(By.xpath("//span[@class='title title-level-1' and normalize-space(.)='Fleet']"));

        BrowserUtils.waitFor(2);

        actions.moveToElement(fleetModule).perform();
        BrowserUtils.waitFor(4);

        WebElement vehiclesModel = driver.findElement(By.partialLinkText("Vehicles Model"));
        vehiclesModel.click();

        BrowserUtils.waitFor(4);

        List<WebElement> allVehicleModels = driver.findElements(By.xpath("//tr[@class='grid-row row-click-action']"));
        int actual = allVehicleModels.size();
        int expectedModels = 5;

        assertEquals(expectedModels,actual);

    }

}
