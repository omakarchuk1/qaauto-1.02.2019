package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * Page Object class for HomePage
 */
public class HomePage extends BasePage {

    @FindBy(xpath = "//Li[@id='profile-nav-item']")
    private WebElement profileNavMenuItem;

    @FindBy (xpath = "//form[@id='extended-nav-search']//input")
    private WebElement searchField;

    /**
     * Constructor for HomePage class
     * @param driver
     */
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method which checks if the page is loaded
     * @return
     */
    public boolean isPageLoaded() {
        return profileNavMenuItem.isDisplayed()
                && driver.getCurrentUrl().contains("/feed/")
                && driver.getTitle().contains("LinkedIn");
    }

    /**
     * Method which helps to search an item
     * @param searchTerm
     * @return
     */
    public SearchPage search(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new SearchPage (driver);
    }
}