package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.HomePage;
import page.LandingPage;
import page.LoginSubmitPage;

public class Logintests extends BaseTest {

    @DataProvider
    public Object[][] invalidDataLandingPage() {
        return new Object[][]{
                {"sivak1115@outlook.com", ""},
                {"", "Temp"},
        };
    }

    @Test(dataProvider = "invalidDataLandingPage")
        public void negativeLoginTestLandingPage(String userEmail, String userPassword) {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");
        landingPage.login(userEmail, userPassword);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

    }

    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {"sivak1115@outlook.com", "Temp1234%"},
                //{"siVAK1115@outlook.com", "Temp1234%"},
                // {" sivak1115@outlook.com ", "Temp1234%"}

        };
    }

    @Test(dataProvider = "validData")
    public void positiveLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");
        HomePage homePage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page did not load after login.");

    }


    @DataProvider
    public Object[][] invalidData() {
        return new Object[][]{
                {"sivak1115@outlook.com", "Temp", "Hmm, that's not the right password. Please try again or request a new one.", ""},
                //  {"sivak1115outlook.com", "Temp", "", "Please enter a valid email address."},
                //  {"sivak11156436474@outlook.com", "Temp", "", "Hmm, we don't recognize that email. Please try again."}

        };
    }

    @Test(dataProvider = "invalidData")
    public void negativeLoginTest(String userEmail, String userPassword, String passwordValidationMessage, String emailValidationMessage) {
        LandingPage landingPage = new LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");
        LoginSubmitPage loginSubmitPage = landingPage.login(userEmail, userPassword);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(),
                "page.LoginSubmitPage page did not load after login.");

        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(), passwordValidationMessage);

        Assert.assertEquals(loginSubmitPage.getEmailValidationMessageText(), emailValidationMessage);

        Assert.assertEquals(loginSubmitPage.getEmailValidationMessageText(), emailValidationMessage);


    }
}






























    /*


    @Test
    public void negativeLoginTestInvalidEmailAddress() {
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.linkedin.com/");

       // page.LandingPage landingPage = new page.LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        landingPage.loginToLoginSubmitPage("sivak1115outlook.com", "Temp");

        page.LoginSubmitPage loginSubmitPage = new page.LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "LoginSubmit page is not loaded");
        //Assert.assertTrue(driver.getPageSource().contains("Please enter a valid email address."));
        Assert.assertEquals(loginSubmitPage.getEmailValidationMessageText(), "Please enter a valid email address.", "Wrong validation message for email field");


    }

    @Test
    public void negativeLoginTestUnexistingEmailAddress() {

       // page.LandingPage landingPage = new page.LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");
        landingPage.loginToLoginSubmitPage("sivak11156436474@outlook.com", "Temp1234%");
        page.LoginSubmitPage loginSubmitPage = new page.LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "LoginSubmit page is not loaded");
        //Assert.assertTrue(driver.getPageSource().contains("Hmm, we don't recognize that email. Please try again."));
        Assert.assertEquals(loginSubmitPage.getEmailValidationMessageText(), "Hmm, we don't recognize that email. Please try again.", "Wrong validation message for email field");
    }
/*
 /*
    @Test
    public void negativeLoginTestIncorrectPassword() {

        page.LandingPage landingPage = new page.LandingPage(driver);
        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");
        landingPage.loginToLoginSubmitPage("sivak1115@outlook.com", "Temp");
        page.LoginSubmitPage loginSubmitPage = new page.LoginSubmitPage(driver);
        Assert.assertTrue(loginSubmitPage.isPageLoaded(), "LoginSubmit page is not loaded");
        Assert.assertEquals(loginSubmitPage.getPasswordValidationMessageText(), "Hmm, that's not the right password. Please try again or request a new one.", "Wrong validation message for password field.");

    }
    */


































        /*
        // LinkedIn: Log In or Sign Up
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page tytle is wrong");
        // Check Login page URL
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login page URL is wrong.");

        // Check that Login page has 'Sign In' button displayed
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        Assert.assertEquals(signInButton.isDisplayed(), true, "SignIn button is not displayed on Login page.");
        Assert.assertTrue(signInButton.isDisplayed(), "SignIn button is not displayed on Login page.");

        //Enter email and password and login
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        userEmailField.sendKeys("sivak1115@outlook.com");
        userPasswordField.sendKeys("Temp1234%");
        signInButton.click();

        //Verify that you login
        //Li[@id='profile-nav-item']
        WebElement profileNavMenuItem = driver.findElement(By.xpath("//Li[@id='profile-nav-item']"));
        Assert.assertTrue(profileNavMenuItem.isDisplayed(), "Home page did not load after login");
}
*/

        /*// LinkedIn: Log In or Sign Up
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page tytle is wrong");
        // Check Login page URL
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login page URL is wrong.");

        // Check that Login page has 'Sign In' button displayed
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        Assert.assertEquals(signInButton.isDisplayed(), true, "SignIn button is not displayed on Login page.");
        Assert.assertTrue(signInButton.isDisplayed(), "SignIn button is not displayed on Login page.");
        //Assert.assertFalse(signInButton.isDisplayed(),"SignIn button is displayed on Login page.";

        //Enter 'a@b.c' into userEmail field; Enter '' into userPass field
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));

        userEmailField.sendKeys("a@b.c");
        userPasswordField.sendKeys("");
        signInButton.click();

        //Verify that user remains on Login page
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page tytle is wrong");
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login page URL is wrong.");
        Assert.assertTrue(signInButton.isDisplayed(), "SignIn button is not displayed on Login page.");

    }
    @Test
        public void successfulLoginTest () {
        String expectedUrl = "https://www.linkedin.com/";
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com/");
        // LinkedIn: Log In or Sign Up
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up", "Login page tytle is wrong");
        // Check Login page URL
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login page URL is wrong.");

        // Check that Login page has 'Sign In' button displayed
        WebElement signInButton = driver.findElement(By.xpath("//input[@id='login-submit']"));
        Assert.assertEquals(signInButton.isDisplayed(), true, "SignIn button is not displayed on Login page.");
        Assert.assertTrue(signInButton.isDisplayed(), "SignIn button is not displayed on Login page.");

        //Enter email and password and login
        WebElement userEmailField = driver.findElement(By.xpath("//input[@id='login-email']"));
        WebElement userPasswordField = driver.findElement(By.xpath("//input[@id='login-password']"));
        userEmailField.sendKeys("sivak1115@outlook.com");
        userPasswordField.sendKeys("Temp1234%");
        signInButton.click();

        //Verify that you login
         //Li[@id='profile-nav-item']
        WebElement profileNavMenuItem = driver.findElement(By.xpath("//Li[@id='profile-nav-item']"));
        Assert.assertTrue(profileNavMenuItem.isDisplayed(), "Home page did not load after login");


    }



}
*/


//String currentUrl = driver.getCurrentUrl();
//String expectedUrl = "https://www.linkedin.com/";
//   Assert.assertEquals (currentUrl,  expectedUrl, "Login page URL is wrong.");
//better Assert.assertEquals (driver.getCurrentUrl(),  expectedUrl, "Login page URL is wrong.");

        /*
        // Check Login page URL
        String expectedUrl = "https://www.linkedin.com/";
        driver.get(expectedUrl);
        try{
            Assert.assertEquals(expectedUrl, driver.getCurrentUrl());
            System.out.println("Navigated to correct webpage");
        }
        catch(Throwable pageNavigationError) {
            System.out.println("Didn't navigate to correct webpage");
        }
        // Check that Login page has 'Sign In' button displayed
        String expectedButton = "Sign in";
        try {
            Assert.assertTrue(driver.getPageSource().contains("Sign in"));
            System.out.println("Login page has 'Sign In' button displayed");
            }
        catch(Throwable pageNavigationError){
        System.out.println("Login page does not have 'Sign In' button displayed");
    }
          //Enter 'a@b.c' into userEmail field
        WebElement searchField = driver.findElement(By.xpath("//*[@id='login-email']"));
        searchField.sendKeys("a@b.c");
        //Enter '' into userPass field (means enter empty String)
        WebElement searchField1 = driver.findElement(By.xpath("//*[@id='login-password']"));
        searchField1.sendKeys("");
        //Click on 'Sign In' button
        WebElement searchField2 = driver.findElement(By.xpath("//*[@id='login-submit']"));
        searchField2.click();

        //Verify that user remains on Login page
        String expectedTitle = "LinkedIn: Log In or Sign Up";
        try{
            Assert.assertEquals(expectedTitle, driver.getTitle());
            System.out.println("User remains on Login page");
        }
        catch(Throwable pageNavigationError){
            System.out.println("User does not remain on Login page");
        }

        }
            }
*/


















