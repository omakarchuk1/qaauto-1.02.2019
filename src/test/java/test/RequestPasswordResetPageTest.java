package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ChooseNewPasswordPage;
import page.RequestPasswordResetPage;
import page.RequestPasswordResetSubmitPage;

public class RequestPasswordResetPageTest extends BaseTest {

    //ChooseNewPasswordPage passwordResetFinalStepPage;
    ChooseNewPasswordPage chooseNewPasswordPage;
    private String newEmailPassword = "105cc742%";
    private String retypeNewEmailPassword = "105cc742%";

    /**
     * SuccessfulPasswordResetTest
     * Scenario:
     * -click on ForgetPassword button;
     * - open RequestPasswordResetPage;
     * - paste an email address into the field;
     * - click on Find button
     * - add waiting;
      */
    @Test
    public void successfulPasswordResetPageTest () {
        String userEmail = "om@projectsabrina.com";

        Assert.assertTrue(landingPage.isPageLoaded(), "Landing page is not loaded.");

        RequestPasswordResetPage requestPasswordResetPage = landingPage.clickOnForgotPasswordLink();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),  "PasswordReset page is not loaded" );

        RequestPasswordResetSubmitPage requestPasswordResetSubmitPage = requestPasswordResetPage.findAccount(userEmail);

        ChooseNewPasswordPage chooseNewPasswordPage = requestPasswordResetSubmitPage.navigateToLinkFromEmail();

        //Assert.assertTrue(passwordResetFinalStepPage.isPageLoaded());
        //passwordResetFinalStepPage.enterNewPassword(newEmailPassword, retypeNewEmailPassword);
        //Assert.assertTrue(this.chooseNewPasswordPage1.isPageLoaded());

            }


}
