package com.vytrack.tests.UserStory6;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.US06_OptionsUnderUser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptionsUnderUserTest {

    @Test
    public void test3optionsUnderAccountName() {

        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("truckDriver1"),
                ConfigurationReader.read("password"));

        US06_OptionsUnderUser options = new US06_OptionsUnderUser();
        options.goToDropdown();


        assertEquals("My Configuration",options.myConfiguration.getText());
        assertEquals("My Calendar", options.myCalendar.getText());
        assertEquals("My Username", options.myUser.getText());// this will not pass-it's bug
        System.out.println("myConfiguration.getText() = " +options. myConfiguration.getText());
        System.out.println("myCalendar.getText() = " + options.myCalendar.getText());
        System.out.println("myUser.getText() = " + options.myUser.getText());

        //Bug - misspelled Username/User



        BrowserUtils.waitFor(2);


    }



}
