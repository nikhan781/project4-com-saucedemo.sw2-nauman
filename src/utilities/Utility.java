package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {

    public void enterTheElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    public void clickOnTheElement(By by) {
        driver.findElement(by).click();
    }

    public String verifyTest(By by) {
        WebElement actualText = driver.findElement(by);
        return actualText.getText();

    }
}
