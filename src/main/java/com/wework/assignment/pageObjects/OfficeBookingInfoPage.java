package com.wework.assignment.pageObjects;

import com.wework.assignment.utilities.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OfficeBookingInfoPage extends Base {

    private final By tourForm = By.id("tourFormContainer");
    private final By priceTable = By.cssSelector("div[class='tableContainer__priceTable__3y1ME']");
//    private final By priceTitleRow = By.cssSelector("div[class='titleRow__priceTable__2ZqZn row']");
    private final By itemTitle = By.cssSelector("div[class='subHeader__priceTable__1t59_ col sm7']");
    private final By startingPrice = By.cssSelector("div[class='startingPrice__priceTable__1n4Xg caption-small']");
    private final By itemName = By.cssSelector("div[class='cellTitle__priceTable__1sjs- p col smPush1 sm5 mdPush1 md6'");
    private final By price = By.cssSelector("div[class='cellPrice__priceTable__22cVQ p col smPush2 sm11 mdPush0 md12']");
    private final By priceInfoRow = By.cssSelector("div[class='cellRow__priceTable__3f7NZ underlinedMobileListItem__priceTable__dRk7o']");

    public OfficeBookingInfoPage(WebDriver driver) {
        super(driver);
    }

    public void logPriceInfo() throws Exception {
        if (isElementDisplayed(tourForm)) {
            driver.findElements(priceTable)
                    .forEach(element -> {
                        logTitle(element);
                        logItems(element);
                    });
        } else {
            Exception ex = new Exception("Office booking page failed to open");
            Log.error(ex.getMessage(), ex);
            throw ex;
        }
    }

    private void logItems(WebElement element) {
        element.findElements(priceInfoRow).forEach(
                el -> {
                    Log.debug(el.findElement(itemName).getText());
                    Log.debug(el.findElement(price).getText());
                }
        );
    }

    private void logTitle(WebElement element) {
        Log.debug(element.findElement(itemTitle).getText());
        Log.debug(element.findElement(startingPrice).getText());
    }
}
