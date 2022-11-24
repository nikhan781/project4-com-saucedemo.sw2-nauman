package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {

    @Before
    public void openBrowser() {
        //Opening browser in selected browser(Please choose, 'Chrome', 'Firefox', or 'Edge'
        browserSetup("https://www.saucedemo.com/", "Chrome");
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Entering username in username field
        enterTheElement(By.xpath("//input[@id='user-name']"), "standard_user");

        //Entering the password in password field
        enterTheElement(By.xpath("//input[@id='password']"), "secret_sauce");

        //Clicking on the Login button
        clickOnTheElement(By.xpath("//input[@id='login-button']"));

        //Verify the text 'Products'
        String expectedMessage = "PRODUCTS";
        String actualMessage = verifyTest(By.xpath("//span[text()='Products']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {

        //Entering username in username field
        enterTheElement(By.xpath("//input[@id='user-name']"), "standard_user");

        //Entering the password in password field
        enterTheElement(By.xpath("//input[@id='password']"), "secret_sauce");

        //Clicking on the Login button
        clickOnTheElement(By.xpath("//input[@id='login-button']"));

        //Verify that page has 6 products
        int expectedSize = 6;
        List<WebElement> numberOfProducts = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        int size = numberOfProducts.size();
        Assert.assertEquals(expectedSize, size);


    }

    @After
    public void closeBrowser() {
        closingTheBrowser();
    }
}
