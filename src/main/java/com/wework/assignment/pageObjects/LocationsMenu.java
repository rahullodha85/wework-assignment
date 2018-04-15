package com.wework.assignment.pageObjects;

import com.wework.assignment.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationsMenu extends Base {
    private final By allLocations = By.cssSelector("a[class='SL_norewrite marketLink__countryList__JksMa baseLink__countryList__LLjol']");
    private final By locationMenu = By.cssSelector("div[class='wrapper__locationsDropdown__38P8m open__locationsDropdown__1MW3p']");

    public LocationsMenu(WebDriver driver) {
        super(driver);
    }

    public void clickLocation(final String locationText) throws Exception {
        if(isElementDisplayed(locationMenu)) {
            WebElement element = driver.findElements(allLocations).stream()
                    .filter(el -> el.getText().equals(locationText))
                    .findFirst().orElseThrow(() -> new Exception("Element with text: " + locationText + " was not found"));
            element.click();
        } else {
            Exception ex = new Exception("Location menu is not open");
            Log.error("Location menu is not open", ex);
            throw ex;
        }
    }
}
