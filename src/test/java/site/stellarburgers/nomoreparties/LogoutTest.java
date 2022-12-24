package site.stellarburgers.nomoreparties;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.nomoreparties.pom.HeaderPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Testing logout functionality")
public class LogoutTest extends BaseTest {

    @Test
    @DisplayName("Test logout from the profile")
    @Description("Navigating to registration, passing valid data, logging in, navigating to the profile, logging out." +
            "Validating successful logout. Deleting profile after the test.")
    public void testLogout() {
        assertThat(open(url, HeaderPage.class)
                .goToLogin()
                .goToRegister()
                .validRegistration(name, email, validPassword)
                .validLogin(email, validPassword)
                .header()
                .goToProfile()
                .logout()
                .getLoginPageTitle(), equalTo(loginPageTitle));

        deleteTestUser();
    }
}
