package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.LandingPage;

/**
 * Page Object class for BaseTest
 */
public class BaseTest {
    private WebDriver driver;
    LandingPage landingPage;

    /**
     * Method which is used at the beginning for all tests which extends BaseTest
     */
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        landingPage = new LandingPage(driver);
    }

    /**
     * Method which is used at the end for all tests which extends BaseTest
     */
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
