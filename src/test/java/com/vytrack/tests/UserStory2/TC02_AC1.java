package com.vytrack.tests.UserStory2;
import com.github.javafaker.Faker;
import com.trycloud.utilities.*;
import com.vytrack.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class TC02_AC1 extends TestBase {
    /**
     * Story: As a user, I should be create vehicles/cars.
     * AC #1: only store/sales manager able to create car
     * Given store/sales manager is on the homePage
     * When user select “Vehicles” under Fleet module
     * And user click “create car” button
     * When user fill out general information
     * And click “Save and Close” button
     * Then verify “Entity saved” confirm message
     */
    @ParameterizedTest
    @MethodSource("provideManagers")
    public void  managerCreateCar(String user, String password) {

        // fake values generator
        Faker ukFaker = new Faker(new Locale("en-GB"));

        // authorization
        LoginPage loginPage = new LoginPage();
        loginPage.goTo();
        loginPage.login(user, password);

        // workspace
        BrowserUtils.waitFor(5);
        WorkspacePage workspacePage = new WorkspacePage();
        workspacePage.gotoVehicles();

        // vehicles
        BrowserUtils.waitFor(10);
        VehiclesPage vehiclesPage = new VehiclesPage();
        vehiclesPage.clickCreateCar();

        // create car page
        BrowserUtils.waitFor(10);
        CreateCarPage createCarPage = new CreateCarPage();

        String valueLicensePlate = ukFaker.numerify("####");
        String valueDriver = ukFaker.numerify("####");
        String valueLocation = ukFaker.address().country() + ", " + ukFaker.address().city() + ", " + ukFaker.address().streetAddress();
        String valueChassisNumber = ukFaker.numerify("########");
        String valueModelYear = ukFaker.numerify("201#");
        String valueLastOdometer = ukFaker.numerify("######");

        String valueCatalogVal = ukFaker.numerify("##.##");
        String valueSeatsNumber = ukFaker.numerify("#");
        String valueDoorsNumber = ukFaker.numerify("#");
        Boolean isJuniorSelected = ukFaker.random().nextBoolean();
        Boolean isSeniorSelected = ukFaker.random().nextBoolean();
        Boolean isEmployeeCarSelected = ukFaker.random().nextBoolean();
        Boolean isPurchasedSelected = ukFaker.random().nextBoolean();
        Boolean isCompactSelected = ukFaker.random().nextBoolean();
        Boolean isSedanSelected = ukFaker.random().nextBoolean();
        Boolean isConvertableSelected = ukFaker.random().nextBoolean();
        Integer immatriculationDateIndex = ukFaker.random().nextInt(27);
        Integer firstContractIndex = ukFaker.random().nextInt(27);
        String valueColor = ukFaker.color().name();
        // String valueTransmission = ukFaker.numerify("dropdown");
        //String valueFuelType = ukFaker.numerify("dropdown);
        String valueEmissions = ukFaker.numerify("#####");
        String valueHorsePower = ukFaker.numerify("#####");
        String valueHorsePowerTaxation = ukFaker.numerify("###");
        String valuePower = ukFaker.numerify("##");

        createCarPage.setLicensePlate(valueLicensePlate);

        createCarPage.setOptionJunior(isJuniorSelected);
        createCarPage.setOptionSenior(isSeniorSelected);
        createCarPage.setOptionEmployeeCar(isEmployeeCarSelected);
        createCarPage.setOptionPurchased(isPurchasedSelected);
        createCarPage.setOptionCompact(isCompactSelected);
        createCarPage.setOptionSedan(isSedanSelected);
        createCarPage.setOptionConvertable(isConvertableSelected);

        createCarPage.setDriverInput(valueDriver);
        createCarPage.setLocation(valueLocation);
        createCarPage.setChassisNumber(valueChassisNumber);
        createCarPage.setModelYear(valueModelYear);
        createCarPage.setLastOdometer(valueLastOdometer);
        createCarPage.setImmatriculationDate(immatriculationDateIndex);
        createCarPage.setFirstContractDate(firstContractIndex);
        createCarPage.setCatalogValue(valueCatalogVal);
        createCarPage.setSeatsNumber(valueSeatsNumber);
        createCarPage.setDoorsNumber(valueDoorsNumber);
        createCarPage.setColor(valueColor);
       // createCarPage.setTransmission(valueTransmission);
       // createCarPage.setFuelType(valueFuelType);
        createCarPage.setEmissions(valueEmissions);
        createCarPage.setHorsePower(valueHorsePower);
        createCarPage.setHorsePowerTaxation(valueHorsePowerTaxation);
        createCarPage.setPower(valuePower);

        createCarPage.saveAndClose();

        BrowserUtils.waitFor(4);
        CarPage carPage = new CarPage();
        Assertions.assertEquals(valueLicensePlate, carPage.licensePlateText());
        Assertions.assertEquals(valueDriver, carPage.driverText());
        Assertions.assertEquals(valueLocation, carPage.locationText());
        Assertions.assertEquals(valueChassisNumber, carPage.chassisNumberText());
        Assertions.assertEquals(valueModelYear, carPage.modelYearText());
        Assertions.assertEquals(valueLastOdometer, carPage.lastOdometerText());

        // TODO: add another assertions

        Assertions.assertEquals(valuePower, carPage.powerText());


        // finalization
        BrowserUtils.waitFor(5);
    }

    private static List<Arguments> provideManagers() {
        List<Arguments> result = new ArrayList<Arguments>();
        String password = ConfigurationReader.read("password");
        result.add(Arguments.of(ConfigurationReader.read("storeManager1"), password));
        result.add(Arguments.of(ConfigurationReader.read("storeManager2"), password));
     //   result.add(Arguments.of(ConfigurationReader.read("storeManager3"), password));
        return result;
    }
}


