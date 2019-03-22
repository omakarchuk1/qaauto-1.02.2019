package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChooseNewPasswordPage1 extends BasePage{

    private WebDriver driver;

    @FindBy (xpath = "//*[@id=\"reset-password-submit-button\"]")
    private WebElement goToHomePageButton;

    public ChooseNewPasswordPage1(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

        public boolean isPageLoaded () {

            return goToHomePageButton.isDisplayed()
                    && driver.getCurrentUrl().contains("checkpoint/rp/password-reset-submit")
                    && driver.getTitle().contains("You've successfully reset your password. | LinkedIn");

        }
    }

