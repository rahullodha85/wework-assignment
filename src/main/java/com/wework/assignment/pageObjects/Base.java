package com.wework.assignment.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
    protected WebDriver driver;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    protected boolean isElementDisplayed(By by) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20);
        return webDriverWait.until((WebDriver drv) -> drv.findElement(by).isDisplayed());
    }
}
