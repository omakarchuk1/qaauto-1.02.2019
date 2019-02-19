import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage {

    private WebDriver driver;
    private WebElement PasswordFieldonLoginSubmitPage;

    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        PasswordFieldonLoginSubmitPage = driver.findElement(By.xpath("//div[@class='form__input--floating']"));
            }

    public boolean isPageLoaded() {
                return PasswordFieldonLoginSubmitPage.isDisplayed()
                 && driver.getCurrentUrl().equals("https://www.linkedin.com/uas/login-submit?loginSubmitSource=GUEST_HOME")
                && driver.getTitle().equals("Sign In to LinkedIn");

    }
}