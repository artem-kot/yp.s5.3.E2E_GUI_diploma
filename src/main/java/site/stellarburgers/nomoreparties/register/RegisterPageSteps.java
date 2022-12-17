package site.stellarburgers.nomoreparties.register;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import site.stellarburgers.nomoreparties.constructor.ConstructorPageSteps;
import site.stellarburgers.nomoreparties.header.HeaderPageSteps;
import site.stellarburgers.nomoreparties.login.LoginPageSteps;

import static com.codeborne.selenide.Selenide.page;

public class RegisterPageSteps extends RegisterPage{

    public HeaderPageSteps header(){
        return page(HeaderPageSteps.class);
    }

    private RegisterPageSteps fillName(String name){
        registerPageInputFieldName.clear();
        registerPageInputFieldName.sendKeys(name);
        return page(RegisterPageSteps.class);
    }
    private RegisterPageSteps fillEmail(String email){
        registerPageInputFieldEmail.clear();
        registerPageInputFieldEmail.sendKeys(email);
        return page(RegisterPageSteps.class);
    }

    private RegisterPageSteps fillPassword(String password){
        registerPageInputFieldPassword.clear();
        registerPageInputFieldPassword.sendKeys(password);
        return page(RegisterPageSteps.class);
    }

    @Step("Registering with valid credentials")
    public LoginPageSteps validRegistration(String name, String email, String password){
        fillName(name)
                .fillEmail(email)
                .fillPassword(password)
                .registerPageRegisterButton.click();
        return page(LoginPageSteps.class);
    }

    @Step("Attempting to register with invalid credentials")
    public RegisterPageSteps invalidRegistration(String name, String email, String password){
        fillName(name)
                .fillEmail(email)
                .fillPassword(password)
                .registerPageRegisterButton.click();
        return page(RegisterPageSteps.class);
    }

    public String getRegisterErrorMessage(){
        registerPageInvalidPasswordErrorMessage.shouldBe(Condition.visible);
        return registerPageInvalidPasswordErrorMessage.getText();
    }

    @Step("Navigate to login page")
    public LoginPageSteps goToLogin(){
        registerPageLoginLink.click();
        return page(LoginPageSteps.class);
    }
}
