package com.vytrack.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class OroPage {
    @FindBy(xpath = "//i[@class='fa-question-circle']")
    public WebElement oroBtn;

    public boolean verifyOroTitle() {
        ArrayList<String> handles = new ArrayList<>();
        for (String each : Driver.getDriver().getWindowHandles()) {
            handles.add(Driver.getDriver().switchTo().window(each).getTitle());
        }
        return handles.contains("Welcome to Oro Documentation");
    }
    public OroPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
