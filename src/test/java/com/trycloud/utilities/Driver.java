package com.trycloud.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// purpose of having this Singleton class is to return only single object

public class Driver {

    private static WebDriver obj;

    private Driver(){}

    // method to set up and get driver
    // read browser type from config.properties file
    public static WebDriver getDriver() {

        String browserName = ConfigurationReader.read("browser");

        if (obj == null) {
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    obj.manage().window().maximize();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    obj = new FirefoxDriver();
                    obj.manage().window().maximize();
                    break;
                default:
                    obj = null;
                    System.out.println("Unknown Browser Type! " + browserName);
            }
            return obj;

        } else {
            return obj;
        }
    }

    public static void closeBrowser(){

            // check if we have WebDriver instance or not
            // basically checking if obj is null or not
            // if not null
            // quit the browser
            // make it null , because once quit it can not be used
            if(obj != null ){
                obj.quit();
                // so when ask for it again , it gives us not quited fresh driver
                obj = null ;
            }

    }


    }
/*
    Create a Singleton class called Driver

        1. create private no arg constructor

        2. create private static field with name obj
            Data type of variable should be WebDriver

        3. create public static method
            name : getDriver()
            return type :WebDriver
            param : none

         4. check if obj is null or not
            if yes - create ChromeDriver with all set up
             if no  -- return same obj
 */