package com.wework.assignment.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OfficieSelectionPage extends Base {

    private final By officeIndicatorOnMap = By.cssSelector("path[class='we']");
    private final By officeIndicatorParent = By.cssSelector("svg[class='WePin-jOlZPF fSgiFv']");
    private final By officeSelectorPopUp = By.cssSelector("div[class='mapboxgl-popup-content']");
    private final By officeNameText = By.cssSelector("h2[class='marketMapCard__TitleText-kJZeAZ dBGNhI']");
    private final By closePopUpBtn = By.cssSelector("g[id='X-Button-Copy']");
    private final By mapObject = By.cssSelector("div[data-selector='geo-map']");
    private final By officeCard = By.cssSelector("div[class='GridColumn-khBkHc kspqOD']");
    private final By officeNameOnCard = By.cssSelector("h2[type='title2']");

    public OfficieSelectionPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getOfficeNamesFromMap() throws InterruptedException {
        List<WebElement> webElementList = driver.findElements(officeIndicatorOnMap);
        List<String> officeNamesList = new ArrayList<>();
        for (WebElement element : webElementList) {
            Actions actions = new Actions(driver);
            actions.moveToElement(element).click().build().perform();
            officeNamesList.add(getOfficeName());
        }

        return officeNamesList;
    }

    public String getOfficeName() throws InterruptedException {
        String officeName = "";
        if(isElementDisplayed(officeSelectorPopUp)) {
            WebElement element = driver.findElement(officeSelectorPopUp);
            officeName = element.findElement(officeNameText).getText();
            driver.findElement(mapObject).click();
        } else {
            System.out.println("office selection pop-up failed to open");
        }
        return officeName;
    }

    public List<String> getOfficeNamesFromPage() {
        return driver.findElements(officeCard).stream()
                .map(element -> element.findElement(officeNameOnCard).getText()).collect(Collectors.toList());
    }

    public void clickOffice(String officeName) throws Exception {
        WebElement element = driver.findElements(officeCard).stream()
                .filter(el -> el.findElement(officeNameOnCard).getText().equals(officeName))
                .findFirst().orElseThrow(() -> new Exception("We work office: " + officeName + " was not found"));
        element.click();
    }
}
