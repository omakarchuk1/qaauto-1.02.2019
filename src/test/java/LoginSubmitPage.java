import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {

    private WebDriver driver;
   // private WebElement PasswordFieldonLoginSubmitPage;
    WebElement passwordValidationMessage;
    WebElement loginForm;
    WebElement emailValidationMessage;

    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        //div[@id='error-for-password']
        //form[@class='login__form']
        //PasswordFieldonLoginSubmitPage = driver.findElement(By.xpath("//div[@class='form__input--floating']"));
        passwordValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
        loginForm = driver.findElement(By.xpath("//form[@class='login__form']"));
        emailValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
            }

    public boolean isPageLoaded() {
                return loginForm.isDisplayed()
                 //&& driver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                        && driver.getCurrentUrl().contains("/login-submit")
                && driver.getTitle().equals("Sign In to LinkedIn");
    }

    public String getPasswordValidationMessageText() {
        return passwordValidationMessage.getText();
    }

    public String getEmailValidationMessageText () {

        return emailValidationMessage.getText();
    }
}