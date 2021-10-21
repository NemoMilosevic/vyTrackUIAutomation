package com.vytrack.tests.UserStory1;

import com.vytrack.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.vytrack.pages.US_1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SalesManager {


    /*

    AC:
Given sales manager is on the homePage
Then verify user view 8 models names [verify the names]

     */

    @Test
    public void salesManager() {

        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("salesManager1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);


        List<String> actualModules = US_1.getElementsText(new US_1().allModules);

        List<String> expectedModules = new ArrayList<>(Arrays.asList("Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"));

        Assertions.assertEquals(expectedModules, actualModules);


    }

}