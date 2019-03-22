package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

/**
 * Page Object class for RequestPasswordResetPage page
 */

public class RequestPasswordResetPage extends BasePage {

    @FindBy (xpath = "//*[@id=\"username\"]")
    private WebElement userEmailField;


    @FindBy (xpath ="//button[@id=\"reset-password-submit-button\"]" )
    private WebElement findAccountButton;

     /**
     * Constructor for RequestPasswordResetPage class
     * @param driver
     */
    public RequestPasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    /**
     * Method that checks that RequestPasswordResetPage is loaded
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

    public RequestPasswordResetSubmitPage findAccount (String userEmail) {
        userEmailField.sendKeys(userEmail);

        String messageSubject = "here's the link to reset your password";
        String messageTo = userEmail;
        String messageFrom = "security-noreply@linkedin.com";

        GMailService gMailService = new GMailService();
        gMailService.connect();

        findAccountButton.click();
        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);

        String resetPasswordUrl = StringUtils.substringBetween(message, "href=\"", "\" style=\\\"cursor:pointer;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\\\">Reset my password\"");
        resetPasswordUrl.replace("amp", "");
        // driver.get(resetPasswordUrl);
        return new RequestPasswordResetSubmitPage(driver);

    }
}