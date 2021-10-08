package com.vytrack.tests.UserStory5;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TestBase;
import com.vytrack.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class AC1selectAllTheAccounts extends TestBase {
    @Test
            public void selectAccounts () {
        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("storeManager1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);

        Actions actions = new Actions(Driver.getDriver());
        WebElement customerModule = driver.findElement(By.partialLinkText("Customers"));

        actions.moveToElement(customerModule).perform();
        BrowserUtils.waitFor(2);

        Driver.getDriver().findElement(By.xpath("//span[.='Accounts']")).click();
        BrowserUtils.waitFor(3);

        Driver.getDriver().findElement(By.xpath("//button/input[@type='checkbox']")).click();
        BrowserUtils.waitFor(2);


        List<WebElement> checkBoxes = driver.findElements(By.xpath("//td/input[@type='checkbox']"));

        for (WebElement eachBoxes : checkBoxes) {
            Assertions.assertTrue(eachBoxes.isSelected());

        }

    }
    @Test
            public void selectAccounts1(){
        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("salesManager1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);

        Actions actions = new Actions(Driver.getDriver());
        WebElement customerModule = driver.findElement(By.partialLinkText("Customers"));

        actions.moveToElement(customerModule).perform();
        BrowserUtils.waitFor(2);

        Driver.getDriver().findElement(By.xpath("//span[.='Accounts']")).click();
        BrowserUtils.waitFor(3);

        Driver.getDriver().findElement(By.xpath("//button/input[@type='checkbox']")).click();
        BrowserUtils.waitFor(2);


        List<WebElement> checkBoxes = driver.findElements(By.xpath("//td/input[@type='checkbox']"));

        for (WebElement eachBoxes : checkBoxes) {
            Assertions.assertTrue(eachBoxes.isSelected());

        }

    }
    @Test
            public void selectAccounts2(){
        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("truckDriver1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);

        Actions actions = new Actions(Driver.getDriver());
        WebElement customerModule = driver.findElement(By.partialLinkText("Customers"));

        actions.moveToElement(customerModule).perform();
        BrowserUtils.waitFor(2);

        Driver.getDriver().findElement(By.xpath("//span[.='Accounts']")).click();
        BrowserUtils.waitFor(3);

        Driver.getDriver().findElement(By.xpath("//button/input[@type='checkbox']")).click();
        BrowserUtils.waitFor(2);


        List<WebElement> checkBoxes = driver.findElements(By.xpath("//td/input[@type='checkbox']"));

        for (WebElement eachBoxes : checkBoxes) {
            Assertions.assertTrue(eachBoxes.isSelected());

        }
    }
}
