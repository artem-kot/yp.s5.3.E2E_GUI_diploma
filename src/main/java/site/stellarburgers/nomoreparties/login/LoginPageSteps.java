package site.stellarburgers.nomoreparties.login;

import com.codeborne.selenide.Condition;
import site.stellarburgers.nomoreparties.constructor.ConstructorPageSteps;
import site.stellarburgers.nomoreparties.header.HeaderPageSteps;
import site.stellarburgers.nomoreparties.profile.ProfilePage;
import site.stellarburgers.nomoreparties.profile.ProfilePageSteps;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.page;

public class LoginPageSteps extends LoginPage{

    public HeaderPageSteps header(){
        return page(HeaderPageSteps.class);
    }

    public LoginPageSteps fillEmail(String email){
        loginPageInputFieldEmail.clear();
        loginPageInputFieldEmail.sendKeys(email);
        return page(LoginPageSteps.class);
    }

    public LoginPageSteps fillPassword(String password){
        loginPageInputFieldPassword.clear();
        loginPageInputFieldPassword.sendKeys(password);
        return page(LoginPageSteps.class);
    }

    public ConstructorPageSteps validLogin(String email, String password){
        fillEmail(email);
        fillPassword(password);
        loginPageLoginButton.click();
        return page(ConstructorPageSteps.class);
    }

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
}
