package com.trycloud.utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class TestBase { // adding abstract keyword in order to make it a superclass

    // THIS IS A SUPER-CLASS WHERE USEFUL METHODS ARE CREATED FOR SUB-CLASSES

    protected WebDriver driver;

    @BeforeEach
    public void setupWebDriver(){
        driver = Driver.getDriver();
    }

    @AfterEach
    public void quitBrowser(){
        Driver.closeBrowser();
    }

}
