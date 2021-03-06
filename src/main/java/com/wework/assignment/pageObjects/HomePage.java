package com.wework.assignment.pageObjects;

import com.wework.assignment.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends Base{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private final By location = By.cssSelector("a[href='/locations']");

    public WebElement getLocationObject() {
        return driver.findElement(location);
    }

    public void clickLocations() {
        Log.info("Clicking location object: " + location.toString());
        driver.findElement(location).click();
    }

    public void mouseOver(WebElement element) {
        Log.info("Performing mouse over action on object: " + location.toString());
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
