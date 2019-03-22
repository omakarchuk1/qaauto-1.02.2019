package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object class for LoginSubmitPage
 */
public class LoginSubmitPage extends BasePage {

   @FindBy (xpath = "//div[@id='error-for-password']")
    private WebElement passwordValidationMessage;

    @FindBy (xpath = "//form[@class='login__form']")
   private WebElement loginForm;

    @FindBy (xpath = "//div[@id='error-for-username']")
    private WebElement emailValidationMessage;

    /**
     * Constructor for LoginSubmitPage
     * @param driver
     */
    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
           }

    /**
     * Method that checks that the page is loaded
     * @return
     */
    public boolean isPageLoaded() {
                return loginForm.isDisplayed()
                 //&& driver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                        && driver.getCurrentUrl().contains("/login-submit")
                && driver.getTitle().equals("Sign In to LinkedIn");
    }

    /**
     * Method that checks password validation message
     * @return
     */
    public String getPasswordValidationMessageText() {

        return passwordValidationMessage.getText();
    }

    /**
     * Method that checks email validation message
     * @return
     */
    public String getEmailValidationMessageText () {

        return emailValidationMessage.getText();
    }
}
