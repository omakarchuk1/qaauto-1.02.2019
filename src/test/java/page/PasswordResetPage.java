package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

/**
 * Page Object class for PasswordResetPage page
 */

public class  PasswordResetPage {
    private WebDriver driver;

    @FindBy (xpath = "//*[@id=\"username\"]")
    private WebElement userEmailField;


    @FindBy (xpath ="//button[@id=\"reset-password-submit-button\"]" )
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

        return findAccountButton.isDisplayed()
                && driver.getCurrentUrl().contains("uas/request-password-reset?")
              && driver.getTitle().contains("Reset Password | LinkedIn");

        }

    /**
     * Method that adds email address in EmailPasswordResetField field and clicks on FindAccountButton
     * @return
     */

    public void findAccount (String userEmail) {
        userEmailField.sendKeys(userEmail);

        String messageSubject = "here's the link to reset your password";
        String messageTo = userEmail;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();

        findAccountButton.click();
        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        String resetPasswordUrl = null;
        driver.get(resetPasswordUrl);

    }
}