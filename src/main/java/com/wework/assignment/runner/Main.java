package com.wework.assignment.runner;

import com.wework.assignment.pageObjects.HomePage;
import com.wework.assignment.pageObjects.LocationsMenu;
import com.wework.assignment.pageObjects.OfficieSelectionPage;
import com.wework.assignment.utilities.DriverUtil;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

public class Main {

    private static HomePage homePage;
    private static LocationsMenu locationsMenu;
    private static OfficieSelectionPage officieSelectionPage;

    public static void main(String[] args) throws Exception {

        //setting up selenium web-driver for chrome browser
        DriverUtil.setupBrowser();
        WebDriver driver = DriverUtil.openChromeBrowser();

        //initialize page objects
        initializePageObjects(driver);

        //opening wework website
        driver.navigate().to("https://www.wework.com");

        //

        //mouse over to location and click location
        homePage.mouseOver(homePage.getLocationObject());   //mouseover action as asked in assignment. However, this does not open location menu to clicking location object
        homePage.clickLocations();

        //click new york city
        locationsMenu.clickLocation("New York City");

        //read all office locations
        //unable to implement getting office names from map and clicking random office name on map due to following
        // 1. office names are not available on map, instead there is a office icon for office locations with "we" text
        // 2. tried to get names from map by clicking "we" icon and reading pop-up but this method is too slow and
        // unreliable as too many pop-ups have to be opened and closed
//        officieSelectionPage.getOfficeNamesFromMap();

        // instead reading office names from page office market card object
        List<String> officeNamesList = officieSelectionPage.getOfficeNamesFromPage();

        //select random office
        Random random = new Random();
        officieSelectionPage.clickOffice(officeNamesList.get(random.nextInt(officeNamesList.size()))); //Selecting random name from office names
        
        driver.close();
    }

    private static void initializePageObjects(WebDriver driver) {
        homePage = new HomePage(driver);
        locationsMenu = new LocationsMenu(driver);
        officieSelectionPage = new OfficieSelectionPage(driver);
    }
}
