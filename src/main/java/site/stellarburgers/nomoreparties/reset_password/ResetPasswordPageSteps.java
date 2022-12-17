package site.stellarburgers.nomoreparties.reset_password;

import io.qameta.allure.Step;
import site.stellarburgers.nomoreparties.header.HeaderPageSteps;
import site.stellarburgers.nomoreparties.login.LoginPageSteps;

import static com.codeborne.selenide.Selenide.page;

public class ResetPasswordPageSteps extends ResetPasswordPage{

    public HeaderPageSteps header(){
        return page(HeaderPageSteps.class);
    }

    public ResetPasswordPageSteps fillEmail(String email){
        resetPasswordPageInputFieldEmail.clear();
        resetPasswordPageInputFieldEmail.sendKeys(email);
        return page(ResetPasswordPageSteps.class);
    }

    @Step("Navigate to login page")
    public LoginPageSteps goToLogin(){
        resetPasswordPageLoginLink.click();
        return page(LoginPageSteps.class);
    }
}
