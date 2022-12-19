package site.stellarburgers.nomoreparties;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.nomoreparties.pom.HeaderPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Testing registration functionality")
public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Test successful registration")
    @Description("Navigating to registration, passing valid data, logging in, validating that new user profile was successfully created. Deleting profile after the test.")
    public void testSuccessfulRegistration() {
        assertThat(open(url, HeaderPage.class)
                .goToLogin()
                .goToRegister()
                .validRegistration(name, email, validPassword)
                .validLogin(email, validPassword)
                .header()
                .goToProfile()
                .getActiveChapterTitle(), equalTo(successfulRegistrationProfileTabName));
        deleteTestUser();
    }

    @Test
    @DisplayName("Test unsuccessful registration")
    @Description("Navigating to registration, passing invalid data, checking error message.")
    public void testUnsuccessfulRegistration() {
        assertThat(open(url, HeaderPage.class)
                .goToLogin()
                .goToRegister()
                .validRegistration(name, email, invalidPassword)
                .getLoginErrorMessage(), equalTo(invalidPasswordErrorMessage));
    }


}
