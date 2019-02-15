import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    WebDriver driver;
    WebElement signInButton;   //= driver.findElement(By.xpath("//input[@id='login-submit']"));
    WebElement userEmailField; //= driver.findElement(By.xpath("//input[@id='login-email']"));
    WebElement userPasswordField; //= driver.findElement(By.xpath("//input[@id='login-password']"));
     String expectedUrl = "https://www.linkedin.com/";

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));

            }

    public void login(String userEmail, String userPassword) {

        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
    }

    public boolean isPageLoaded() {
          if (signInButton.isDisplayed())
            return  true;
        else
            return false;



       /* Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page tytle is wrong");
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login page URL is wrong.");
        Assert.assertEquals(signInButton.isDisplayed(), true, "SignIn button is not displayed on Login page.");
        */

    }

}



