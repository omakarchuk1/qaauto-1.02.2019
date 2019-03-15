package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

/**
 * Page Object class for PasswordResetPage page
 */

public class  PasswordResetPage {
    private WebDriver driver;
    @FindBy (xpath = "//*[@id=\"username\"]")
    private WebElement userEmailPasswordResetField;


    @FindBy (xpath ="//*[@id=\"reset-password-submit-button\"]" )
    private WebElement findAccountButton;


     /**
     * Constructor for PasswordResetPage class
     * @param driver
     */
    public PasswordResetPage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    /**
     * Method that checks that PasswordResetPage is loaded
     * @return
     */
        public boolean isPageLoaded () {

        return driver.getCurrentUrl().contains("uas/request-password-reset?")
         &&
            driver.getTitle().contains("Reset Password | LinkedIn");

        }

    /**
     * Method that adds email address in EmailPasswordResetField field and clicks on FindAccountButton
     * @return
     */

    public void emailAddingOnPasswordResetPage () {
        userEmailPasswordResetField.sendKeys("om@projectsabrina.com");
        findAccountButton.click();
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}