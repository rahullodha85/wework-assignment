package com.wework.assignment.runner;

import com.wework.assignment.pageObjects.HomePage;
import com.wework.assignment.pageObjects.LocationsMenu;
import com.wework.assignment.pageObjects.OfficeBookingInfoPage;
import com.wework.assignment.pageObjects.OfficieSelectionPage;
import com.wework.assignment.utilities.DriverUtil;
import com.wework.assignment.utilities.Log;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Random;

public class Main {

    private static HomePage homePage;
    private static LocationsMenu locationsMenu;
    private static OfficieSelectionPage officieSelectionPage;
    private static OfficeBookingInfoPage officeBookingInfoPage;


    public static void main(String[] args) throws Exception {

        //setting up selenium web-driver for chrome browser
        Log.info("Setting up chrome browser with selenium web-driver");
        DriverUtil.setupBrowser();
        WebDriver driver = DriverUtil.openChromeBrowser();

        //initialize page objects
        initializePageObjects(driver);

        //opening wework website
        try {
            Log.info("Navigating to: https://www.wework.com");
            driver.navigate().to("https://www.wework.com");

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

//          officieSelectionPage.getOfficeNamesFromMap(); //attempted to get office names from map pop-ups

            // instead reading office names from page office market card object
            List<String> officeNamesList = officieSelectionPage.getOfficeNamesFromPage();

            //select random office
            Random random = new Random();
            officieSelectionPage.clickOffice(officeNamesList.get(random.nextInt(officeNamesList.size()))); //Selecting random name from office names

            //log pricing info
            officeBookingInfoPage.logPriceInfo();

        } catch (Exception ex) {
            Log.error(ex.getMessage(), ex);
        } finally {
            driver.close();
            Log.info("Browser closed");
        }
    }

    private static void initializePageObjects(WebDriver driver) {
        Log.info("Initializing page object factory");
        homePage = new HomePage(driver);
        locationsMenu = new LocationsMenu(driver);
        officieSelectionPage = new OfficieSelectionPage(driver);
        officeBookingInfoPage = new OfficeBookingInfoPage(driver);
    }
}
