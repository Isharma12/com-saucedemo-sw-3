package utilities;
/**
 * 2. Create the package utilities and create the class
 * with the name ‘Utility’ inside the ‘utilities’
 * package. And write the all the utility methods in
 * it’.
 */

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utility extends BaseTest {

    @Before
            public void setUp(){
        openBrowser(baseUrl);
    }
    String baseUrl = "https://www.saucedemo.com/";

    // This method will click on the element whatever the locator you are passing
    public void clickOnElement(By by) {
        driver.findElement(by).click();

    }
    public void sendTextToElement(By by, String text) {

        driver.findElement(by).sendKeys(text);
    }

    public String getTextFromElement(By by){

        return driver.findElement(by).getText();
    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select Class
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }
    public void verifyElements(String displayMessage, String expectedMessage, By by) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }
    public void closeBrowser() {

        driver.quit();
}
}