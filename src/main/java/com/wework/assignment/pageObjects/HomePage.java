package com.wework.assignment.pageObjects;

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
        driver.findElement(location).click();
    }

    public void mouseOver(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }
}
