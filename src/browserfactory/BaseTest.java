package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void browserSetup(String givenUrl, String browser) {
        //Using if-else statement to select the browser
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            driver = new FirefoxDriver();
        }

        //Opening the given url in selected browser
        driver.get(givenUrl);

        //Maximising the windows upon opening
        driver.manage().window().maximize();

        //Declaring Timeout to allow the page to load completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void closingTheBrowser() {
        driver.quit();
    }
}