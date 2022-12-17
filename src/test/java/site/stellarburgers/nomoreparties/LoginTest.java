package site.stellarburgers.nomoreparties;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.nomoreparties.header.HeaderPageSteps;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Testing login functionality")
public class LoginTest extends BaseTest {

    @Test
    @DisplayName("Test login via header button")
    @Description("Navigating to registration, passing valid data, logging in via button in the header, validating that login was successful. Deleting profile after the test.")
    public void testHeaderLogin() {
        assertThat(open(url, HeaderPageSteps.class)
                .goToLogin()
                .goToRegister()
                .validRegistration(name, email, validPassword)
                .header()
                .goToLogin()
                .validLogin(email, validPassword)
                .header()
                .goToProfile()
                .getActiveChapterTitle(),equalTo(successfulRegistrationProfileTabName));
        deleteTestUser();
    }

    @Test
    @DisplayName("Test login via main page button")
    @Description("Navigating to registration, passing valid data, logging in via button on the main page, validating that login was successful. Deleting profile after the test.")
    public void testMainPageLogin() {
        assertThat(open(url, HeaderPageSteps.class)
                .goToLogin()
                .goToRegister()
                .validRegistration(name, email, validPassword)
                .header()
                .goToConstructor()
                .waitUntilPageIsLoaded()
                .goToLogin()
                .validLogin(email, validPassword)
                .header()
                .goToProfile()
                .getActiveChapterTitle(),equalTo(successfulRegistrationProfileTabName));
        deleteTestUser();
    }

    @Test
    @DisplayName("Test login via link on registration page")
    @Description("Navigating to registration, passing valid data, logging in via button on the registration page, validating that login was successful. Deleting profile after the test.")
    public void testRegistrationPageLogin() {
        assertThat(open(url, HeaderPageSteps.class)
                .goToLogin()
                .goToRegister()
                .validRegistration(name, email, validPassword)
                .goToRegister()
                .goToLogin()
                .validLogin(email, validPassword)
                .header()
                .goToProfile()
                .getActiveChapterTitle(),equalTo(successfulRegistrationProfileTabName));
        deleteTestUser();
    }

    @Test
    @DisplayName("Test login via link on reset password page")
    @Description("Navigating to registration, passing valid data, logging in via button on the reset password page, validating that login was successful. Deleting profile after the test.")
    public void testResetPasswordPageLogin() {
        assertThat(open(url, HeaderPageSteps.class)
                .goToLogin()
                .goToRegister()
                .validRegistration(name, email, validPassword)
                .goToResetPassword()
                .goToLogin()
                .validLogin(email, validPassword)
                .header()
                .goToProfile()
                .getActiveChapterTitle(),equalTo(successfulRegistrationProfileTabName));
        deleteTestUser();
    }

}
