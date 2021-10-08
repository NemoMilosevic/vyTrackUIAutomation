package com.vytrack.tests.UserStory4;

import com.github.javafaker.Faker;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.trycloud.utilities.TestBase;
import com.vytrack.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateContactInfo extends TestBase {

    @Test
    public void createContactInfo(){
        LoginPage login = new LoginPage();
        login.goTo();
        login.login(ConfigurationReader.read("storeManager1"), ConfigurationReader.read("password"));
        BrowserUtils.waitFor(2);

        Actions actions = new Actions(Driver.getDriver());
        WebElement customerModule = driver.findElement(By.partialLinkText("Customers"));

        actions.moveToElement(customerModule).perform();
        BrowserUtils.waitFor(4);


        WebElement contactsBtn = driver.findElement(By.xpath("//span[.='Contacts']"));
        contactsBtn.click();

        BrowserUtils.waitFor(4);

        WebElement createContactBtn = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createContactBtn.click();

        BrowserUtils.waitFor(2);
        Faker faker = new Faker();





        WebElement namePrefix = driver.findElement(By.name("oro_contact_form[namePrefix]"));
        namePrefix.sendKeys(faker.name().prefix());
        BrowserUtils.waitFor(3);

        WebElement firstName = driver.findElement(By.name("oro_contact_form[firstName]"));
        firstName.sendKeys(faker.name().firstName());

        BrowserUtils.waitFor(2);

        WebElement middleName = driver.findElement(By.name("oro_contact_form[middleName]"));
        middleName.sendKeys(faker.name().nameWithMiddle());

        BrowserUtils.waitFor(2);

        WebElement lastName = driver.findElement(By.name("oro_contact_form[lastName]"));
        lastName.sendKeys(faker.name().lastName());

        BrowserUtils.waitFor(2);

        WebElement nameSuffix = driver.findElement(By.name("oro_contact_form[nameSuffix]"));
        nameSuffix.sendKeys(faker.name().suffix());

        BrowserUtils.waitFor(2);

        //WebElement description = driver.findElement(By.className("mce-content-body "));
        // description.sendKeys("This is My contact");

        //BrowserUtils.waitFor(2);

        WebElement email = driver.findElement(By.name("oro_contact_form[emails][0][email]"));
        email.sendKeys("abcdhga123@gmail.com");

        BrowserUtils.waitFor(2);

        WebElement phoneNumber = driver.findElement(By.name("oro_contact_form[phones][0][phone]"));
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());

        BrowserUtils.waitFor(2);

        WebElement fax = driver.findElement(By.name("oro_contact_form[fax]"));
        fax.sendKeys(faker.number().digit());


        BrowserUtils.waitFor(2);


        WebElement saveAndCloseBtn = driver.findElement(By.xpath("//button[@class='btn btn-success action-button']"));
        saveAndCloseBtn.click();

        BrowserUtils.waitFor(2);

        String expectedMsg = "Contact saved";
        String actualMsg = driver.findElement(By.xpath("//div[@class='message']")).getText();

        assertEquals(expectedMsg,actualMsg);






    }

}
/**
 * 4. Story: As a user, I should be create contact information.
 * AC #1: users are able to create contacts.
 * Given user is on the homePage
 * When user select “Contacts” under Customers module
 * And user click “Create Contact” button
 * When user fill out general information
 * And click “Save and Close” button
 * Then verify “contact saved” confirm message
 * 5. Story: As a user, I should be to select accounts from acc
 */