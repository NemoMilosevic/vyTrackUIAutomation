package com.vytrack.tests.UserStory10;


import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.TestBase;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.OroPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccessOroDocPage extends TestBase {
    @Test
    public void storeM1AccessOroPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("storeManager1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);
        OroPage oroPage = new OroPage();
        oroPage.oroBtn.click();
        Assertions.assertTrue(oroPage.verifyOroTitle());
    }
    @Test
    public void storeM2AccessOroPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("storeManager2"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);
        OroPage oroPage = new OroPage();
        oroPage.oroBtn.click();
        Assertions.assertTrue(oroPage.verifyOroTitle());
    }
    @Test
    public void storeM3AccessOroPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("storeManager3"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);
        OroPage oroPage = new OroPage();
        oroPage.oroBtn.click();
        Assertions.assertTrue(oroPage.verifyOroTitle());
    }
    @Test
    public void salesM1AccessOroPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("salesManager1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);
        OroPage oroPage = new OroPage();
        oroPage.oroBtn.click();
        Assertions.assertTrue(oroPage.verifyOroTitle());
    }
    @Test
    public void salesM2AccessOroPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("salesManager2"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);
        OroPage oroPage = new OroPage();
        oroPage.oroBtn.click();
        Assertions.assertTrue(oroPage.verifyOroTitle());
    }
    @Test
    public void salesM3AccessOroPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("salesManager3"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);
        OroPage oroPage = new OroPage();
        oroPage.oroBtn.click();
        Assertions.assertTrue(oroPage.verifyOroTitle());
    }

    @Test
    public void tD1AccessOroPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("truckDriver1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);
        OroPage oroPage = new OroPage();
        oroPage.oroBtn.click();
        Assertions.assertTrue(oroPage.verifyOroTitle());
    }
    @Test
    public void tD2AccessOroPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("truckDriver2"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);
        OroPage oroPage = new OroPage();
        oroPage.oroBtn.click();
        Assertions.assertTrue(oroPage.verifyOroTitle());
    }
    @Test
    public void td3AccessOroPage(){
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(ConfigurationReader.read("truckDriver1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);
        OroPage oroPage = new OroPage();
        oroPage.oroBtn.click();
        Assertions.assertTrue(oroPage.verifyOroTitle());
    }
}
