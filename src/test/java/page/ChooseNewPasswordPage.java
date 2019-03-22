package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseNewPasswordPage extends BasePage {

    @FindBy (xpath = "//*[@id=\"newPassword\"]")
    WebElement newPasswordField;

    @FindBy (xpath = "//*[@id=\"confirmPassword\"]")
    WebElement retypeNewPasswordField;

    @FindBy (xpath = "//*[@id=\"reset-password-submit-button\"]")
    WebElement submitButton;


    public ChooseNewPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        public boolean isPageLoaded () {

            return newPasswordField.isDisplayed()
                    && retypeNewPasswordField.isDisplayed()
                    && driver.getCurrentUrl().contains("checkpoint/rp/password-reset")
                    && driver.getTitle().contains("Reset Your Password | LinkedIn");

        }

    public void enterNewPassword (String newEmailPassword, String retypeNewEmailPassword) {
        newPasswordField.sendKeys(newEmailPassword);

        retypeNewPasswordField.sendKeys(retypeNewEmailPassword);
        submitButton.click();



    }
}
