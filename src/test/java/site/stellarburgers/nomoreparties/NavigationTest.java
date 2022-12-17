package site.stellarburgers.nomoreparties;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import site.stellarburgers.nomoreparties.constructor.ConstructorPageSteps;
import site.stellarburgers.nomoreparties.header.HeaderPageSteps;
import site.stellarburgers.nomoreparties.profile.ProfilePageSteps;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Testing navigation functionality")
public class NavigationTest extends BaseTest {

    @Test
    @DisplayName("Test navigation to the main page and to the user profile")
    @Description("Navigating to registration, passing valid data, logging in, then:" +
            "1. Navigating to the profile." +
            "2. Navigating to the main page using constructor button." +
            "3. Navigating to the profile." +
            "4. Navigating to the main page using link in the logo. " +
            "Deleting profile after the test.")
    public void testHeaderLogin() {
        ConstructorPageSteps page = open(url, HeaderPageSteps.class)
                .goToLogin()
                .goToRegister()
                .validRegistration(name, email, validPassword)
                .validLogin(email, validPassword);

//        1. Navigating to the profile.
        ProfilePageSteps profilePage = page.header().goToProfile();
        assertThat(profilePage.getActiveChapterTitle(), equalTo(successfulRegistrationProfileTabName));

//        2. Navigating to the main page using constructor button.
        ConstructorPageSteps mainPage = profilePage.header().goToConstructor();
        assertThat(mainPage.getIngredientsTitle(), equalTo(ingredientsTittleText));

//        3.Navigating to the profile.
        profilePage = mainPage.header().goToProfile();
        assertThat(profilePage.getActiveChapterTitle(), equalTo(successfulRegistrationProfileTabName));

//        4. Navigating to the main page using link in the logo.
        mainPage = profilePage.header().goToLogo();
        assertThat(mainPage.getIngredientsTitle(), equalTo(ingredientsTittleText));

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
