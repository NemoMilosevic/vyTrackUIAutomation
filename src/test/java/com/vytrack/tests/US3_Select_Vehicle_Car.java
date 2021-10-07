package com.vytrack.tests;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.Select_Vehicle_Car;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class  US3_Select_Vehicle_Car extends TestBase {

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
        loginPage.goToAndLogin(ConfigurationReader.read("salesManager1"), ConfigurationReader.read("password"));

        BrowserUtils.waitFor(4);

        Select_Vehicle_Car userSelectFirstCheckBox = new Select_Vehicle_Car();
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
        loginPage.goToAndLogin(ConfigurationReader.read("salesManager1"), ConfigurationReader.read("password"));

        BrowserUtils.waitFor(4);

        Select_Vehicle_Car userSelectAnyCheckBox = new Select_Vehicle_Car();
        userSelectAnyCheckBox.userChecksAnyCheckBox();
        BrowserUtils.waitFor(2);
    }



}