package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
    private WebDriver driver;
    @FindBy (xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @FindBy (xpath ="//input[@id='login-email']")
    private WebElement userEmailField;

    @FindBy (xpath = "//input[@id='login-password']")
    private WebElement userPasswordField;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
            }

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

    public boolean isPageLoaded() {
        return signInButton.isDisplayed()
                && driver.getCurrentUrl().equals("https://www.linkedin.com/")
                && driver.getTitle().equals("LinkedIn: Log In or Sign Up");


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
