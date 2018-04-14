package com.wework.assignment.runner;

import com.wework.assignment.pageObjects.HomePage;
import com.wework.assignment.pageObjects.LocationsMenu;
import com.wework.assignment.utilities.DriverUtil;
import org.openqa.selenium.WebDriver;

public class Main {

    private static HomePage homePage;
    private static LocationsMenu locationsMenu;

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

        driver.close();
    }

    private static void initializePageObjects(WebDriver driver) {
        homePage = new HomePage(driver);
        locationsMenu = new LocationsMenu(driver);
    }
}
