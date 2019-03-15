package test;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.PasswordResetPage;

public class PasswordResetPageTest extends BaseTest {

    private WebElement ForgotPasswordButton;
    PasswordResetPage passwordResetPage;

    /**
     * SuccessfulPasswordResetTest
     * Scenario:
     * -click on ForgetPassword button;
     * - open PasswordResetPage;
     * - paste an email address into the field;
     * - click on Find button
     * - add waiting;
     * @throws InterruptedException
     */
    @Test
    public void basicPasswordResetPageTest () throws InterruptedException {

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");
        PasswordResetPage passwordResetPage = landingPage.getforgotPasswordClick();
        Assert.assertTrue(passwordResetPage.isPageLoaded(),  "PasswordReset page is not loaded" );
        passwordResetPage.emailAddingOnPasswordResetPage();

            }


}
