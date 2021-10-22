package com.vytrack.tests.UserStory2;

import com.github.javafaker.Faker;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.TestBase;
import com.vytrack.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class TC02_AC02 extends TestBase {

    /**
     * Story: As a user, I should be create vehicles/cars.
     * AC #2: only store/sales manager able to create car
     */

    @ParameterizedTest
    @MethodSource("provideUsers")
    public void  userCreateCar(String user, String password, Boolean shouldButtonBeVisible) {

        // authorization
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(user, password);

        // workspace
        BrowserUtils.waitFor(4);
        WorkspacePage workspacePage = new WorkspacePage();
        workspacePage.gotoVehicles();

        // vehicles
        BrowserUtils.waitFor(4);
        VehiclesPage vehiclesPage = new VehiclesPage();
        Assertions.assertEquals(shouldButtonBeVisible, vehiclesPage.isCreateCarButtonPresent(4));

        // finalization
        BrowserUtils.waitFor(5);
    }

    private static List<Arguments> provideUsers() {
        List<Arguments> result = new ArrayList<Arguments>();
        String password = ConfigurationReader.read("password");
        result.add(Arguments.of(ConfigurationReader.read("storeManager1"), password, true));
        result.add(Arguments.of(ConfigurationReader.read("storeManager2"), password, true));
       // result.add(Arguments.of(ConfigurationReader.read("storeManager3"), password, true));
        result.add(Arguments.of(ConfigurationReader.read("truckDriver1"), password, false));
        result.add(Arguments.of(ConfigurationReader.read("truckDriver2"), password, false));
        result.add(Arguments.of(ConfigurationReader.read("truckDriver3"), password, false));
        return result;
    }
}


