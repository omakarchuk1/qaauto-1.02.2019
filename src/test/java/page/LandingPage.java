package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page Object class for Landing page.
 */
public class LandingPage extends BasePage {

    @FindBy (xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy (xpath ="//input[@id='login-email']")
    private WebElement userEmailField;

    @FindBy (xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    @FindBy (xpath = "//*[@class ='link-forgot-password']")
    private  WebElement forgotPasswordButton;

    /**
     * Constructor for LandingPage class.
     * @param driver - WebDriver instance from BaseTest.
     */
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
            }

    /**
     * Method which helps page object to return more than one type of page object
     * @param userEmail
     * @param userPassword
     * @param <T>
     * @return
     */
 public <T> T login (String userEmail, String userPassword){

     userEmailField.sendKeys(userEmail);
     userPasswordField.sendKeys(userPassword);
     signInButton.click();
     if (driver.getCurrentUrl().contains("/feed/")) {
         return (T) new HomePage(driver);
     } if (driver.getCurrentUrl().contains ("/login-submit")) {
         return (T) new LoginSubmitPage(driver);
     } else {
         return (T) new LandingPage(driver);
     }
 }

    /**
     * Method that check if page is loaded
     * @return true/false
     */
    public boolean isPageLoaded() {
        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");


    }

    /**
     * Method that helps to click on Forget Password button
     * @return
     */
    public RequestPasswordResetPage clickOnForgotPasswordLink () {

       forgotPasswordButton.click();
       return new RequestPasswordResetPage(driver);
   }

}




































//initElements();


   /* private void initElements() {
        signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));

    */


   /*

      public page.HomePage loginToHomePage(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new page.HomePage(driver);
    }

    public page.LoginSubmitPage loginToLoginSubmitPage(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new page.LoginSubmitPage(driver);
    }


    public page.LandingPage loginToLandingPage(String userEmail, String userPassword) {
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return new page.LandingPage(driver);



    }
*/
/*
    public <T extends LoginResult> T login(String userEmail, String userPassword, Class<T> expectedPage){
        userEmailField.sendKeys(userEmail);
        userPasswordField.sendKeys(userPassword);
        signInButton.click();
        return PageFactory.initElements(driver, expectedPage);
    }
*/
