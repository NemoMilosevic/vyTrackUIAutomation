package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.UserStory3Page;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class UserStory3PageTest extends TestBase {

    @Test
    public void acceptanceCriteria1(){

/*
    AC #1: user can select all the cars by checking the first checkbox
    Given user is on the homePage
    When user select “Vehicles” under Fleet module
    And user checks the first checkbox
    Then verify all the checkbox is checked
 */

        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("storeManager1"), ConfigurationReader.read("password"));

        BrowserUtils.waitFor(4);

        UserStory3Page userSelectFirstCheckBox = new UserStory3Page();
        userSelectFirstCheckBox.vehicleSelect();
        BrowserUtils.waitFor(2);
    }

    @Test
    public void acceptanceCriteria2(){

 /*
        AC #2: user can select any car
        Given user is on the homePage
        When user select “Vehicles” under Fleet module
        And user checks any car’s checkbox
        Then verify the checkbox is checked
  */

        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("storeManager1"), ConfigurationReader.read("password"));

        BrowserUtils.waitFor(4);

        UserStory3Page userSelectAnyCheckBox = new UserStory3Page();
        userSelectAnyCheckBox.userChecksAnyCheckBox();
        BrowserUtils.waitFor(2);
    }



}