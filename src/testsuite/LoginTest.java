package testsuite;

/**
 * Write down the following test into ‘LoginTest’
 * class
 * 1. userSholdLoginSuccessfullyWithValid
 *
 * Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 *
 * 2. verifyThatSixProductsAreDisplayedOnPage
 *
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 * on page
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;


public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter password
        sendTextToElement(By.name("password"), "secret_sauce");
        //Click on 'Login' button
        clickOnElement(By.id("login-button"));
        //Verify the text "Products"
verifyElements("error", "Products", By.xpath("//span[text()='Products']"));

    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter username
        sendTextToElement(By.id("user-name"), "standard_user");
        //Enter password
        sendTextToElement(By.name("password"), "secret_sauce");
        //Click on 'Login' button
        clickOnElement(By.id("login-button"));
       //Verify that six products are displayed on page
        List<WebElement> productList = driver.findElements(By.xpath("//div[@class = 'inventory_item']"));
        System.out.println("Total products are : " + productList.size());

   }
 @After
    public void tearDown(){

        closeBrowser();
 }



}
