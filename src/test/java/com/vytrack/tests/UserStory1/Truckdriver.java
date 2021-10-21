package com.vytrack.tests.UserStory1;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.US_1;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Truckdriver {


    /*
        AC:
Given driver is on the homePage
Then verify user view 4 models names [verify the names]

     */

    @Test
    public void TruckDriver() {

        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("truckDriver1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(5);


        List<String> actualModules = US_1.getElementsText(new US_1().allModules);

        List<String> expectedModules = new ArrayList<>(Arrays.asList("Fleet", "Customers", "Activities", "System"));

        Assertions.assertEquals(expectedModules, actualModules);


    }
}
