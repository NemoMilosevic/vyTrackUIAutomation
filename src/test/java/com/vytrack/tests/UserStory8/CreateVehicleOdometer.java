package com.vytrack.tests.UserStory8;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.TestBase;
import com.vytrack.pages.US08_CreateOdometerPage;
import com.vytrack.pages.LoginPage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreateVehicleOdometer extends TestBase {

    LoginPage loginPage = new LoginPage();
    US08_CreateOdometerPage createOdometer = new US08_CreateOdometerPage();

    @Test
    public void testDriverCreateOdometer(){
        loginPage.goTo();
        loginPage.login("user33","UserUser123");
        BrowserUtils.waitFor(2);
        createOdometer.accessVehicleOdometerDriver();
        BrowserUtils.waitFor(2);
        createOdometer.createVehicleOdometer();
        BrowserUtils.waitFor(2);
        createOdometer.fillOutInfo();
        BrowserUtils.waitFor(2);
        String expected = createOdometer.entitySavedMsgDriver.getText();
        String actual = "Entity saved";
        assertEquals(expected,actual);
    }

    @Test
    public void testStoreManagerCreateOdometer(){
        loginPage.goTo();
        loginPage.login("storemanager73","UserUser123");
        BrowserUtils.waitFor(3);
        createOdometer.accessVehicleOdometerManager();
        BrowserUtils.waitFor(3);
        String expected = createOdometer.entitySavedMsgManager.getText();
        String actual = "You do not have permission to perform this action.";
        assertEquals(expected,actual);
    }

    @Test
    public void testSalesManagerCreateOdometer() {
        loginPage.goTo();
        loginPage.login("salesmanager134", "UserUser123");
        BrowserUtils.waitFor(3);
        createOdometer.accessVehicleOdometerManager();
        BrowserUtils.waitFor(3);
        String expected = createOdometer.entitySavedMsgManager.getText();
        String actual = "You do not have permission to perform this action.";
        assertEquals(expected,actual);
    }

}
