package site.stellarburgers.nomoreparties.login;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import site.stellarburgers.nomoreparties.constructor.ConstructorPageSteps;
import site.stellarburgers.nomoreparties.header.HeaderPageSteps;
import site.stellarburgers.nomoreparties.profile.ProfilePage;
import site.stellarburgers.nomoreparties.profile.ProfilePageSteps;
import site.stellarburgers.nomoreparties.register.RegisterPageSteps;
import site.stellarburgers.nomoreparties.reset_password.ResetPasswordPageSteps;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;

public class LoginPageSteps extends LoginPage{

    public HeaderPageSteps header(){
        return page(HeaderPageSteps.class);
    }

    private LoginPageSteps fillEmail(String email){
        loginPageInputFieldEmail.clear();
        loginPageInputFieldEmail.sendKeys(email);
        return page(LoginPageSteps.class);
    }

    private LoginPageSteps fillPassword(String password){
        loginPageInputFieldPassword.clear();
        loginPageInputFieldPassword.sendKeys(password);
        return page(LoginPageSteps.class);
    }

    @Step("Login with valid credentials")
    public ConstructorPageSteps validLogin(String email, String password){
        fillEmail(email);
        fillPassword(password);
        loginPageLoginButton.click();
        return page(ConstructorPageSteps.class);
    }

    @Step("Attempt to login with invalid credentials")
    public LoginPageSteps invalidLogin(String email, String password){
        fillEmail(email);
        fillPassword(password);
        loginPageLoginButton.click();
        return page(LoginPageSteps.class);
    }

    public String getLoginErrorMessage(){
        loginPageInvalidPasswordErrorMessage.shouldBe(Condition.visible);
        return loginPageInvalidPasswordErrorMessage.getText();
    }

    @Step("Navigate to register page")
    public RegisterPageSteps goToRegister(){
        loginPageRegisterLink.click();
        return page(RegisterPageSteps.class);
    }

    @Step("Navigate to reset password page")
    public ResetPasswordPageSteps goToResetPassword(){
        loginPageResetPasswordLink.click();
        return page(ResetPasswordPageSteps.class);
    }
}
